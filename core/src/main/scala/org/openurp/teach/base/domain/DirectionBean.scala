package org.openurp.teach.base.domain

import java.util.Date
import org.beangle.data.model.bean.CodedBean
import org.beangle.data.model.bean.IntIdBean
import org.beangle.data.model.bean.NamedBean
import org.openurp.teach.base.Direction
import org.openurp.teach.base.Major
import org.openurp.teach.base.DirectionJournal
import org.openurp.base.code.Education
import org.openurp.base.Department
/**
 * 方向信息 专业领域.
 * 
 * @author chaostone
 */
class DirectionBean extends IntIdBean with CodedBean with NamedBean with Direction {
	/** 专业方向英文名 */
  var engName:String=_
  /** 备注 */
  var remark:String=_
  	/** 生效时间 */
  var effectiveAt:Date=_
	/** 失效时间 */
  var invalidAt:Date=_
    /** 所属专业 */
  var major:Major=_
  /** 部门 */
  var journals:List[DirectionJournal]=_
}


 class DirectionJournalBean extends IntIdBean with DirectionJournal{
   
   	/**专业方向*/
   var direction:Direction=_
   	/**培养层次*/
   var education:Education=_
   /**部门*/
   var depart:Department=_
     	/** 生效时间 */
  var effectiveAt:Date=_
	/** 失效时间 */
  var invalidAt:Date=_
  /**备注*/
  var remark:String=_
 }