package org.openurp.teach

import org.beangle.commons.inject.bind.AbstractBindModule
import org.openurp.teach.code.service.internal.BaseCodeServiceImpl

class DefaultModule extends AbstractBindModule {

  protected override def binding(): Unit = {
    bind(classOf[BaseCodeServiceImpl])
  }
}