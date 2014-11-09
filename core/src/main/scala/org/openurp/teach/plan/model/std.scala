package org.openurp.teach.plan.model

import org.openurp.teach.core.Student
import org.openurp.teach.plan.StdPlan
import org.openurp.teach.plan.StdCourseGroup
import org.openurp.teach.plan.StdPlanCourse

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
