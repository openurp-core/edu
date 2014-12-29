package org.openurp.edu.teach.grade.service.internal

import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.data.model.annotation.config
import org.beangle.data.model.dao.EntityDao
import org.openurp.base.Semester
import org.openurp.edu.base.Project
import org.openurp.edu.teach.grade.model.GradeInputSwitch
import org.openurp.edu.teach.grade.service.GradeInputSwitchService

class GradeInputSwitchServiceImpl extends GradeInputSwitchService {

  var entityDao: EntityDao = _
  /**
   */
  def getSwitch(project: Project, semester: Semester): GradeInputSwitch = {
    val query = OqlBuilder.from(classOf[GradeInputSwitch], "switch");
    query
      .where("switch.opened = true")
      .where("current_time() between switch.startAt and switch.endAt")
      .orderBy("switch.id")
    val switches = entityDao.search(query)
    if (switches.isEmpty) null else switches(0)
  }
}