package org.openurp.edu.teach.ds.lesson

import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.data.model.Entity
import org.beangle.webmvc.api.annotation.{ mapping, response }
import org.beangle.webmvc.entity.action.RestfulService
import org.openurp.edu.teach.lesson.{ LessonLimitItem, Lesson }

class LessonLimitItemWS extends RestfulService[LessonLimitItem] {

  @response
  @mapping("semester/{semesterId}")
  def semester(semesterId: Integer): Any = {
    val query = OqlBuilder.from(classOf[Lesson]).where("lesson.semester.id=:semesterId", semesterId)
    query.join("lesson.teachClass.limitGrouops.items", "limitItem")
    query.select("limitItem")

    getInt("group.id") match {
      case Some(groupId) => query.where("limitItem.group.id=:groupId", groupId)
      case _ => query.limit(getPageLimit)
    }
    put("properties", List(classOf[LessonLimitItem] -> List("meta", "group", "operator", "content"),
      classOf[Entity[_]] -> List("id")))
    entityDao.search(query)
  }
}