package org.openurp.teach.domain

import org.beangle.data.model.bean.LongIdBean
import org.beangle.data.model.bean.TemporalAtBean
import org.openurp.teach.ExamActivity
import org.openurp.teach.Lesson
import org.openurp.base.Semester
import org.openurp.teach.ExamActivity
import org.openurp.base.Room
import org.openurp.teach.ExamBatch
import org.openurp.teach.Lesson
import org.openurp.teach.ExamActivity
import org.openurp.teach.ExamBatch
import org.openurp.teach.Lesson

class ExamActivityBean extends LongIdBean with ExamActivity with TemporalAtBean{
  
  /** 教学任务 */
  var lesson: Lesson=_

  /** 学年学期 */
  var semester: Semester=_

  var examBatch: ExamBatch=_

  /** 备注 */
  var remark: String=_

  /** 考场列表 */
  var examRooms: collection.mutable.Set[Room]=_

  /** 审核状态 */
  //var state: ExamAuditState=_


}