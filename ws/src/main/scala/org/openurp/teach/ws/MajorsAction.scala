package org.openurp.teach.ws

import org.beangle.webmvc.entity.action.RestfulService
import org.openurp.teach.{Major, MajorJournal}

class MajorAction extends RestfulService[Major]

class MajorJournalAction extends RestfulService[MajorJournal]
