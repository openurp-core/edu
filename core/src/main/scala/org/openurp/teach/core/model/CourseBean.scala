package org.openurp.teach.core.model

import java.sql.Date

import org.beangle.data.model.bean.{ CodedBean, IntIdBean, NamedBean, UpdatedBean }
import org.openurp.base.Department
import org.openurp.base.code.Education
import org.openurp.teach.code.{ CourseAbilityRate, CourseCategory, CourseHourType, CourseType, ExamMode, ScoreMarkStyle }
import org.openurp.teach.core.{ ProjectBasedObject, Course, CourseHour, Major }

/**
 * 课程基本信息 </p>
 * 记录课程代码、名称、学分、课时等基本信息，课程的关键业务属性为课程名称、学分、课时、考核方式等与课程有关的属性，其它类似课程类别、所属部门等
 * 均可以看作非关键属性。 </p> 如课程不要求记录学分、不做考核要求、不计算绩点等额外要求需要培养方案、成绩等环节进行额外处理，不在课程部分进行规定。
 * <p>
 * 课程的学历层次可以不加指定，为空时表示适用与对应项目下的所有学历层次。
 *
 * @depend - - - CourseCategory
 * @depend - - - Department
 * @depend - - - CourseType
 * @depend - - - ExamMode
 * @author cheneystar
 * @author chaostone
 * @since 2008-09-24
 */
class CourseBean extends ProjectBasedObject[Integer] with CodedBean with NamedBean with UpdatedBean with Course {

  def this(id: Integer, code: String, name: String, enName: String) {
    this()
    this.id = id
    this.code = code
    this.name = name
    this.enName = enName
  }
  /**课程英文名*/
  var enName: String = _
  /** 学历层次 */
  var education: Education = _
  /**课程种类代码*/
  var category: CourseCategory = _
  /**学分*/
  var credits: Float = _
  /** 学时/总课时 */
  var period: Int = _
  /**课程类型*/
  var courseType: CourseType = _
  /** 分类课时 */
  var hours: collection.mutable.Seq[CourseHour] = new collection.mutable.ListBuffer[CourseHour]
  /** 周数*/
  var weeks: Integer = _
  /**周课时*/
  var weekHour: Int = _
  /**院系*/
  var department: Department = _
  /** 设立时间 */
  var establishOn: Date = _
  /** 考试方式 */
  var examMode: ExamMode = _
  /** 成绩记录方式 */
  var markStyle: ScoreMarkStyle = _

  /** 能力等级 */
  var abilityRates: collection.mutable.Set[CourseAbilityRate] = new collection.mutable.HashSet[CourseAbilityRate]
  /**针对专业*/
  var majors: collection.mutable.Set[Major] = new collection.mutable.HashSet[Major]
  /**排除专业*/
  var xmajors: collection.mutable.Set[Major] = new collection.mutable.HashSet[Major]
  /**先修课程*/
  var prerequisites: collection.mutable.Set[Course] = new collection.mutable.HashSet[Course]
  /** 小项课程(板块课) */
  var subcourses: collection.mutable.Set[Course] = new collection.mutable.HashSet[Course]
  /**课程使用状态*/
  var enabled: Boolean = _
  /**课程备注*/
  var remark: String = _
  /** 是否计算绩点 **/
  var calGp: Boolean = _

  override def compare(other: Course): Int = {
    code.compareTo(other.code)
  }
}

/**
 * 课程分类课时信息
 *
 * @author chaostone
 */

class CourseHourBean extends IntIdBean with CourseHour {
  var course: Course = _
  var period: Integer = _
  var weekHour: Integer = _
  var weeks: Integer = _
  var hourType: CourseHourType = _
}
