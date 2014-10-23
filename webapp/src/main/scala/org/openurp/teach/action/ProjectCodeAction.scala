package org.openurp.teach.action

import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.data.model.Entity
import org.beangle.webmvc.api.view.View
import org.beangle.webmvc.entity.action.RestfulAction
import org.openurp.base.Calendar
import org.openurp.base.Campus
import org.openurp.base.Department
import org.openurp.base.School
import org.openurp.base.TimeSetting
import org.openurp.base.code.Education
import org.openurp.teach.Project
import org.openurp.teach.code.StdLabel
import org.openurp.teach.code.StdType
import org.openurp.teach.domain.ProjectBean
import org.openurp.teach.domain.ProjectCode
import org.openurp.base.domain.code.CodeMeta

class ProjectCodeAction extends RestfulAction[ProjectCode]  {
  override def editSetting(entity: ProjectCode) = {
    val projects = findItems(classOf[Project])
    put("projects", projects)
  
    val metas = findItems(classOf[CodeMeta])
    put("metas", metas)

 super.editSetting(entity)
  }

  private def findItems[T <: Entity[_]](clazz: Class[T]): Seq[T] = {
    val query = OqlBuilder.from(clazz)
    query.orderBy("name")
    val items = entityDao.search(query)
    items
  }
  
}