package org.openurp.teach.action

import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.data.model.Entity
import org.beangle.webmvc.entity.action.RestfulAction
import org.openurp.base.domain.code.CodeMeta
import org.openurp.teach.Project
import org.openurp.teach.domain.ProjectCodeBean

class ProjectCodeAction extends RestfulAction[ProjectCodeBean] {
  override def editSetting(entity: ProjectCodeBean) = {
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