package org.openurp.teach.ws

import org.beangle.webmvc.entity.action.RestfulService
import org.openurp.teach.{ Course, CourseGrade, CourseHour }
import org.beangle.webmvc.api.context.Params
import org.beangle.webmvc.api.annotation.mapping
import org.beangle.webmvc.api.annotation.response
import org.beangle.webmvc.api.annotation.param
import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.webmvc.entity.action.AbstractEntityAction

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

class CourseHourAction extends RestfulService[CourseHour]