package org.openurp.teach.base.action

import org.beangle.commons.inject.bind.AbstractBindModule
import org.openurp.teach.base.action.code.TeacherTypeAction

class DefaultModule extends AbstractBindModule {

  protected override def binding() {
    bind(classOf[TeacherTypeAction])
    //bind()
  }
}