package org.openurp.edu.teach.grade.course.domain.impl

import org.openurp.edu.base.Course
import org.openurp.edu.teach.grade.CourseGrade
import org.openurp.edu.teach.plan.CourseSubstitution

object GradeComparator {

  /**
   * Return true if first better then second.
   * 先比较绩点，后比较分数，最后按照是否通过比较
   */
  def betterThan(first: CourseGrade, second: CourseGrade): Boolean = {
    val gp1: Float = if (null == first.gp) 0f else first.gp
    val gp2: Float = if (null == second.gp) 0f else second.gp
    val gpResult = java.lang.Float.compare(gp1, gp2)
    if (0 != gpResult) return gpResult > 0
    val score1: Float = if ((null == first.score)) 0 else first.score
    val score2: Float = if ((null == second.score)) 0 else second.score
    val scoreResult = java.lang.Float.compare(score1, score2)
    if (0 != scoreResult) return scoreResult > 0
    first.passed
  }

  /**
   * 是否替代成功 <br>
   * 先比较绩点，后比较分数，最后按照是否通过比较
   *
   * @param substitution
   * @param grades
   */
  def isSubstitute(substitution: CourseSubstitution, grades: collection.Map[Course, CourseGrade]): Boolean = {
    var existOrigGrade = false
    var gpa1 = 0d
    var ga1 = 0d
    var credit1 = 0f
    var passed1 = 0
    for (course <- substitution.origins) {
      val grade = grades.get(course).orNull
      if (null != grade) {
        if (grade.passed) passed1 += 1
        if (null != grade.gp) gpa1 += grade.course.credits * grade.gp
        if (null != grade.score) ga1 = grade.course.credits * grade.score
        existOrigGrade = true
      }
      credit1 += course.credits
    }
    var fullGrade2 = true
    var gpa2 = 0d
    var ga2 = 0d
    var credit2 = 0f
    var passed2 = 0
    for (course <- substitution.substitutes) {
      val grade = grades.get(course).orNull
      if (null != grade) {
        if (grade.passed) passed2 += 1
        if (null != grade.gp) gpa2 += grade.course.credits * grade.gp
        if (null != grade.score) ga2 = grade.course.credits * grade.score
      } else {
        fullGrade2 = false
      }
      credit2 += course.credits
    }
    var success = false
    if (!existOrigGrade && fullGrade2) {
      success = true
    } else {
      if ((fullGrade2) && (credit1 > 0 && credit2 > 0)) {
        var gpaCompare = 0
        if (gpa1 > 0 || gpa2 > 0) {
          gpaCompare = java.lang.Double.compare(gpa1 / credit1, gpa2 / credit2)
        }
        if (0 == gpaCompare && (ga1 > 0 || ga2 > 0)) {
          gpaCompare = java.lang.Double.compare(ga1 / credit1, ga2 / credit2)
        }
        if (0 == gpaCompare) gpaCompare = passed1 - passed2
        success = gpaCompare <= 0
      }
    }
    success
  }
}
