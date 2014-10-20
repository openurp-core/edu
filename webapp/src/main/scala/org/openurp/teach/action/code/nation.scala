package org.openurp.teach.action.code

import org.beangle.webmvc.entity.action.RestfulAction
import org.openurp.teach.code.TeacherUnitType
import org.openurp.teach.code.TeacherType
import org.openurp.teach.code.StdStatus
import org.openurp.teach.code.TeacherState
import org.openurp.teach.code.TutorType
import org.openurp.teach.code.TeacherTitle
import org.openurp.teach.code.TeacherTitleLevel
import org.openurp.teach.code.Degree
import org.openurp.teach.code.StudyType

class DegreeAction extends RestfulAction[Degree] 
class StudyTypeAction extends RestfulAction[StudyType] 
class TeacherTitleAction extends RestfulAction[TeacherTitle] 
class TeacherTitleLevelAction extends RestfulAction[TeacherTitleLevel] 
