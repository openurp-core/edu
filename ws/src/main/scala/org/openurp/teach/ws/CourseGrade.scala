package org.openurp.teach.ws

import org.beangle.webmvc.entity.action.RestfulService
import org.openurp.teach.{Course, CourseGrade, CourseHour}
import org.beangle.webmvc.api.context.Params
import org.beangle.webmvc.api.annotation.mapping
import org.beangle.webmvc.api.annotation.response
import org.beangle.webmvc.api.annotation.param

class CourseAction extends RestfulService[Course]

class CourseGradeAction extends RestfulService[CourseGrade]{
  
  @response
  override def index(): Seq[CourseGrade] = {
    getInt("page") match {
      case Some(p) => entityDao.search(getQueryBuilder())
      case None => entityDao.search(getQueryBuilder().limit(null))
    }
  }

  @response
  @mapping(value = "{id}")
  override def info(@param("id") code: String): CourseGrade = {
    val entityCode = Params.converter.convert(code, entityMetaData.getType(entityName).get.idType)
    getModel[CourseGrade](entityName, entityCode)
  }

}

class CourseHourAction extends RestfulService[CourseHour]