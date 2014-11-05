package org.openurp.teach.ws

import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.webmvc.api.annotation.{ mapping, response }
import org.beangle.webmvc.entity.action.{ AbstractEntityAction, RestfulService }
import org.openurp.base.domain.SemesterBean
import org.openurp.teach.{ Course, CourseGrade, CourseHour, ExamGrade }
import org.openurp.teach.domain.{ CourseBean, CourseGradeBean }
import org.openurp.teach.domain.code.{ CourseTakeTypeBean, CourseTypeBean }
import org.openurp.teach.domain.ExamGradeBean
import org.openurp.teach.domain.code.GradeTypeBean
import org.openurp.teach.domain.code.ExamTypeBean
import org.openurp.teach.domain.code.ScoreMarkStyleBean

class CourseAction extends RestfulService[Course]

class CourseGradeAction extends AbstractEntityAction[CourseGrade] {

  @response
  @mapping(value = "{code}")
  def index(code: String): Seq[CourseGrade] = {
    val builder = OqlBuilder.from(classOf[CourseGrade], "cg")
    builder.where("cg.std.code=:code", code)
    entityDao.search(builder)
  }
}

class StdCourseGradeAction extends AbstractEntityAction[CourseGrade] {

  @response
  def index(): Any = {
    val builder = OqlBuilder.from(classOf[CourseGrade], "cg")
    builder.where("cg.std.code=:code", "2012134135")
    val courseGrades = entityDao.search(builder)
    val thinGrades = new collection.mutable.ListBuffer[java.util.Properties]
    for (grade <- courseGrades) {
      val newGrade = new java.util.Properties
      val course = grade.course
      val semester = grade.semester
      val newCourse = new java.util.Properties
      newCourse.put("id", course.id)
      newCourse.put("code", course.code)
      newCourse.put("name", course.name)
      newCourse.put("credits", Float.box(course.credits))
      newGrade.put("course", newCourse)
      newGrade.put("semester", new SemesterBean(semester.id, semester.code, semester.schoolYear, semester.name))
      newGrade.put("gp", if (grade.gp == null) "" else Float.box(grade.gp))
      newGrade.put("lessonNo", grade.lessonNo)
      newGrade.put("passed", java.lang.Boolean.valueOf(grade.passed))
      newGrade.put("score", grade.score)
      newGrade.put("scoreText", if (null == grade.scoreText) "" else grade.scoreText)
      newGrade.put("status", Integer.valueOf(grade.status))
      newGrade.put("courseType", new CourseTypeBean(grade.courseType.id, grade.courseType.code, grade.courseType.name, grade.courseType.enName))
      newGrade.put("courseTakeType", new CourseTakeTypeBean(grade.courseTakeType.id, grade.courseTakeType.code, grade.courseTakeType.name, grade.courseTakeType.enName))

      val examGrades = new collection.mutable.HashSet[ExamGrade]
      newGrade.put("examGrades", examGrades)
      for (eg <- grade.examGrades) {
        val gradeType = new GradeTypeBean(eg.gradeType.id, eg.gradeType.code, eg.gradeType.name, eg.gradeType.enName)
        val markStyle = new ScoreMarkStyleBean(eg.markStyle.id, eg.markStyle.code, eg.markStyle.name, eg.markStyle.enName)
        val newExamGrade = new ExamGradeBean(eg.id, gradeType, eg.score, eg.scoreText, markStyle, eg.passed, eg.status)
        examGrades += newExamGrade
      }

      thinGrades += newGrade
    }
    thinGrades
  }
}

class CourseHourAction extends RestfulService[CourseHour]