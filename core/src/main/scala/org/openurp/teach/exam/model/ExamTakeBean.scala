package org.openurp.teach.exam.model

import org.beangle.data.model.bean.LongIdBean
import org.openurp.base.{ Room, Semester }
import org.openurp.teach.code.{ ExamStatus, ExamType }
import org.openurp.teach.core.Student
import org.openurp.teach.lesson.Lesson
import org.openurp.teach.exam.ExamTake
import org.openurp.teach.exam.ExamActivity

class ExamTakeBean extends LongIdBean with ExamTake {

  /** 教学任务 */
  var lesson: Lesson = _

  /** 学生 */
  var std: Student = _
  
  /** 考试类型 */
  var examType: ExamType = _

  /** 考试活动*/
  var activity: ExamActivity = _

  /** 考场 */
  var room: Room = _

  /** 考试情况 */
  var examStatus: ExamStatus = _

  /** 缓考申请原因/记录处分 */
  var remark: String = _

  /** 考场座位号 */
  var seatNo: Short = _
}