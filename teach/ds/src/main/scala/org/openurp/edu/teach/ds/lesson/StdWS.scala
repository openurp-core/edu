package org.openurp.edu.teach.ds.lesson

import org.openurp.base.Semester
import org.beangle.commons.lang.JLong
import org.beangle.webmvc.api.action.ActionSupport
import org.beangle.webmvc.api.context.Params
import org.openurp.edu.teach.lesson.CourseTake
import org.beangle.webmvc.api.annotation.response
import org.beangle.data.jpa.dao.OqlBuilder
import org.openurp.edu.base.Student
import org.beangle.data.model.dao.EntityDao

class StdWS(entityDao: EntityDao) extends ActionSupport {

  @response
  def index(): Any = {
    val std: Student = getLong("std.id") match {
      case Some(stdId) => entityDao.get(classOf[Student], new JLong(stdId))
      case _ =>
        val stdCode = get("std.code")
        val projectId = get("project")
        if (!stdCode.isEmpty && !projectId.isEmpty) {
          val stdQuery = OqlBuilder.from(classOf[Student], "s")
          stdQuery.where("s.code=:code", stdCode.get)
          stdQuery.where("s.project.code=:projectcode", projectId.get)
          val stds = entityDao.search(stdQuery)
          if (stds.isEmpty) null.asInstanceOf[Student] else stds.head
        } else {
          null.asInstanceOf[Student]
        }
    }

    if (null == std) {
      List.empty
    } else {
      val query = OqlBuilder.from(classOf[CourseTake], "ct")
      query.where("ct.std=:std", std)
      Params.getInt("semester.id") match {
        case Some(semesterId) => query.where("ct.semester.id = :semesterId", semesterId)
        case _ => {
          val semesterQuery = OqlBuilder.from(classOf[Semester], "s")
          semesterQuery.where(" s.endOn >= :enrollOn and s.beginOn <= :graduateOn", std.enrollOn, std.graduateOn)
          query.where("ct.semester  in (:semesters)", entityDao.search(semesterQuery))
        }
      }
      put("properties", OutputProperties.courseTakes(isRequestCsv))
      entityDao.search(query)
    }
  }
}