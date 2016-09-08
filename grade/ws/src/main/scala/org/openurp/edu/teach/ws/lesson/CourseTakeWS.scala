package org.openurp.edu.teach.ws.lesson

import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.webmvc.api.annotation.{ mapping, response }
import org.beangle.webmvc.entity.action.RestfulService
import org.openurp.edu.teach.lesson.CourseTake
import org.beangle.data.model.Entity
import org.beangle.webmvc.api.annotation.param
import org.beangle.webmvc.api.context.Params

class CourseTakeWS extends RestfulService[CourseTake] {

  @response
  @mapping("semester/{semesterId}")
  def semester(@param("semesterId") semesterId: Integer): Any = {
    val query = OqlBuilder.from(classOf[CourseTake], "ct")
    query.where("ct.semester.id=:semester", semesterId)
    query.where("ct.std.project.code = :project", Params.get("project").get)
    put("properties", OutputProperties.courseTakes(isRequestCsv))
    query.limit(getPageLimit)
    entityDao.search(query)
  }

  @response
  @mapping("lesson/{lessonId}")
  def lesson(@param("lessonId") lessonId: Integer): Any = {
    val query = OqlBuilder.from(classOf[CourseTake], "ct")
    query.where("ct.lesson.id=:lessonId", lessonId)
    query.where("ct.std.project.code = :project", Params.get("project").get)
    put("properties", OutputProperties.courseTakes(isRequestCsv))
    entityDao.search(query)
  }
}