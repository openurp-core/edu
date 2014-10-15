package org.openurp.teach.base.domain.code

import org.openurp.platform.model.BaseCodeBean
import org.openurp.teach.base.code.TeacherType
import org.openurp.teach.base.code.StdStatus
import org.openurp.teach.base.code.TeacherUnitType
import org.openurp.teach.base.code.TeacherState
import org.openurp.teach.base.code.TutorType
/**
 * 教职工类别
 * 
 * @author chaostone
 * @since 2005-9-7
 */

class TeacherTypeBean extends BaseCodeBean with TeacherType {
  
  var parttime: Boolean = _

}

class StdStatusBean extends BaseCodeBean with StdStatus{
  
}

/**
 * 教师在职状态
 * 
 * @author zhouqi
 * @since 2005-9-7
 */
class TeacherStateBean extends BaseCodeBean with TeacherState{
  
}


/**
 * 外聘教师单位类别
 */
class TeacherUnitTypeBean extends BaseCodeBean with TeacherUnitType{
  
}


/**
 * 导师类型
 * 
 * @author chaostone
 * @since 2005-9-7
 */
class TutorTypeBean extends BaseCodeBean with TutorType{
  
}