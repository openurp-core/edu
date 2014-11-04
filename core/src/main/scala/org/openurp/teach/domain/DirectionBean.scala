package org.openurp.teach.domain

import org.beangle.data.model.bean.CodedBean
import org.beangle.data.model.bean.IntIdBean
import org.beangle.data.model.bean.NamedBean
import org.beangle.data.model.bean.TemporalOnBean
import org.openurp.base.Department
import org.openurp.base.code.Education
import org.openurp.teach.Direction
import org.openurp.teach.DirectionJournal
import org.openurp.teach.Major
import scala.collection.mutable.Buffer



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