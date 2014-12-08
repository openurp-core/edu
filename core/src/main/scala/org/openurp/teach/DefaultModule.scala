package org.openurp.teach

import org.beangle.commons.inject.bind.AbstractBindModule
import org.openurp.teach.code.service.internal.BaseCodeServiceImpl
import org.openurp.teach.grade.service.internal.DefaultGpaStatService
import org.openurp.teach.grade.domain.impl.CourseGradeProviderImpl
import org.openurp.teach.grade.domain.impl.DefaultGpaPolicy
import org.openurp.teach.grade.service.internal.GradeInputSwitchServiceImpl

class DefaultModule extends AbstractBindModule {

  protected override def binding(): Unit = {
    bind(classOf[BaseCodeServiceImpl])
    bind(classOf[DefaultGpaStatService],classOf[CourseGradeProviderImpl],classOf[DefaultGpaPolicy])
    bind(classOf[GradeInputSwitchServiceImpl])
  }
}