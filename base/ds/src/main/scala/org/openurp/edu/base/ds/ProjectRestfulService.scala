package org.openurp.edu.base.ds

import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.data.model.Entity
import org.beangle.webmvc.api.annotation.response
import org.beangle.webmvc.api.context.Params
import org.beangle.webmvc.entity.action.RestfulService

class ProjectRestfulService[T <: Entity[_ <: java.io.Serializable]] extends RestfulService[T] {
  
  @response
  override def index(): Any = {
    getInt("pageIndex") match {
      case Some(p) => entityDao.search(getQueryBuilder())
      case None => entityDao.search(getQueryBuilder().limit(null))
    }
  }

  override def getQueryBuilder(): OqlBuilder[T] = {
    put("elementType", this.entityType)
    val query = super.getQueryBuilder().where(this.shortName + ".project.code = :project", Params.get("project").get)
    val select = get("select")
    if (select.isDefined){
      query.select(select.get)
    }
    query
  }

}