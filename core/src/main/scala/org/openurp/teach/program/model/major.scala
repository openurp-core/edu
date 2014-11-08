package org.openurp.teach.program.model

import org.openurp.teach.program.Program
import org.openurp.teach.program.MajorPlan
import org.openurp.teach.program.CourseGroup
import org.openurp.teach.program.MajorCourseGroup
import org.openurp.teach.core.Direction

/**
 * @author chaostone
 */
class MajorPlanBean extends AbstractCoursePlan with MajorPlan {

  /**
   * 培养方案
   */
  var program: Program = _

  override def toString(): String = {
    "MajorPlanBean [program=" + program + ", startTerm=" +
      startTerm +
      ", endTerm=" +
      endTerm +
      "]"
  }
}

/**
 * 专业计划课程组.
 *   @author chaostone
 */
class MajorCourseGroupBean extends AbstractCourseGroup with MajorCourseGroup {

  /**
   * 自定义别名
   */
  var alias: String = _

  /**
   * 该组针对的专业方向
   */
  var direction: Direction = _

  override def name: String = {
    val sb = new StringBuilder()
    if (null != courseType) sb.append(courseType.name)
    if (null != alias) sb.append(" ").append(alias)
    sb.toString
  }

  override def toString(): String = {
    "MajorPlanCourseGroupBean [alias=" + alias + ", direction=" +
      direction +
      ", parent=" +
      parent +
      ", courseType=" +
      courseType +
      "]"
  }
}
/**
 * 专业计划课程
 *
 */
class MajorPlanCourseBean extends AbstractPlanCourse {

  override def toString(): String = {
    "MajorPlanCourseBean [courseGroup=" + group + ", course=" +
      course +
      ", terms=" +
      terms +
      ", compulsory=" +
      compulsory +
      ", department=" +
      department +
      ", examMode=" +
      examMode +
      "]"
  }
}
