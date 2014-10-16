package org.openurp.teach.base.action.code

import org.beangle.webmvc.entity.action.RestfulAction
import org.openurp.teach.base.code.TeacherType
import org.openurp.teach.base.code.StdStatus
import org.openurp.teach.base.code.TeacherState
import org.openurp.teach.base.code.TeacherUnitType
import org.openurp.teach.base.code.TutorType

class StdStatusAction extends RestfulAction[StdStatus] 
class TeacherStateAction extends RestfulAction[TeacherState] 
class TeacherTypeAction extends RestfulAction[TeacherType] 
class TeacherUnitTypeAction extends RestfulAction[TeacherUnitType] 
class TutorTypeAction extends RestfulAction[TutorType] 