package org.openurp.edu.teach.grade.service

import org.openurp.edu.teach.grade.model.GradeInputSwitch
import org.openurp.base.Semester
import org.openurp.edu.base.Project

trait GradeInputSwitchService {

  /**
   */
  def getSwitch(project: Project, semester: Semester): GradeInputSwitch
}