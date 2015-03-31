package org.openurp.edu.teach.grade.domain.impl

import org.openurp.edu.base.Course
import org.openurp.edu.teach.grade.CourseGrade
import org.openurp.edu.teach.grade.domain.GradeFilter
import org.openurp.edu.teach.plan.CourseSubstitution
import org.openurp.edu.teach.plan.domain.CourseSubstitutionProvider

/**
 * 最好成绩过滤器
 *
 * @author chaostone
 */
class BestGradeFilter(courseSubstitutionProvider: CourseSubstitutionProvider) extends GradeFilter {

  protected def buildGradeMap(grades: Seq[CourseGrade]): collection.mutable.Map[Course, CourseGrade] = {
    val gradesMap = new collection.mutable.HashMap[Course, CourseGrade]
    for (grade <- grades) {
      gradesMap.get(grade.course) match {
        case Some(old) => if (GradeComparator.betterThan(grade, old)) gradesMap.put(grade.course, grade)
        case None => gradesMap.put(grade.course, grade)
      }
    }
    gradesMap
  }

  def filter(grades: Seq[CourseGrade]): Seq[CourseGrade] = {
    val gradesMap = buildGradeMap(grades)
    val substituteCourses = getSubstituteCourses(grades)
    for (subCourse <- substituteCourses if GradeComparator.isSubstitute(subCourse, gradesMap); c <- subCourse.origins)
      gradesMap.remove(c)
    gradesMap.values.toSeq
  }

  private def getSubstituteCourses(grades: Seq[CourseGrade]): Seq[CourseSubstitution] = {
    if (grades.isEmpty) return List.empty
    courseSubstitutionProvider.getCourseSubstitutions(grades(0).std)
  }

}
