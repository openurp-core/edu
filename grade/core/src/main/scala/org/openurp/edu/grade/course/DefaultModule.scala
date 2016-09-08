package org.openurp.edu.grade.course

import org.beangle.commons.inject.bind.AbstractBindModule
import org.openurp.edu.grade.course.domain.impl.DefaultGpaPolicy
import org.openurp.edu.grade.course.domain.impl.DefaultCourseGradeProvider
import org.openurp.edu.grade.course.domain.impl.DefaultGpaStatService
import org.openurp.edu.grade.course.service.internal.GradeInputSwitchServiceImpl

class DefaultModule extends AbstractBindModule {

  protected override def binding(): Unit = {
    bind(classOf[DefaultGpaStatService],classOf[DefaultCourseGradeProvider],classOf[DefaultGpaPolicy])
    bind(classOf[GradeInputSwitchServiceImpl])
  }
}