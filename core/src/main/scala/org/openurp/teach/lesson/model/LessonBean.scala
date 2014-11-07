package org.openurp.teach.lesson.model

import org.beangle.data.model.bean.UpdatedBean
import org.openurp.base.{ Campus, Department, Semester }
import org.openurp.teach.code.{ CourseType, ExamForm, ExamMode, TeachLangType }
import org.openurp.teach.core.{ CommonAuditState, ProjectBasedObject, Teacher }
import org.openurp.teach.lesson.{ CourseSchedule, ExamSchedule, Lesson, LessonGroup, TeachClass }
import org.openurp.teach.core.Course

class LessonBean extends ProjectBasedObject[java.lang.Long] with UpdatedBean with Lesson {

  /** 课程序号 */
  var no: String = _

  /** 课程 */
  var course: Course = _

  /** 课程类别 */
  var courseType: CourseType = _

  /** 开课院系 */
  var teachDepart: Department = _

  /** 授课教师 */
  var teachers: collection.mutable.Seq[Teacher] = new collection.mutable.ListBuffer[Teacher]

  /** 开课校区 */
  var campus: Campus = _

  /** 教学班 */
  var teachClass: TeachClass = _

  /** 教学日历 */
  var semester: Semester = _

  /** 课程安排 */
  var courseSchedule: CourseSchedule = _

  /** 考试安排 */
  var examSchedule: ExamSchedule = _

  /** 备注 */
  var remark: String = _

  /** 考试方式 */
  var examMode: ExamMode = _

  /** 授课语言类型 */
  var langType: TeachLangType = _

  /** 所属课程组 */
  var group: LessonGroup = _

  /** 审核状态 */
  var auditStatus: CommonAuditState = _

  /** 考试形式 开/闭卷 */
  var examForm: ExamForm = _

  /** 任务课时 */
  var coursePeriod: Int = _

}