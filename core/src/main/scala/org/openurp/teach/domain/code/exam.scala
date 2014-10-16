package org.openurp.teach.domain.code

import org.openurp.code.BaseCode
import org.openurp.platform.model.BaseCodeBean
import org.openurp.teach.code.GradeType

/**
 * 考核方式
 * 
 * @author chaostone
 * @since 2005-9-7
 */
class ExamModeBean extends BaseCodeBean


/**
 * 考试情况
 * 正常、作弊、旷考等
 * 
 * @author chaostone
 * @since 2005-9-7
 */
class ExamStatusBean extends BaseCodeBean{
  	/**
	 * 是否参加考试
	 */
  var attend:Boolean=_
  	/**
	 * 是否需要参加下一次缓考
	 * @return
	 */
  var needAttendDelay:Boolean=_
    /**
   * 能否录入成绩
   * @return
   */
  var inputable:Boolean=_
  
}

/**
 * 考试类型
 * 
 * @author 塞外狂人
 * @author chaostone
 * @since 2005-9-7
 */
class ExamTypeBean extends BaseCodeBean{
  var gradeType:GradeType=_
  var delay:Boolean=_
 }