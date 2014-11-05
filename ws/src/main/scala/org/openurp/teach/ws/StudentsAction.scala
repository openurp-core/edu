package org.openurp.teach.ws

import org.beangle.webmvc.entity.action.RestfulService
import org.openurp.teach.{StdPerson, Student, StudentJournal}

class StudentAction extends RestfulService[Student]

class StudentJournalAction extends RestfulService[StudentJournal]

class StdPersonAction extends RestfulService[StdPerson]
