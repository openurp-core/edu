package org.openurp.edu.teach.ds.code

import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.data.model.dao.EntityDao
import org.beangle.webmvc.api.action.EntityActionSupport
import org.beangle.webmvc.api.annotation.response
import org.openurp.code.BaseCode
import org.beangle.data.model.Entity
import org.beangle.commons.http.accept.ContentNegotiationManager
import org.beangle.webmvc.entity.action.RestfulService

class AbstractWS[T <: BaseCode] extends RestfulService[T] {

  @response
  override def index(): Any = {
    val builder = OqlBuilder.from(entityType, "code")
    builder.orderBy(get("orderBy", "code.code"))
    buildQuery(builder)
    //if (this.isRequestCsv) put("properties", List(classOf[BaseCode] -> List("id", "code","name"), classOf[Entity[_]] -> List("id")))
    entityDao.search(builder)
  }

  def buildQuery(builder: OqlBuilder[T]): Unit = {

  }
}