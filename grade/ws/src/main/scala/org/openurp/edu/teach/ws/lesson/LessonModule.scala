package org.openurp.edu.teach.ws.lesson

import org.beangle.commons.inject.bind.AbstractBindModule

class LessonModule extends AbstractBindModule {
  protected override def binding() {
    bind(classOf[CourseTakeWS])
    bind(classOf[LessonWS])
    bind(classOf[LessonLimitGroupWS])
    bind(classOf[LessonLimitItemWS])
    bind(classOf[TeachersWS])
    bind(classOf[TeacherWS])
    bind(classOf[StdWS])
  }
}