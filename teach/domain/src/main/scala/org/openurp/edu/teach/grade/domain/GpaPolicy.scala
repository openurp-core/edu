package org.openurp.edu.teach.grade.domain

import org.openurp.edu.teach.grade.CourseGrade

/**
 * 平均绩点计算策略
 *
 * @author chaostone
 *
 */
trait GpaPolicy {

  /**
   * 计算平均绩点
   */
  def calcGpa(grades: Iterable[CourseGrade]): java.lang.Float

  /**
   * 计算平均分
   */
  def calcGa(grades: Iterable[CourseGrade]): java.lang.Float

  /**
   * 保留小数位
   */
  def round(gpa: java.lang.Float): java.lang.Float

  /**
   * 平均绩点和平均分的小数点后精确位数,默认为2
   */
  def precision: Int
}
