package org.openurp.edu.teach.ws

import org.beangle.commons.inject.bind.AbstractBindModule
import org.openurp.edu.teach.ws.grade.{ CourseAction, CourseGradeAction, GpaStatAction, LsCourseGradeAction, StdCourseGradeAction }

class DefaultModule extends AbstractBindModule {

  protected override def binding() {
    bind(classOf[CourseAction], classOf[CourseGradeAction], classOf[StdCourseGradeAction])
    bind(classOf[GpaStatAction])
    bind(classOf[LsCourseGradeAction])

  }

}