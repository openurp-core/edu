package org.openurp.edu.teach.plan.domain

import org.openurp.edu.base.Student
import org.openurp.edu.teach.plan.{ CourseSubstitution, MajorCourseSubstitution, StdCourseSubstitution }

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
