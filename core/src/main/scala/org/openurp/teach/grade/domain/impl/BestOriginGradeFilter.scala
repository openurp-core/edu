package org.openurp.teach.grade.domain.impl

import org.openurp.teach.grade.model.CourseGradeBean
import org.openurp.teach.grade.domain.GradeFilter
import org.openurp.teach.plan.domain.CourseSubstitutionProvider
import org.openurp.teach.grade.CourseGrade
import org.openurp.teach.plan.CourseSubstitution
import org.openurp.teach.core.Course

/**
 * 最好成绩过滤器(保留原始的学期和课程名称)
 *
 * @author chaostone
 */
class BestOriginGradeFilter(courseSubstitutionProvider: CourseSubstitutionProvider) extends GradeFilter {

  /**
   * FIXME 缺少替代课程逻辑
   */
  private def buildGradeMap(grades: Iterable[CourseGrade]): collection.mutable.Map[Course, CourseGrade] = {
    val gradesMap = new collection.mutable.HashMap[Course, CourseGrade]
    var old: CourseGrade = null
    for (grade <- grades) {
      gradesMap.get(grade.course) match {
        case Some(old) =>
          if (GradeComparator.betterThan(grade, old)) {
            if (grade.semester.beginOn.after(old.semester.beginOn)) {
              val cloned = clone(grade)
              cloned.semester = old.semester
              gradesMap.put(grade.course, cloned)
            } else {
              gradesMap.put(grade.course, grade)
            }
          }
        case None => gradesMap.put(grade.course, grade)
      }
    }
    gradesMap
  }

  private def clone(grade: CourseGrade): CourseGradeBean = {
    val cloned = new CourseGradeBean()
    cloned.std = grade.std
    cloned.course = grade.course
    cloned.semester = grade.semester
    cloned.lesson = grade.lesson
    cloned.lessonNo = grade.lessonNo
    cloned.courseType = grade.courseType
    cloned.courseTakeType = grade.courseTakeType
    cloned.examMode = grade.examMode
    cloned.markStyle = grade.markStyle
    cloned.project = grade.project
    cloned.gp = grade.gp
    cloned.passed = grade.passed
    cloned.score = grade.score
    cloned.scoreText = grade.scoreText
    cloned.status = grade.status
    cloned.updatedAt = grade.updatedAt
    cloned.examGrades ++= grade.examGrades
    cloned
  }

  def filter(grades: Seq[CourseGrade]): Seq[CourseGrade] = {
    val gradesMap = buildGradeMap(grades)
    val substituteCourses = getSubstituteCourses(grades)
    for (subCourse <- substituteCourses) {
      val origin = gradesMap.get(subCourse.origins.iterator.next()).orNull
      val sub = gradesMap.get(subCourse.substitutes.iterator.next()).orNull
      if (null != origin && null != sub) {
        if (GradeComparator.betterThan(sub, origin)) {
          gradesMap.remove(sub.course)
          val subClone = clone(sub)
          subClone.semester = origin.semester
          subClone.course = origin.course
          gradesMap.put(origin.course, subClone)
        }
      }
    }
    gradesMap.values.toSeq
  }

  private def getSubstituteCourses(grades: Seq[CourseGrade]): Seq[CourseSubstitution] = {
    if (grades.isEmpty) return List.empty
    courseSubstitutionProvider.getCourseSubstitutions(grades(0).std)
  }
}
