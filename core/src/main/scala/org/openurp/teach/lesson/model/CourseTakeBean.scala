package org.openurp.teach.lesson.model

import org.beangle.data.model.bean.{LongIdBean, TemporalOnBean}
import org.openurp.base.Semester
import org.openurp.teach.code.{CourseTakeType, ElectionMode}
import org.openurp.teach.core.Student
import org.openurp.teach.grade.Course
import org.openurp.teach.lesson.{CourseLimitGroup, CourseTake, Lesson}

class CourseTakeBean extends LongIdBean with TemporalOnBean with CourseTake {

  /** 教学任务 */
  var lesson: Lesson = _

  var course: Course = _

  var semester: Semester = _

  /** 学生 */
  var std: Student = _

  /** 修读类别 */
  var courseTakeType: CourseTakeType = _

  /** 选课方式 **/
  var electionMode: ElectionMode = _

  /** 选课轮次 */
  var turn: Integer = _

  /** 备注 */
  var remark: String = _

  /** 重修费是否支付 */
  var paid: Boolean = false

  /** 是否上课 */
  var attend: Boolean = true

  /** 重修账单 */
  var billId: Long = _

  /** 授课对象组 */
  var limitGroup: CourseLimitGroup = _

  /** 选课状态 */
  var state: String = _//SELECTED

  /** 电子货币花费 */
  var virtualCost: Integer = _

  override def compare(other: CourseTake): Int = {
    //fix me
    //
    -1
  }
}