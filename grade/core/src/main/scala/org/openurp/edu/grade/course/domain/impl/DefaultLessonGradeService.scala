package org.openurp.edu.grade.course.domain.impl

import scala.collection.mutable.Buffer

import org.beangle.data.dao.{ EntityDao, Operation, OqlBuilder }
import org.beangle.data.model.annotation.code
import org.openurp.edu.grade.code.model.GradeType
import org.openurp.edu.grade.course.domain.{ ScoreCalculator, CourseGradePublishStack, CourseGradeSettings, GradeCourseTypeProvider, LessonGradeService }
import org.openurp.edu.grade.course.model.{ CourseGrade, CourseGradeState, ExamGrade, ExamGradeState, GaGrade, GaGradeState }
import org.openurp.edu.grade.model.Grade
import org.openurp.edu.grade.model.Grade.Status.{ New, Published }
import org.openurp.edu.grade.model.GradeState
import org.openurp.edu.lesson.model.Lesson

class DefaultLessonGradeService extends LessonGradeService {

  var entityDao: EntityDao = _

  var calculator: ScoreCalculator = _

  var gradeCourseTypeProvider: GradeCourseTypeProvider = _

  var publishStack: CourseGradePublishStack = _

  var settings: CourseGradeSettings = _

  private def getGrades(lesson: Lesson): Seq[CourseGrade] = {
    val query = OqlBuilder.from(classOf[CourseGrade], "courseGrade")
    query.where("courseGrade.lesson = :lesson", lesson)
    entityDao.search(query)
  }

  def getState(lesson: Lesson): CourseGradeState = {
    val list = entityDao.findBy(classOf[CourseGradeState], "lesson", List(lesson))
    if (list.isEmpty) null
    else list(0)
  }

  /**
   * 发布学生成绩
   */
  def publish(lessonIds: Iterable[Long], gradeTypes: Array[GradeType], isPublished: Boolean) {
    val lessons = entityDao.find(classOf[Lesson], lessonIds)
    if (!lessons.isEmpty) {
      val setting = settings.getSetting(lessons(0).project)
      if (setting.submitIsPublish) {
        for (lesson <- lessons) {
          updateState(lesson, gradeTypes, if (isPublished) Grade.Status.Published else Grade.Status.New)
        }
      } else {
        for (lesson <- lessons) {
          updateState(lesson, gradeTypes, if (isPublished) Grade.Status.Published else Grade.Status.Confirmed)
        }
      }
    }
  }

  /**
   * 依据状态调整成绩
   */
  def recalculate(gradeState: CourseGradeState) {
    if (null == gradeState) {
      return
    }
    val published = new collection.mutable.ListBuffer[GradeType]
    for (egs <- gradeState.gaStates if egs.status == Published) published += egs.gradeType
    val grades = getGrades(gradeState.lesson)
    for (grade <- grades) {
      updateGradeState(grade, gradeState)
      for (state <- gradeState.examStates) {
        val gradeType = state.gradeType
        val examGrade = grade.getGrade(gradeType).asInstanceOf[ExamGrade]
        val examState = gradeState.getState(gradeType).asInstanceOf[ExamGradeState]
        if (examGrade != null && examState != null) {
          examGrade.percent = examState.percent
          updateGradeState(examGrade, examState)
        }
      }
      for (state <- gradeState.gaStates) {
        val gradeType = state.gradeType
        val gaGrade = grade.getGrade(gradeType)
        val gaState = gradeState.getState(gradeType)
        updateGradeState(gaGrade, gaState)
      }
      calculator.calc(grade)
    }
    entityDao.saveOrUpdate(grades)
    if (!published.isEmpty) publish(Array(gradeState.lesson.id), published.toArray, true)
  }

  def remove(lesson: Lesson, gradeType: GradeType) {
    val state = getState(lesson).asInstanceOf[CourseGradeState]
    val courseGrades = entityDao.findBy(classOf[CourseGrade], "lesson", List(lesson))
    val gradeSetting = settings.getSetting(lesson.project)
    val save = new collection.mutable.ListBuffer[Any]
    val remove = new collection.mutable.ListBuffer[Any]
    for (courseGrade <- courseGrades) {
      val examGrades = courseGrade.examGrades.asInstanceOf[Buffer[ExamGrade]]
      if (GradeType.Final == gradeType.id) {
        if (New == courseGrade.status) remove += courseGrade
      } else if (gradeType.isGa) {
        for (`type` <- gradeSetting.getRemovableElements(gradeType)) {
          val exam = courseGrade.getGrade(`type`).asInstanceOf[ExamGrade]
          if (null != exam && New == exam.status) examGrades -= exam
        }
        val ga = courseGrade.getGrade(gradeType).asInstanceOf[GaGrade]
        if (null != ga && New == ga.status) courseGrade.gaGrades.asInstanceOf[Buffer[GaGrade]] -= ga
        if (!examGrades.isEmpty || !courseGrade.gaGrades.isEmpty) {
          calculator.calc(courseGrade)
          save += courseGrade
        } else {
          remove += courseGrade
        }
      } else {
        val examGrade = courseGrade.getGrade(gradeType).asInstanceOf[ExamGrade]
        if (null != examGrade && New == examGrade.status) {
          examGrades -= examGrade
          if (!examGrades.isEmpty || !courseGrade.gaGrades.isEmpty) {
            calculator.calc(courseGrade)
            save += courseGrades
          } else {
            remove += courseGrade
          }
        }
      }
    }
    if (null != state) {
      if (GradeType.Final == gradeType.id) {
        state.status = New
        state.gaStates.clear()
        state.examStates.clear()
      } else {
        if (gradeType.isGa) {
          state.status = New
          for (`type` <- gradeSetting.getRemovableElements(gradeType)) {
            state.examStates.remove(state.getState(`type`).asInstanceOf[ExamGradeState])
          }
          state.gaStates.remove(state.getState(gradeType).asInstanceOf[GaGradeState])
        } else {
          state.examStates.remove(state.getState(gradeType).asInstanceOf[ExamGradeState])
        }
      }
      if (state.gaStates.isEmpty && state.examStates.isEmpty) {
        remove += state
      } else {
        save += state
      }
    }
    entityDao.execute(Operation.saveOrUpdate(save).remove(remove))
  }

  /**
   * 依据状态信息更新成绩的状态和记录方式
   *
   * @param grade
   * @param state
   */
  private def updateGradeState(grade: Grade, state: GradeState) {
    if (null != grade && null != state) {
      grade.markStyle = state.markStyle
      grade.status = state.status
    }
  }

  private def updateState(lesson: Lesson, gradeTypes: Array[GradeType], status: Int) {
    val courseGradeStates = entityDao.findBy(classOf[CourseGradeState], "lesson", List(lesson))
    var gradeState: CourseGradeState = null
    for (gradeType <- gradeTypes) {
      gradeState = if (courseGradeStates.isEmpty) new CourseGradeState else courseGradeStates(0)
      if (gradeType.id == GradeType.Final) {
        gradeState.status = status
      } else {
        gradeState.updateStatus(gradeType, status)
      }
    }
    val grades = entityDao.findBy(classOf[CourseGrade], "lesson", List(lesson))
    val toBeSaved = new collection.mutable.HashSet[Operation]
    val published = new collection.mutable.HashSet[CourseGrade]
    for (grade <- grades; gradeType <- gradeTypes) {
      if (gradeType.id == GradeType.Final) {
        grade.asInstanceOf[CourseGrade].status = status
      } else {
        val examGrade = grade.getGrade(gradeType)
        if (null != examGrade) {
          examGrade.status = status
          published.add(grade)
        }
      }
    }
    if (status == Grade.Status.Published) toBeSaved ++= publishStack.onPublish(published, gradeState, gradeTypes)
    toBeSaved ++= Operation.saveOrUpdate(lesson, gradeState).saveOrUpdate(published).build()
    entityDao.execute(toBeSaved.toArray: _*)
  }

}