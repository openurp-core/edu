package org.openurp.teach.action

import org.beangle.webmvc.entity.action.RestfulAction
import org.openurp.teach.ProjectConfig
import org.openurp.teach.Project
import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.data.model.Entity

class ProjectConfigAction extends RestfulAction[ProjectConfig] {
  override def editSetting(entity: ProjectConfig) = {
    val projects = findItems(classOf[Project])
    put("projects", projects)
    
    super.editSetting(entity)
  }
  private def findItems[T <: Entity[_]](clazz: Class[T]): Seq[T] = {
    val query = OqlBuilder.from(clazz)
    query.orderBy("name")
    val items = entityDao.search(query)
    items
  }
  
}