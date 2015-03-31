package org.openurp.edu.teach.grade.service.internal

import org.openurp.base.Semester
import org.openurp.edu.base.Student
import org.openurp.edu.teach.grade.CourseGrade
import org.openurp.edu.teach.grade.domain.{ CourseGradeProvider, GpaPolicy }
import org.openurp.edu.teach.grade.domain.impl.DefaultGpaPolicy
import org.openurp.edu.teach.grade.service.GpaService

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
