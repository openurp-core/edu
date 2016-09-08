package org.openurp.edu.teach.ws

import org.beangle.commons.inject.bind.AbstractBindModule
import org.openurp.edu.teach.ws.grade.{ CourseGradeWS, ExamGradeWS }
import org.openurp.edu.teach.ws.code.ExamTypeWS

class DefaultModule extends AbstractBindModule {

  protected override def binding() {
    bind(classOf[ExamGradeWS], classOf[CourseGradeWS])

    bind(classOf[ExamTypeWS])
    bind(classOf[CourseAction], classOf[CourseGradeAction], classOf[StdCourseGradeAction])
    bind(classOf[GpaStatAction])
    bind(classOf[LsCourseGradeAction])
  }

}