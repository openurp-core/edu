package org.openurp.teach.action

import org.beangle.webmvc.entity.action.RestfulAction
import org.openurp.teach.Adminclass
import org.openurp.teach.StudentJournal
import org.openurp.base.Department
import org.openurp.teach.Major
import org.beangle.data.jpa.dao.OqlBuilder
import org.openurp.teach.code.StdStatus
import org.beangle.data.model.Entity
import org.openurp.teach.Direction

class StudentJournalAction extends RestfulAction[StudentJournal]  {
  override def editSetting(entity: StudentJournal) = {
    val departments = findItems(classOf[Department])
    put("departments", departments)

    val majors = findItems(classOf[Major])
    put("majors", majors)

    val directions = findItems(classOf[Direction])
    put("directions", directions)


    val adminclasses = findItems(classOf[Adminclass])
    put("adminclasses", adminclasses)
    
    val statuses = findItems(classOf[StdStatus])
    put("statuses", statuses)



    super.editSetting(entity)
  }

  private def findItems[T <: Entity[_]](clazz: Class[T]): Seq[T] = {
    val query = OqlBuilder.from(clazz)
    query.orderBy("name")
    val items = entityDao.search(query)
    items
  }
  
}

