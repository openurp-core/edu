package org.openurp.edu.base.ds

import org.openurp.edu.base.{ Major, MajorJournal }
import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.webmvc.api.context.Params
import org.beangle.webmvc.entity.action.RestfulService

class MajorWS extends RestfulService[Major]{
  
  override def getQueryBuilder(): OqlBuilder[Major] = {
    super.getQueryBuilder().where(this.shortName + ".project.code = :project", Params.get("project").get)
  }

}

class MajorJournalWS extends  RestfulService[MajorJournal]{
  
  override def getQueryBuilder(): OqlBuilder[MajorJournal] = {
    super.getQueryBuilder().where(this.shortName + ".major.project.code = :project", Params.get("project").get)
  }

}
