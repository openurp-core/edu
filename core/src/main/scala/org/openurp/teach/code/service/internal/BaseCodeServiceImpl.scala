package org.openurp.teach.code.service.internal

import org.openurp.teach.code.service.BaseCodeService
import org.openurp.code.BaseCode
import org.openurp.teach.core.Project
import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.data.model.dao.EntityDao

class BaseCodeServiceImpl(entityDao: EntityDao) extends BaseCodeService {

  //FIXME add project basecode support
  override def getCodes[T <: BaseCode](project: Project, clazz: Class[T]): Seq[T] = {
    val query = OqlBuilder.from(clazz, "code").where("code.beginOn <=:now and (code.endOn is null or code.endOn >=:now)", new java.util.Date)
    query.orderBy("code.code")
    entityDao.search(query)
  }

  override def getCode[T <: BaseCode](clazz: Class[T], id: Integer): T = {
    entityDao.get(clazz, id)
  }
}