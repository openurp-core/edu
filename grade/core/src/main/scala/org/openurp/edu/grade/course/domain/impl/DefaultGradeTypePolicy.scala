package org.openurp.edu.grade.course.domain.impl

import org.openurp.eams.grade.domain.GradeTypePolicy
import org.openurp.edu.grade.code.model.GradeType
import org.openurp.edu.lesson.model.CourseTake
import org.openurp.edu.lesson.model.ExamTake
import org.openurp.edu.lesson.code.model.ExamType

class DefaultGradeTypePolicy extends GradeTypePolicy {

  /**
   * 补考和缓考要符合考试类型
   */
  def having(take: CourseTake, gradeType: GradeType, examtake: ExamTake): Boolean = {
    if (gradeType.id == GradeType.Delay) return null != examtake && examtake.examType.id == ExamType.Delay
    if (gradeType.id == GradeType.Makeup) return null != examtake && examtake.examType.id == ExamType.Makeup
    true
  }
}