package org.openurp.edu.base.ws

import org.openurp.edu.base.model.DirectionJournal
import org.openurp.edu.base.model.Direction
import org.beangle.webmvc.entity.action.RestfulService
import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.webmvc.api.context.Params

class DirectionWS extends RestfulService[Direction]{
    
  override def getQueryBuilder(): OqlBuilder[Direction] = {
    super.getQueryBuilder().where(this.shortName + ".major.project.code = :project", Params.get("project").get)
  }
}

class DirectionJournalWS extends RestfulService[DirectionJournal]{
    
  override def getQueryBuilder(): OqlBuilder[DirectionJournal] = {
    super.getQueryBuilder().where(this.shortName + ".direction.major.project.code = :project", Params.get("project").get)
  }
}
