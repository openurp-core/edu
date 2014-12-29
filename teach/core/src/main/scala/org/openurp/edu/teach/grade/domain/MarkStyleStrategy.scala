package org.openurp.edu.teach.grade.domain

import org.openurp.edu.teach.grade.model.CourseGradeState
import org.openurp.edu.teach.code.GradeType

/**
 * 课程成绩记录方式配置策略
 *
 * @author chaostone
 */
trait MarkStyleStrategy {

  /**
   * 针对空白的记录方式进行设置默认值
   */
  def configMarkStyle(gradeState: CourseGradeState, gradeTypes: Seq[GradeType]): Unit
}