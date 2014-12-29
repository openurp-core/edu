package org.openurp.edu.teach.grade.domain

import org.openurp.edu.teach.grade.CourseGrade

/**
 * 成绩过滤器
 * @author chaostone
 *
 */
trait GradeFilter {
  def filter(grades: Seq[CourseGrade]): Seq[CourseGrade]
}
