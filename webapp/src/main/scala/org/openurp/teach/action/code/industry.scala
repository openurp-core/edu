package org.openurp.teach.action.code

import org.beangle.webmvc.entity.action.RestfulAction
import org.openurp.teach.code.TeacherUnitType
import org.openurp.teach.code.TeacherType
import org.openurp.teach.code.StdStatus
import org.openurp.teach.code.TeacherState
import org.openurp.teach.code.TutorType

class StdStatusAction extends RestfulAction[StdStatus] 
class TeacherStateAction extends RestfulAction[TeacherState] 
class TeacherTypeAction extends RestfulAction[TeacherType] 
class TeacherUnitTypeAction extends RestfulAction[TeacherUnitType] 
class TutorTypeAction extends RestfulAction[TutorType] 