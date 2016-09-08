package org.openurp.edu.grade.course.service

import org.openurp.edu.base.model.Project
import org.openurp.base.model.Semester
import org.openurp.edu.grade.app.model.GradeInputSwitch

trait GradeInputSwitchService {
  def getSwitch(project: Project, semester: Semester): GradeInputSwitch 
}