package org.openurp.edu.base.ds

import org.beangle.webmvc.entity.action.RestfulService
import org.beangle.data.model.Entity
import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.webmvc.api.context.Params

class ProjectRestfulService[T <: Entity[_ <: java.io.Serializable]] extends RestfulService[T] {

  override def getQueryBuilder(): OqlBuilder[T] = {
    put("elementType", this.entityType)
    super.getQueryBuilder().where(this.shortName + ".project.code = :project", Params.get("project").get)
  }

}