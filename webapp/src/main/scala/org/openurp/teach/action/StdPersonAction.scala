package org.openurp.teach.action

import org.beangle.webmvc.entity.action.RestfulAction
import org.openurp.teach.Adminclass
import org.openurp.teach.StdPerson
import org.openurp.base.code.Country
import org.openurp.base.code.Nation
import org.beangle.data.jpa.dao.OqlBuilder
import org.openurp.base.code.PoliticalAffiliation
import org.beangle.data.model.Entity
import org.openurp.base.code.IdType
import org.openurp.base.code.Gender

class StdPersonAction extends RestfulAction[StdPerson]  {
  override def editSetting(entity: StdPerson) = {
    val idTypes = findItems(classOf[IdType])
    put("idTypes", idTypes)

    val countries = findItems(classOf[Country])
    put("countries", countries)

    val nations = findItems(classOf[Nation])
    put("nations", nations)
    
    val genders = findItems(classOf[Gender])
    put("genders", genders)

    val politicalAffiliations = findItems(classOf[PoliticalAffiliation])
    put("politicalAffiliations", politicalAffiliations)

  

    super.editSetting(entity)
  }

  private def findItems[T <: Entity[_]](clazz: Class[T]): Seq[T] = {
    val query = OqlBuilder.from(clazz)
    query.orderBy("name")
    val items = entityDao.search(query)
    items
  }
  
}

