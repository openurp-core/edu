package org.openurp.teach.ws

import org.beangle.webmvc.entity.action.RestfulService
import org.openurp.teach.{Habilitation, Teacher, TeacherJournal}

class TeacherAction extends RestfulService[Teacher]

class TeacherJournalAction extends RestfulService[TeacherJournal]

class HabilitationAction extends RestfulService[Habilitation]