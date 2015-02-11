package org.openurp.edu.teach.ds.grade

import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.webmvc.api.annotation.{ mapping, response }
import org.beangle.webmvc.entity.action.{ AbstractEntityAction, RestfulService }
import org.openurp.edu.teach.{ Course, CourseHour }
import org.openurp.edu.teach.grade.CourseGrade
import org.beangle.webmvc.api.context.Params
import org.beangle.webmvc.api.annotation.param
import org.beangle.data.model.Entity
import org.openurp.edu.teach.ds.lesson.OutputProperties

class CourseWS extends RestfulService[Course]

class CourseGradeWS extends AbstractEntityAction[CourseGrade] {

  @response
  @mapping(value = "{stdId}")
  def std(@param("stdId") stdId: String): Seq[CourseGrade] = {
    val builder = OqlBuilder.from(classOf[CourseGrade], "cg")
    builder.where("cg.std.id=:stdId", stdId.toLong)
    builder.where("cg.project.code = :project", Params.get("project").get)
    entityDao.search(builder)
 }
}

class CourseHourWS extends RestfulService[CourseHour]