package org.openurp.teach.grade.service.internal

import org.openurp.base.Semester
import org.openurp.teach.grade.domain.impl.DefaultGpaPolicy
import org.openurp.teach.grade.domain.CourseGradeProvider
import org.openurp.teach.grade.domain.GpaPolicy
import org.openurp.teach.grade.CourseGrade
import org.openurp.teach.core.Student
import org.openurp.teach.grade.service.GpaService

/**
 * @author chaostone
 */
class DefaultGpaService extends GpaService {

  var gpaPolicy: GpaPolicy = new DefaultGpaPolicy()

  var courseGradeProvider: CourseGradeProvider = _

  def getGpa(std: Student): java.lang.Float = {
    gpaPolicy.calcGpa(courseGradeProvider.getPublished(std))
  }

  def getGpa(std: Student, grades: Iterable[CourseGrade]): java.lang.Float = gpaPolicy.calcGpa(grades)

  def getGpa(std: Student, semester: Semester): java.lang.Float = {
    gpaPolicy.calcGpa(courseGradeProvider.getPublished(std, semester))
  }

}
