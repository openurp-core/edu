package org.openurp.teach.ws.grade

import org.beangle.commons.collection.Properties
import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.webmvc.api.annotation.{mapping, param, response}
import org.beangle.webmvc.api.context.ContextHolder
import org.beangle.webmvc.entity.action.{AbstractEntityAction, RestfulService}
import org.openurp.teach.core.Course
import org.openurp.teach.grade.CourseGrade

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
    builder.where("cg.std.code=:code", "2007137130")
    val courseGrades = entityDao.search(builder)
    val thinGrades = new collection.mutable.ListBuffer[Properties]
    for (grade <- courseGrades) {
      val newGrade = new Properties(grade, "gp", "lessonNo", "passed", "score", "scoreText", "status")
      newGrade.add("course", grade.course, "id", "code", nameAttr, "credits")
      newGrade.add("semester", grade.semester, "id", "code", "schoolYear", "name")
      newGrade.add("courseType", grade.courseType, "id", "code", nameAttr)
      newGrade.add("courseTakeType", grade.courseTakeType, "id", "code", nameAttr)

      val examGrades = new collection.mutable.HashSet[Any]
      newGrade.put("examGrades", examGrades)
      for (eg <- grade.examGrades) {
        val newExamGrade = new Properties(eg, "id", "passed", "status", "score", "scoreText")
        newExamGrade.add("gradeType", eg.gradeType, "id", "code", nameAttr)
        newExamGrade.add("markStyle", eg.markStyle, "id", "code", nameAttr)
        examGrades += newExamGrade
      }
      thinGrades += newGrade
    }
    thinGrades
  }
}

class LsCourseGradeAction extends AbstractEntityAction[CourseGrade] {

  @response
  @mapping(value = "{id}")
  def index(@param("id") id: String): Any = {
    val builder = OqlBuilder.from(classOf[CourseGrade], "cg")
    builder.where("cg.lessonNo=:id", id)
    val courseGrades = entityDao.search(builder)
    val thinGrades = new collection.mutable.ListBuffer[Properties]
    for (grade <- courseGrades) {
      val newGrade = new Properties(grade, "gp", "lessonNo", "passed", "score", "scoreText", "status")
      newGrade.add("course", grade.course, "id", "code", "name", "credits")
      newGrade.add("semester", grade.semester, "id", "code", "schoolYear", "name")
      newGrade.add("courseType", grade.courseType, "id", "code", "name")
      newGrade.add("courseTakeType", grade.courseTakeType, "id", "code", "name")
      newGrade.add("student", grade.std, "id","code","name")

      val examGrades = new collection.mutable.HashSet[Any]
      newGrade.put("examGrades", examGrades)
      for (eg <- grade.examGrades) {
        val newExamGrade = new Properties(eg, "id", "passed", "status", "score", "scoreText")
        newExamGrade.add("gradeType", eg.gradeType, "id", "code", "name")
        newExamGrade.add("markStyle", eg.markStyle, "id", "code", "name")
        examGrades += newExamGrade
      }
      thinGrades += newGrade
    }
    thinGrades
  }
}
