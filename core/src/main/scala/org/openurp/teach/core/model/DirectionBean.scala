package org.openurp.teach.core.model

import collection.mutable.Buffer

import org.beangle.data.model.bean.{CodedBean, IntIdBean, NamedBean, TemporalOnBean}
import org.openurp.base.Department
import org.openurp.base.code.Education
import org.openurp.teach.core.{Direction, DirectionJournal, Major}

/**
 * 方向信息 专业领域.
 * 
 * @author chaostone
 */
class DirectionBean extends IntIdBean with CodedBean with NamedBean  with TemporalOnBean with Direction {
	/** 专业方向英文名 */
  var enName:String=_
  /** 备注 */
  var remark:String=_
    /** 所属专业 */
  var major:Major=_
  /** 部门 */
  var journals:Buffer[DirectionJournal]=new collection.mutable.ListBuffer[DirectionJournal]
}


 class DirectionJournalBean extends IntIdBean with TemporalOnBean  with DirectionJournal{
   
   	/**专业方向*/
   var direction:Direction=_
   	/**培养层次*/
   var education:Education=_
   /**部门*/
   var depart:Department=_
  /**备注*/
  var remark:String=_
 }