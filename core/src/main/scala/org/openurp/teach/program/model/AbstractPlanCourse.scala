package org.openurp.teach.program.model

import org.openurp.base.Department
import org.openurp.teach.code.ExamMode
import org.openurp.teach.core.Course
import org.openurp.teach.program.PlanCourse
import org.beangle.data.model.bean.LongIdBean
import org.openurp.teach.program.CourseGroup

/**
 * 抽象计划内课程
 * </p>
 *
 * @author chaostone
 * @since 2009
 */
abstract class AbstractPlanCourse extends LongIdBean with PlanCourse with Cloneable {
  /**
   * 课程组
   */
  var group: CourseGroup = _
  /**
   * 课程
   */
  var course: Course = _

  /**
   * 开课学期
   */
  var terms: String = _

  /**
   * 是否必修
   */
  var compulsory: Boolean = _

  /**
   * 开课部门
   */
  var department: Department = _

  /**
   * 开课部门
   */
  var examMode: ExamMode = _

  /**
   * 备注
   */
  var remark: String = _
}
