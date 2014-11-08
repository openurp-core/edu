package org.openurp.teach.program.model

import org.openurp.teach.core.Student
import org.openurp.teach.program.StdPlan
import org.openurp.teach.program.StdCourseGroup
import org.openurp.teach.program.StdPlanCourse

/**
 * 个人计划
 */
class StdPlanBean extends AbstractCoursePlan with StdPlan {

  /**
   * 学生
   */
  var std: Student = _

}

class StdCourseGroupBean extends AbstractCourseGroup with StdCourseGroup {
}

class StdPlanCourseBean extends AbstractPlanCourse with StdPlanCourse {

}
