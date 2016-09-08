package org.openurp.edu.grade.course.service.internal

import org.beangle.data.dao.OqlBuilder
import org.beangle.data.dao.EntityDao
import org.openurp.edu.base.model.Project
import org.openurp.base.model.Semester
import org.openurp.edu.grade.app.model.GradeInputSwitch
import org.openurp.edu.grade.course.service.GradeInputSwitchService

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