package org.openurp.edu.grade.course.domain.impl

import org.openurp.edu.grade.course.model.CourseGrade
import org.openurp.edu.grade.course.domain.GradeFilter

/**
 * 只留下通过课程的成绩
 */
class PassedGradeFilter extends GradeFilter {

  def filter(grades: Seq[CourseGrade]): Seq[CourseGrade] = {
    grades.filter(c => c.passed)
  }
}