package org.openurp.edu.base.ds

import org.openurp.edu.base.{ Student, StudentJournal }
import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.webmvc.api.context.Params
import org.beangle.webmvc.entity.action.RestfulService

class StudentWS extends ProjectRestfulService[Student]{
  
}

class StudentJournalWS extends RestfulService[StudentJournal] {
  override def getQueryBuilder(): OqlBuilder[StudentJournal] = {
    super.getQueryBuilder().where(this.shortName + ".std.project.code = :project", Params.get("project").get)
  }

}

