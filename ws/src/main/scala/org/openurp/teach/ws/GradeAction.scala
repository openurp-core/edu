package org.openurp.teach.ws

import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.data.serializer.io.json.JsonObject
import org.beangle.webmvc.api.annotation.{ mapping, response }
import org.beangle.webmvc.entity.action.{ AbstractEntityAction, RestfulService }
import org.openurp.base.domain.SemesterBean
import org.openurp.teach.{ Course, CourseGrade, CourseHour, ExamGrade }
import org.openurp.teach.domain.ExamGradeBean
import org.openurp.teach.domain.code.{ CourseTakeTypeBean, CourseTypeBean, GradeTypeBean, ScoreMarkStyleBean }
import org.beangle.data.serializer.io.json.MyJsonObject
import org.beangle.webmvc.api.context.ContextHolder

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
    val nameAttr = if (ContextHolder.context.locale.getLanguage() == "en") "enName->name" else "name"
    val builder = OqlBuilder.from(classOf[CourseGrade], "cg")
    builder.where("cg.std.code=:code", "2012134135")
    val courseGrades = entityDao.search(builder)
    val thinGrades = new collection.mutable.ListBuffer[MyJsonObject]
    for (grade <- courseGrades) {
      val newGrade = new MyJsonObject(grade, "gp", "lessonNo", "passed", "score", "scoreText", "status")
      newGrade.add("course", grade.course, "id", "code", nameAttr, "credits")
      newGrade.add("semester", grade.semester, "id", "code", "schoolYear", "name")
      newGrade.add("courseType", grade.courseType, "id", "code", nameAttr)
      newGrade.add("courseTakeType", grade.courseTakeType, "id", "code", nameAttr)

      val examGrades = new collection.mutable.HashSet[Any]
      newGrade.put("examGrades", examGrades)
      for (eg <- grade.examGrades) {
        val newExamGrade = new MyJsonObject(eg, "id", "passed", "status", "score", "scoreText")
        newExamGrade.add("gradeType", eg.gradeType, "id", "code", nameAttr)
        newExamGrade.add("markStyle", eg.markStyle, "id", "code", nameAttr)
        examGrades += newExamGrade
      }
      thinGrades += newGrade
    }
    thinGrades
  }
}

class CourseHourAction extends RestfulService[CourseHour]