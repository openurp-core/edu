package org.openurp.edu.grade.course.domain.impl

import org.beangle.commons.lang.Strings
import org.beangle.commons.script.ExpressionEvaluator
import org.openurp.edu.grade.course.model.CourseGrade
import org.openurp.edu.grade.course.domain.GradeFilter
import java.util.Collections

class ScriptGradeFilter(val script: String, val expressionEvaluator: ExpressionEvaluator) extends GradeFilter {

  def filter(grades: Seq[CourseGrade]): Seq[CourseGrade] = {
    if (Strings.isEmpty(script)) return grades
    val newGrades = new collection.mutable.ListBuffer[CourseGrade]
    for (grade <- grades) {
      val rs = expressionEvaluator.eval(script, Collections.singletonMap("grade", grade), classOf[Boolean])
      if (rs.booleanValue()) newGrades += grade
    }
    newGrades
  }
}
