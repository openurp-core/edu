package org.openurp.teach.plan.model

import org.openurp.teach.plan.SharePlan
import org.openurp.teach.core.Project
import org.openurp.teach.plan.CourseGroup
import org.openurp.base.code.Education
import org.beangle.data.model.bean.UpdatedBean
import org.openurp.teach.plan.ShareCourseGroup
import org.openurp.base.code.Language
import org.openurp.teach.plan.SharePlanCourse

/**
 * 公共共享计划
 *
 * @author chaostone
 */
class SharePlanBean extends AbstractCoursePlan with SharePlan with Cloneable {

  /**
   * 名称
   */
  var name: String = _

  /**适用年级*/
  var grades: String = _

  /**
   * 项目
   */
  var project: Project = _

  /**
   * 培养层次
   */
  var education: Education = _
}

/**
 * 公共共享课程组(默认实现)
 */
class ShareCourseGroupBean extends AbstractCourseGroup with ShareCourseGroup {

  /**
   * 对应外语语种
   */
  var language: Language = _

}

/**
 * 公共共享课程组课程
 *
 * @author chaostone
 */
class SharePlanCourseBean extends AbstractPlanCourse with SharePlanCourse
