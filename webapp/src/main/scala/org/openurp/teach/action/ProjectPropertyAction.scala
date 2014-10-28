package org.openurp.teach.action

import org.beangle.webmvc.entity.action.RestfulAction
import org.openurp.teach.ProjectProperty
import org.beangle.data.jpa.dao.OqlBuilder
import org.openurp.teach.ProjectConfig
import org.beangle.data.model.Entity

class ProjectPropertyAction extends RestfulAction[ProjectProperty]  {
  override def editSetting(entity: ProjectProperty) = {
    val configs = findItems(classOf[ProjectConfig])
    put("configs", configs)
    
    super.editSetting(entity)
  }
  private def findItems[T <: Entity[_]](clazz: Class[T]): Seq[T] = {
    val query = OqlBuilder.from(clazz)
    query.orderBy("project.name")
    val items = entityDao.search(query)
    items
  }
}
  

