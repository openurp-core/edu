package org.openurp.teach.plan.domain

import org.openurp.teach.core.Student
import org.openurp.teach.plan.{ CoursePlan, MajorPlan, StdPlan }

/**
 * 培养计划提供者
 * @author chaostone
 *
 */
trait CoursePlanProvider {

  /**
   * 获得专业培养计划
   */
  def getMajorPlan(student: Student): MajorPlan

  /**
   * 获得单个学生的个人计划
   */
  def getStdPlan(student: Student): StdPlan

  /**
   * 获得学生的计划
   *
   * @param std
   * @return
   */
  def getCoursePlan(std: Student): CoursePlan
}
