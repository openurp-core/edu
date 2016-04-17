package org.openurp.edu.teach.ws.lesson

import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.webmvc.api.annotation.{ mapping, response }
import org.beangle.webmvc.entity.action.RestfulService
import org.openurp.edu.teach.lesson.Lesson
import org.beangle.webmvc.api.annotation.param

class LessonWS extends RestfulService[Lesson] {

  @response
  @mapping("semester/{semesterId}")
  def semester(@param("semesterId") semesterId: Integer): Any = {
    val query = OqlBuilder.from(classOf[Lesson]).where("lesson.semester.id=:semesterId", semesterId)
    //FIXEDME
    //    put("properties", OutputProperties.lessons(isRequestCsv))
    query.limit(getPageLimit)
    entityDao.search(query)
  }
}