package org.openurp.teach.domain

import org.beangle.data.model.bean.LongIdBean
import org.openurp.base.Semester
import org.openurp.teach.ExamTake
import org.openurp.teach.ExamBatch
import org.openurp.teach.code.ExamStatus
import org.openurp.teach.Lesson
import org.openurp.base.Room
import org.openurp.teach.code.ExamType
import org.openurp.teach.Student

class ExamTakeBean extends LongIdBean  with  ExamTake{

  /** 教学任务 */
  var lesson: Lesson = _

  /** 学生 */
  var std: Student = _

  /** 教学日历 */
  var semester: Semester = _

  /** 考场 */
  var examRoom: Room = _

  /** 考试类型 */
  var examType: ExamType = _

  /** 考试情况 */
  var examStatus: ExamStatus = _

  /** 缓考申请原因/记录处分 */
  var remark: String = _

  /** 考场座位号 */
  var seatNo: Integer = _

  var examBatch: ExamBatch = _
}