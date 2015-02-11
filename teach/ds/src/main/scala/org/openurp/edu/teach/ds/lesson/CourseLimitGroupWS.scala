package org.openurp.edu.teach.ds.lesson

import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.webmvc.api.annotation.{ mapping, response }
import org.beangle.webmvc.entity.action.RestfulService
import org.openurp.edu.teach.lesson.{ CourseLimitGroup, Lesson }

class CourseLimitGroupWS extends RestfulService[CourseLimitGroup] {

  @response
  @mapping("semester/{semesterId}")
  def semester(semesterId: Integer): Any = {
    val query = OqlBuilder.from(classOf[Lesson]).where("lesson.semester.id=:semesterId", semesterId)
    query.join("lesson.teachClass.limitGrouops", "limitGroup")
    query.select("limitGroup")
    //FIXEDME
    //    put("properties", OutputProperties.courseLimitGroups(isRequestCsv))
    query.limit(getPageLimit)
    entityDao.search(query)
  }

  @response
  @mapping("lesson/{lessonId}")
  def lesson(lessonId: Integer): Any = {
    val query = OqlBuilder.from(classOf[Lesson]).where("lesson.id=:lessonId", lessonId)
    query.join("lesson.teachClass.limitGrouops", "limitGroup")
    query.select("limitGroup")
    //FIXEDME
    //    put("properties", OutputProperties.courseLimitGroups(isRequestCsv))
    entityDao.search(query)
  }
}