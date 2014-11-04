package org.openurp.teach.action

import org.beangle.webmvc.entity.action.RestfulAction
import org.openurp.teach.Adminclass
import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.data.model.Entity
import org.openurp.teach.Direction
import org.openurp.base.Department
import org.openurp.teach.Major
import org.openurp.teach.code.StdType
class AdminclassAction extends RestfulAction[Adminclass]  {
  override def editSetting(entity: Adminclass) = {
    val departments = findItems(classOf[Department])
    put("departments", departments)

    val majors = findItems(classOf[Major])
    put("majors", majors)

    val directions = findItems(classOf[Direction])
    put("directions", directions)
    
    val stdTypes = findItems(classOf[StdType])
    put("stdTypes", stdTypes)


  

    super.editSetting(entity)
  }

  private def findItems[T <: Entity[_]](clazz: Class[T]): Seq[T] = {
    val query = OqlBuilder.from(clazz)
    query.orderBy("name")
    val items = entityDao.search(query)
    items
  }
  
}

