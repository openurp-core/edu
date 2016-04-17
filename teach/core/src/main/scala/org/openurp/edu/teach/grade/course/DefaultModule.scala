package org.openurp.edu.teach

import org.beangle.commons.inject.bind.AbstractBindModule
import org.openurp.edu.teach.grade.service.internal.DefaultGpaStatService
import org.openurp.edu.teach.grade.domain.impl.CourseGradeProviderImpl
import org.openurp.edu.teach.grade.domain.impl.DefaultGpaPolicy
import org.openurp.edu.teach.grade.service.internal.GradeInputSwitchServiceImpl

class DefaultModule extends AbstractBindModule {

  protected override def binding(): Unit = {
    bind(classOf[DefaultGpaStatService],classOf[CourseGradeProviderImpl],classOf[DefaultGpaPolicy])
    bind(classOf[GradeInputSwitchServiceImpl])
  }
}