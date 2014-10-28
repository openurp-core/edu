package org.openurp.teach.action

import org.beangle.webmvc.entity.action.RestfulAction
import org.openurp.teach.Direction
import org.openurp.teach.Major
import org.beangle.data.jpa.dao.OqlBuilder
import org.openurp.teach.domain.DirectionBean
import org.openurp.teach.DirectionJournal
import org.beangle.data.model.Entity
import org.beangle.webmvc.api.view.View
import org.openurp.teach.MajorJournal

class DirectionAction extends RestfulAction[Direction]  {
  override def editSetting(entity: Direction) = {
    
    val majors = findItems(classOf[Major])
    put("majors", majors)

 

    super.editSetting(entity)
  }

  private def findItems[T <: Entity[_]](clazz: Class[T]): Seq[T] = {
    val query = OqlBuilder.from(clazz)
    query.orderBy("id")
    val items = entityDao.search(query)
    items
  }

}




