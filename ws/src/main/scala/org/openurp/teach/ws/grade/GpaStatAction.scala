package org.openurp.teach.ws.grade

import org.beangle.webmvc.api.action.ActionSupport
import org.beangle.webmvc.api.annotation.param
import org.openurp.teach.grade.service.GpaStatService
import org.beangle.webmvc.api.annotation.response
import org.beangle.webmvc.api.annotation.mapping
import org.beangle.data.jpa.dao.OqlBuilder
import org.openurp.teach.core.Student
import org.beangle.data.model.dao.EntityDao
import org.openurp.base.Semester
import org.beangle.commons.collection.Properties
import org.openurp.teach.grade.domain.StdSemesterGpa

class GpaStatAction extends ActionSupport {

  var service: GpaStatService = _
  var entityDao: EntityDao = _

  @response
  @mapping(value = "{code}")
  def index(@param("code") code: String): Any = {
    val builder = OqlBuilder.from(classOf[Student])
    builder.where("student.code=:code", code)
    val std = entityDao.search(builder)(0)
    val list = service.statGpa(std)
    val gpa = new Properties(list, "ga", "gpa", "credits", "totalCredits", "count")
    
    val yearGpas = new collection.mutable.ListBuffer[Properties]
    gpa.put("yearGpas", yearGpas)
    for (yearGa <- list.yearGpas) {
      val yearGpa = new Properties(yearGa, "ga", "gpa", "credits", "totalCredits", "count","schoolYear")
      yearGpas += yearGpa
    }
    
    val semesterGpas = new collection.mutable.ListBuffer[Properties]
    gpa.put("semesterGpas", semesterGpas)
    for (x <- list.semesterGpas ){
      val semesterGpa = new Properties(x, "ga", "gpa", "credits", "totalCredits", "count")
      semesterGpa.add("semester", x.semester , "id","name","schoolYear","code")
      semesterGpas += semesterGpa
    }
    gpa
  }
}