package org.openurp.teach.domain

import org.openurp.teach.ProjectBasedObject
import org.openurp.teach.Lesson
import org.openurp.base.Semester
import org.openurp.base.Department
import org.openurp.base.Campus
import org.openurp.teach.code.CourseType
import org.openurp.teach.Teacher
import org.openurp.teach.code.ExamMode
import org.openurp.teach.Course
import org.beangle.data.model.bean.UpdatedBean
import org.openurp.teach.code.ExamForm
import org.openurp.teach.CourseSchedule
import org.openurp.teach.code.TeachLangType
import org.openurp.teach.code.CourseType
import org.openurp.teach.Teacher
import org.openurp.teach.code.ExamMode
import org.openurp.teach.Course
import org.openurp.teach.TeachClass
import org.openurp.teach.LessonGroup
import org.openurp.teach.ExamSchedule
import org.openurp.teach.ProjectBasedObject
import org.openurp.teach.Lesson
import org.openurp.teach.CommonAuditState

class LessonBean extends ProjectBasedObject[java.lang.Long] with UpdatedBean with Lesson {

  /** 课程序号 */
  var no: String = _

  /** 课程 */
  var course: Course = _

  /** 小项课程 */
  var subCourse: Course = _

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