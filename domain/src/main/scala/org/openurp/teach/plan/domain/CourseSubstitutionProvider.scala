package org.openurp.teach.plan.domain

import org.openurp.teach.core.Student
import org.openurp.teach.plan.MajorCourseSubstitution
import org.openurp.teach.plan.StdCourseSubstitution
import org.openurp.teach.plan.CourseSubstitution

trait CourseSubstitutionProvider {
  /**
   * 得到该学生指定专业类型的所有的替代课程
   *
   * @param std
   * @return list<CourseSubstitution>
   */
  def getCourseSubstitutions(std: Student): Seq[CourseSubstitution]

  /**
   * 得到该学生指定专业类型的个人替代课程
   *
   * @param std
   * @return list<CourseSubstitution>
   */
  def getMajorCourseSubstitutions(std: Student): Seq[MajorCourseSubstitution]

  /**
   * 得到该学生指定专业类型的专业替代课程
   *
   * @param std
   * @return list<CourseSubstitution>
   */
  def getStdCourseSubstitutions(std: Student): Seq[StdCourseSubstitution]
}
