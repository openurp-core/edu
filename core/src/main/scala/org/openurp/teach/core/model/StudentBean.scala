package org.openurp.teach.core.model

import java.sql.Date
import org.beangle.data.model.Component
import org.beangle.data.model.bean.{ CodedBean, LongIdBean, NamedBean }
import org.openurp.base.{ Campus, Department }
import org.openurp.base.code.{ Country, Division, Education, Gender, IdType, Nation, PoliticalAffiliation }
import org.openurp.teach.code.{ StdLabel, StdLabelType, StdStatus, StdType, StudyType }
import org.openurp.teach.core.Adminclass
import org.openurp.teach.core.Major
import org.openurp.base.Teacher
import org.openurp.base.Person
import org.openurp.teach.core.EducationBasedObject
import org.openurp.teach.core.Project
import org.openurp.teach.core.StudentJournal
import org.openurp.teach.core.Student
import org.openurp.teach.core.Direction
/**
 * 学籍信息实现
 */
class StudentBean extends EducationBasedObject[java.lang.Long] with CodedBean with NamedBean with Student {

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
  var stdType: StdType = _
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
  var studyType: StudyType = _
  /** 状态变化日志 */
  var journals: collection.mutable.Seq[StudentJournal] = _
  /**导师*/
  var tutor: Teacher = _
  /**基本信息*/
  var person: Person = _

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
  var educations: collection.mutable.Set[Education] = _
  /**学生类别集合*/
  var stdTypes: collection.mutable.Set[StdType] = _
  /**部门集合*/
  var departments: collection.mutable.Set[Department] = _
  /**专业集合*/
  var majors: collection.mutable.Set[Major] = _
  /**专业方向集合*/
  var directions: collection.mutable.Set[Direction] = _

}
