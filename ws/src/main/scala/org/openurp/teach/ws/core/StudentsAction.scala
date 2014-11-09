package org.openurp.teach.ws.core

import org.beangle.webmvc.entity.action.RestfulService
import org.openurp.teach.core.{ Student, StudentJournal }

class StudentAction extends RestfulService[Student]

class StudentJournalAction extends RestfulService[StudentJournal]

