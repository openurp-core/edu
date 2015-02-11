package org.openurp.edu.teach.ds.lesson

import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.webmvc.api.action.ActionSupport
import org.beangle.webmvc.api.annotation.{ mapping, response }
import org.openurp.edu.teach.lesson.Lesson
import org.beangle.data.model.dao.EntityDao
import org.beangle.webmvc.api.annotation.param
import org.beangle.webmvc.api.context.Params

class TeachersWS(entityDao: EntityDao) extends ActionSupport {

  @response
  @mapping("semester/{semesterId}")
  def semester(@param("semesterId") semesterId: Integer): Any = {
    val query = OqlBuilder.from(classOf[Lesson], "lesson").join("lesson.teachers", "t")
    query.where("lesson.semester.id=:semesterId", semesterId)
    query.where("lesson.project.code = :project", Params.get("project").get)
    query.select("new org.openurp.edu.teach.ds.lesson.LessonTeacher(lesson.id,t.id,index(t))")
    put("properties", List(classOf[LessonTeacher] -> List("lessonId", "teacherId", "idx")))
    entityDao.search(query)
  }

  @response
  @mapping("lesson/{lessonId}")
  def lesson(@param("lessonId") lessonId: Integer): Any = {
    val query = OqlBuilder.from(classOf[Lesson], "lesson").join("lesson.teachers", "t")
    query.where("lesson.id=:lessonId", lessonId)
    query.where("lesson.project.code = :project", Params.get("project").get)
    query.select("new org.openurp.edu.teach.ds.lesson.LessonTeacher(lesson.id,t.id,index(t))")
    put("properties", List(classOf[LessonTeacher] -> List("lessonId", "teacherId", "idx")))
    entityDao.search(query)
  }
}

class LessonTeacher(val lessonId: Integer, val teacherId: Integer, val idx: Int) {

}