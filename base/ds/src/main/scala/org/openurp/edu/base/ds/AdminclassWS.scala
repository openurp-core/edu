package org.openurp.edu.base.ds

import org.openurp.edu.base.Adminclass
import org.beangle.webmvc.api.annotation.response
import org.beangle.data.model.Entity
import org.beangle.webmvc.api.context.Params
import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.webmvc.entity.action.RestfulService

class AdminclassWS extends RestfulService[Adminclass]{
  
  override def getQueryBuilder(): OqlBuilder[Adminclass] = {
    super.getQueryBuilder().where(this.shortName + ".project.code = :project", Params.get("project").get)
  }

}