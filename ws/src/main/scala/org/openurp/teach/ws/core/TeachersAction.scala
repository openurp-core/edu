package org.openurp.teach.ws

import org.beangle.webmvc.entity.action.RestfulService
import org.openurp.teach.core.Habilitation
import org.openurp.teach.core.Teacher
import org.openurp.teach.core.TeacherJournal

class TeacherAction extends RestfulService[Teacher]

class TeacherJournalAction extends RestfulService[TeacherJournal]

class HabilitationAction extends RestfulService[Habilitation]