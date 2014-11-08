package org.openurp.teach.exam.model

import java.sql.Date

import org.beangle.commons.lang.time.HourMinute
import org.beangle.data.model.bean.LongIdBean
import org.openurp.teach.code.ExamType
import org.openurp.teach.exam.{ ExamActivity, ExamRoom }
import org.openurp.teach.lesson.Lesson

class ExamActivityBean extends LongIdBean with ExamActivity {
  /** 考试类型 */
  var examType: ExamType = _

  /** 教学任务 */
  var lesson: Lesson = _

  var examOn: Date = _

  var beginAt: HourMinute = _

  var endAt: HourMinute = _

  /** 备注 */
  var remark: String = _

  /** 考场列表 */
  var rooms: collection.mutable.Buffer[ExamRoom] = _

}