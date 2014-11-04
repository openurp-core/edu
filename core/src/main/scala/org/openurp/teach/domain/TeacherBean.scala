package org.openurp.teach.domain

import java.sql.Date
import org.beangle.data.model.bean.CodedBean
import org.beangle.data.model.bean.LongIdBean
import org.beangle.data.model.bean.NamedBean
import org.openurp.base.Department
import org.openurp.base.Person
import org.openurp.base.code.Education
import org.openurp.teach.TeacherJournal
import org.openurp.teach.code.TeacherUnitType
import org.openurp.teach.Habilitation
import org.openurp.teach.code.TeacherTitleLevel
import org.openurp.teach.code.TeacherType
import org.openurp.teach.Teacher
import org.openurp.teach.code.Degree
import org.openurp.teach.code.TeacherTitle
import org.openurp.teach.ProjectBasedObject
import org.openurp.teach.code.TeacherState
import org.openurp.teach.code.TutorType
import org.beangle.data.model.bean.TemporalOnBean
/**
 * 教师信息默认实现
 */
class TeacherBean extends LongIdBean with CodedBean with NamedBean with TemporalOnBean with Teacher {
  /**人员信息*/
  var person: Person = _
  /** 部门 */
  var department: Department = _
  /** 兼职部门 */
  var parttimeDepart: Department = _
  /** 职称 */
  var title: TeacherTitle = _
  /** 教职工类别 */
  var teacherType: TeacherType = _
  var titleLevel: TeacherTitleLevel = _
  /** 学历层次 */
  var education: Education = _
  /** 毕业日期 */
  var graduateOn: Date = _
  /** 学位 */
  var degree: Degree = _
  /** 导师类别 */
  var tutorType: TutorType = _
  /** 研导任职年月 */
  var tutorAwardOn: Date = _
  /** 教师在职状态 */
  var state: TeacherState = _
  /** 学位授予年月 */
  var degreeAwardOn: Date = _
  /** 毕业学校 */
  var school: String = _
  /** 备注 */
  var remark: String = _
  /** 状态变化日志 */
  var journals: Set[TeacherJournal] = _
  /** 是否任课 */
  var teaching: Boolean = _
  /** 从何单位聘任 */
  var unit: String = _
  /** 聘任单位的类别 */
  var unitType: TeacherUnitType = _
}

/**
 * 教师日志信息
 *
 * @author chaostone
 */
class TeacherJournalBean extends LongIdBean with TeacherJournal {
  /**教师*/
  var teacher: Teacher = _
  /** 部门 */
  var department: Department = _
  /** 职称 */
  var title: TeacherTitle = _
  /** 学历 */
  var education: Education = _
  /** 学位 */
  var degree: Degree = _
  /** 导师类别 */
  var tutorType: TutorType = _
  /** 起始日期 */
  var beginOn: Date = _
  /** 结束日期 */
  var endOn: Date = _
  /** 备注 */
  var remark: String = _
}

/**
 * 授课资格
 *
 * @author chaostone
 */
class HabilitationBean extends ProjectBasedObject[Integer] with Habilitation {
  /**教师*/
  var teacher: Teacher = _
  /**生效日期*/
  var effectiveOn: Date = _
  /**失效日期*/
  var invalidOn: Date = _
  /**是否合格*/
  var qualified: Boolean = _
}