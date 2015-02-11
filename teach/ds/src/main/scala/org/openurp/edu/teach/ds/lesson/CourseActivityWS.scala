package org.openurp.edu.teach.ds.lesson

import org.beangle.webmvc.api.annotation.mapping
import org.beangle.webmvc.api.annotation.response
import org.beangle.webmvc.entity.action.RestfulService
import org.beangle.data.jpa.dao.OqlBuilder
import org.openurp.edu.teach.lesson.Lesson
import org.openurp.edu.teach.schedule.CourseActivity

class CourseActivityWS extends RestfulService[CourseActivity] {

  @response
  @mapping("semester/{semesterId}")
  def semester(semesterId: Integer): Any = {
    val query = OqlBuilder.from(classOf[Lesson]).where("lesson.semester.id=:semesterId", semesterId)
    query.join("lesson.schedule.activities", "activity")
    query.select("activity")
    //FIXEDME
//    put("properties", OutputProperties.courseActivities(isRequestCsv))
    query.limit(getPageLimit)
    entityDao.search(query)
  }

  @response
  @mapping("lesson/{lessonId}")
  def lesson(lessonId: Integer): Any = {
    val query = OqlBuilder.from(classOf[Lesson]).where("lesson.id=:lessonId", lessonId)
    query.join("lesson.schedule.activities", "activity")
    query.select("activity")
    //FIXEDME
//    put("properties", OutputProperties.courseActivities(isRequestCsv))
    entityDao.search(query)
  }
}