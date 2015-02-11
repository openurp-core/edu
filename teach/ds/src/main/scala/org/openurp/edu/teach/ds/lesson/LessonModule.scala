package org.openurp.edu.teach.ds.lesson

import org.beangle.commons.inject.bind.AbstractBindModule

class LessonModule extends AbstractBindModule {
  protected override def binding() {
    bind(classOf[CourseTakeWS])
    bind(classOf[LessonWS])
    bind(classOf[CourseLimitGroupWS])
    bind(classOf[CourseLimitItemWS])
    bind(classOf[TeachersWS])
    bind(classOf[TeacherWS])
    bind(classOf[StdWS])
  }
}