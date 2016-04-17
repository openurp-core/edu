package org.openurp.edu.teach.grade.course.service.internal

import org.openurp.base.model.Semester
import org.openurp.edu.teach.grade.course.domain.CourseGradeProvider
import org.openurp.edu.teach.grade.course.domain.GpaPolicy
import org.openurp.edu.teach.grade.domain.impl.DefaultGpaPolicy
import org.openurp.edu.teach.grade.course.model.CourseGrade
import org.openurp.edu.base.model.Student
import org.openurp.edu.teach.grade.course.service.GpaService

/**
 * @author chaostone
 */
class DefaultGpaService extends GpaService {

  var gpaPolicy: GpaPolicy = new DefaultGpaPolicy()

  var courseGradeProvider: CourseGradeProvider = _

  def calcGpa(std: Student): java.lang.Float = {
    gpaPolicy.calcGpa(courseGradeProvider.getPublished(std))
  }

  def calcGpa(std: Student, grades: Iterable[CourseGrade]): java.lang.Float = gpaPolicy.calcGpa(grades)

  def calcGpa(std: Student, semester: Semester): java.lang.Float = {
    gpaPolicy.calcGpa(courseGradeProvider.getPublished(std, semester))
  }

}
