package org.openurp.teach.grade.service

import org.openurp.teach.grade.model.GradeInputSwitch
import org.openurp.teach.core.Project
import org.openurp.base.Semester

trait GradeInputSwitchService {

  /**
   */
  def getSwitch(project: Project, semester: Semester): GradeInputSwitch
}