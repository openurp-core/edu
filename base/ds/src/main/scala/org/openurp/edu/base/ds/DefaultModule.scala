package org.openurp.edu.base.ds

import org.beangle.commons.inject.bind.AbstractBindModule
import org.beangle.webmvc.config.action.JekyllMvcAction
import org.openurp.edu.base.ds.code.{ StdLabelTypeWS, StdLabelWS, StdStatusWS, StdTypeWS }

class DefaultModule extends AbstractBindModule {

  protected override def binding() {
    bind(classOf[StdStatusWS])
    bind(classOf[StdLabelWS], classOf[StdLabelTypeWS], classOf[StdTypeWS])

    bind(classOf[DirectionWS], classOf[DirectionJournalWS])
    bind(classOf[MajorWS], classOf[MajorJournalWS])
    bind(classOf[ProjectWS], classOf[ProjectClassroomWS], classOf[ProjectCodeWS])
    bind(classOf[StudentWS], classOf[StudentJournalWS])
    bind(classOf[AdminclassWS])

    bind(classOf[JekyllMvcAction])
  }

}