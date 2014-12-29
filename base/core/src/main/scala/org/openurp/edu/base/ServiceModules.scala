package org.openurp.edu.base

import org.beangle.commons.inject.bind.AbstractBindModule
import org.openurp.edu.base.code.service.impl.BaseCodeServiceImpl

class DefaultServiceModule extends AbstractBindModule {

  protected override def binding(): Unit = {
    bind(classOf[BaseCodeServiceImpl])
  }
}