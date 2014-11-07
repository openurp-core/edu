package org.openurp.teach.exam.model

import org.beangle.data.model.bean.{ LongIdBean, TemporalAtBean }
import org.openurp.base.{ Room, Semester }
import org.openurp.teach.exam.{ ExamActivity, ExamBatch }
import org.openurp.teach.lesson.Lesson
import org.beangle.commons.lang.time.HourMinute
import java.sql.Date

class ExamActivityBean extends LongIdBean with ExamActivity {

  /** 教学任务 */
  var lesson: Lesson = _

  /** 学年学期 */
  var semester: Semester = _

  var examBatch: ExamBatch = _

  var examOn: Date = _

  var beginAt: HourMinute = _

  var endAt: HourMinute = _

  /** 备注 */
  var remark: String = _

  /** 考场列表 */
  var examRooms: collection.mutable.Set[Room] = _

  /** 审核状态 */
  //var state: ExamAuditState=_

}