package org.openurp.teach.ws

import org.beangle.webmvc.entity.action.RestfulService
import org.openurp.teach.{Direction, DirectionJournal}

class DirectionAction extends RestfulService[Direction]

class DirectionJournalAction extends RestfulService[DirectionJournal]
