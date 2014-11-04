package org.openurp.teach.domain

import java.sql.Date

import org.beangle.data.model.Component
import org.beangle.data.model.bean.CodedBean
import org.beangle.data.model.bean.LongIdBean
import org.beangle.data.model.bean.NamedBean
import org.openurp.base.Campus
import org.openurp.base.Department
import org.openurp.base.code.Country
import org.openurp.base.code.Division
import org.openurp.base.code.Education
import org.openurp.base.code.Gender
import org.openurp.base.code.IdType
import org.openurp.base.code.Nation
import org.openurp.base.code.PoliticalAffiliation
import org.openurp.teach.Adminclass
import org.openurp.teach.Direction
import org.openurp.teach.EducationBasedObject
import org.openurp.teach.Major
import org.openurp.teach.Project
import org.openurp.teach.StdPerson
import org.openurp.teach.Student
import org.openurp.teach.StudentJournal
import org.openurp.teach.Teacher
import org.openurp.teach.code.StdLabel
import org.openurp.teach.code.StdLabelType
import org.openurp.teach.code.StdStatus
import org.openurp.teach.code.StdType
import org.openurp.teach.code.StudyType
/**
 * 学籍信息实现
 */
class StudentBean extends  EducationBasedObject[java.lang.Long] with CodedBean with NamedBean with Student {

  /** 英文名 */
  var enName: String = _
  /** 性别 */
  var gender: Gender = _
  /** 年级 表示现在年级，不同于入学时间 */
  var grade: String = _
  /** 管理院系 行政管理院系 */
  var department: Department = _
  /** 专业 当前修读专业 */
  var major: Major = _
  /** 方向 当前修读方向 */
  var direction: Direction = _
  /** 专业所在院系 */
  var majorDepart: Department = _
  /** 学生类别 所在项目内的学生类别 */
  var type1: StdType = _
  /** 学生分类标签 */
  var labels: collection.mutable.Map[StdLabelType, StdLabel] = _
  /** 校区 */
  var campus: Campus = _
  /** 学制 学习年限（允许0.5年出现） */
  var duration: Float = _
  /** 是否有学籍 */
  var registed: Boolean = _
  /** 入学报到日期 */
  var enrollOn: Date = _
  /** 学籍生效日期 */
  var registOn: Date = _
  /** 应毕业时间 预计毕业日期 */
  var graduateOn: Date = _
  /** 行政班级 */
  var adminclass: Adminclass = _
  /** 备注 */
  var remark: String = _
  /** 学习形式 全日制/业余/函授 */
  var studyType:StudyType=_
  /** 状态变化日志 */
  var journals: collection.mutable.Set[StudentJournal] = _
  /**导师*/
  var tutor: Teacher = _
  /**基本信息*/
  var person: StdPerson = _

}

/**
 * 学生基本信息
 *
 * @author chaostone
 * @since 2011-10-12
 */
class StdPersonBean extends LongIdBean with CodedBean with NamedBean with StdPerson {

  /** 英文名 */
  var enName: String = _
  /** 曾用名 */
  var oldname: String = _
  /** 性别 */
  var gender: Gender = _
  /** 出生年月 */
  var birthday: Date = _
  /** 证件类型 身份证/护照等 */
  var idType: IdType = _
  /** 身份证 */
  var idcard: String = _
  /** 国家地区 */
  var country: Country = _
  /** 民族 留学生使用外国民族 */
  var nation: Nation = _
  /** 政治面貌 不适用留学生 */
  var politicalAffiliation: PoliticalAffiliation = _
  /** 入团(党)时间 */
  var joinOn: Date = _
  /** 婚姻状况 */
  //  var maritalStatus:MaritalStatus=_
  /** 籍贯 */
  var ancestralAddr: Division = _
  /** 银行账户 */
  //  var bankAccount:BankAccount=_
  /** 特长爱好以及个人说明 */
  var charactor: String = _

}

/**
 * 学籍状态日志
 */

class StudentJournalBean extends LongIdBean with StudentJournal {

  /** 学生 */
  var std: Student = _
  /** 年级 */
  var grade: String = _
  /** 管理院系 */
  var department: Department = _
  /** 专业 */
  var major: Major = _
  /**专业方向*/
  var direction: Direction = _
  /** 行政班级 */
  var adminclass: Adminclass = _
  /** 是否在校 */
  var inschool: Boolean = _
  /** 学籍状态 */
  var status: StdStatus = _
  /** 起始日期 */
  var beginOn: Date = _
  /** 结束日期 */
  var endOn: Date = _
  /** 备注 */
  var remark: String = _
}

/**
 * 学生范围
 *
 * @author qianjia
 */
class StudentScope extends Component {
  /**年级*/
  var grades: String = _
  /**项目*/
  var project: Project = _
  /**培养层次集合*/
  var educations: Set[Education] = _
  /**学生类别集合*/
  var stdTypes: Set[StdType] = _
  /**部门集合*/
  var departments: Set[Department] = _
  /**专业集合*/
  var majors: Set[Major] = _
  /**专业方向集合*/
  var directions: Set[Direction] = _

}
