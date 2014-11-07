package org.openurp.teach.grade.domain.impl

import org.openurp.teach.grade.CourseGrade
import org.openurp.teach.grade.domain.GradeFilter

/**
 * 只留下通过课程的成绩
 *
 * @author zhou
 */
class PassGradeFilter extends GradeFilter {

  def filter(grades: Seq[CourseGrade]): Seq[CourseGrade] = {
    grades.filter(c => c.passed)
  }
}
