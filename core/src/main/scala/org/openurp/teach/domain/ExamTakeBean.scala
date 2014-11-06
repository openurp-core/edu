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

class ExamTakeBean extends ExamTake with LongIdBean{

  /** 教学任务 */
  def lesson: Lesson=_

  /** 学生 */
  def std: Student=_

  /** 教学日历 */
  def semester: Semester=_

  /** 考场 */
  def examRoom: Room=_

  /** 考试类型 */
  def examType: ExamType=_

  /** 考试情况 */
  def examStatus: ExamStatus=_

  /** 缓考申请原因/记录处分 */
  def remark: String=_

  /** 考场座位号 */
  def seatNo: Integer=_

  def examBatch: ExamBatch=_
}