package org.openurp.teach.domain

import org.beangle.data.model.bean.TemporalOnBean
import org.beangle.data.model.bean.LongIdBean
import org.openurp.base.Semester
import org.openurp.teach.code.CourseTakeType
import org.openurp.teach.CourseTake
import org.openurp.teach.Course
import org.openurp.teach.Lesson
import org.openurp.teach.Student
import org.openurp.teach.CourseLimitGroup
import org.openurp.teach.code.ElectionMode

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