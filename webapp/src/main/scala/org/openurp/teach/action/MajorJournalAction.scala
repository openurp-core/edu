package org.openurp.teach.action

import org.beangle.webmvc.entity.action.RestfulAction
import org.openurp.teach.MajorJournal
import org.openurp.base.Department
import org.openurp.teach.Major
import org.openurp.base.code.DisciplineCategory
import org.beangle.data.jpa.dao.OqlBuilder
import org.openurp.base.code.Education
import org.beangle.data.model.Entity

class MajorJournalAction extends RestfulAction[MajorJournal] {
  override def editSetting(entity: MajorJournal) = {
    
    val majors = findItems(classOf[Major])
    put("majors", majors)

    val categories = findItems(classOf[DisciplineCategory])
    put("categories", categories)

    val educations = findItems(classOf[Education])
    put("educations", educations)

    val departs = findItems(classOf[Department])
    put("departs", departs)


   

    super.editSetting(entity)
  }

  private def findItems[T <: Entity[_]](clazz: Class[T]): Seq[T] = {
    val query = OqlBuilder.from(clazz)
    query.orderBy("name")
    val items = entityDao.search(query)
    items
  }
}

