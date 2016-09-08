package org.openurp.edu.base.code.service.impl

import org.openurp.code.BaseCode
import org.openurp.edu.base.model.Project
import org.openurp.edu.base.code.service.ProjectCodeService
import org.beangle.data.dao.OqlBuilder
import org.beangle.data.dao.EntityDao

class ProjectCodeServiceImpl(entityDao: EntityDao) extends ProjectCodeService {

  //FIXME add project basecode support
  override def getCodes[T <: BaseCode](project: Project, clazz: Class[T]): Seq[T] = {
    val query = OqlBuilder.from(clazz, "code").where("code.beginOn <=:now and (code.endOn is null or code.endOn >=:now)", new java.util.Date)
    query.orderBy("code.code")
    entityDao.search(query)
  }

  override def getCode[T <: BaseCode](clazz: Class[T], id: Int): T = {
    entityDao.get(clazz, id)
  }
}