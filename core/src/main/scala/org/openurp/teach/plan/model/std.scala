package org.openurp.teach.plan.model

import org.beangle.data.model.bean.IntIdBean
import org.openurp.teach.core.Student
import org.openurp.teach.plan.{ StdCourseGroup, StdPlan, StdPlanCourse }

/**
 * 个人计划
 */
class StdPlanBean extends IntIdBean with AbstractCoursePlan with StdPlan {

  /**
   * 学生
   */
  var std: Student = _

}

class StdCourseGroupBean extends AbstractCourseGroup with StdCourseGroup {
}

class StdPlanCourseBean extends AbstractPlanCourse with StdPlanCourse {

}
