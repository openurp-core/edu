package org.openurp.teach.ws

import org.beangle.webmvc.entity.action.RestfulService
import org.openurp.teach.core.StudentJournal
import org.openurp.teach.core.Student
import org.openurp.teach.core.StdPerson

class StudentAction extends RestfulService[Student]

class StudentJournalAction extends RestfulService[StudentJournal]

class StdPersonAction extends RestfulService[StdPerson]
