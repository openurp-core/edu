package org.openurp.edu.base.ws.code

import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.data.model.dao.EntityDao
import org.beangle.webmvc.api.action.{ ActionSupport, EntitySupport, MimeSupport }
import org.beangle.webmvc.api.annotation.response
import org.openurp.code.BaseCode
import org.beangle.data.model.Entity

class AbstractWS[T <: BaseCode] extends ActionSupport with EntitySupport[T] with MimeSupport {

  var entityDao: EntityDao = _

  @response
  def index(): Any = {
    val builder = OqlBuilder.from(entityType, "code")
    builder.orderBy(get("orderBy", "code.code"))
    buildQuery(builder)
    if (this.isRequestCsv) put("properties", List(classOf[BaseCode] -> List("id", "code", "name"), classOf[Entity[_]] -> List("id")))
    entityDao.search(builder)
  }

  def buildQuery(builder: OqlBuilder[T]): Unit = {

  }
}