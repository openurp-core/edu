package org.openurp.edu.base.ws

import org.beangle.commons.inject.bind.AbstractBindModule

class DefaultModule extends AbstractBindModule {

  protected override def binding() {

    bind(classOf[StudentWS])
  }

}