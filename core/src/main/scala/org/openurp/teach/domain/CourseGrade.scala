package org.openurp.teach.domain

import java.util.Date

import org.beangle.data.model.bean.{CodedBean, IntIdBean, LongIdBean, NamedBean}
import org.openurp.base.{Department, Semester}
import org.openurp.base.code.Education
import org.openurp.teach.{Course, CourseGrade, CourseHour, ExamGrade, Grade, Major, Student}
import org.openurp.teach.code.{CourseAbilityRate, CourseCategory, CourseHourType, CourseTakeType, CourseType, ExamMode, ScoreMarkStyle}

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
class CourseBean extends LongIdBean with CodedBean with NamedBean with Course {

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
  var hours: collection.mutable.Seq[CourseHour] = _
  /** 周数*/
  var weeks: Int = _
  /**周课时*/
  var weekHour: Integer = _
  /**院系*/
  var department: Department = _
  /** 设立时间 */
  var establishOn: Date = _
  /** 考试方式 */
  var examMode: ExamMode = _
  /** 成绩记录方式 */
  var markStyle: ScoreMarkStyle = _

  /** 能力等级 */
 var  abilityRates:collection.mutable.Set[CourseAbilityRate]=_
  /**针对专业*/
  var majors: collection.mutable.Set[Major] = _
  /**排除专业*/
  var xmajors: collection.mutable.Set[Major] = _
  /**先修课程*/
  var prerequisites: collection.mutable.Set[Course] = _
  /** 小项课程(板块课) */
  var subcourses: collection.mutable.Set[Course] = _
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
 * 课程成绩
 * </p>
 * 学生因上课取得的成绩，业务唯一主键为[学生、项目、培养类型、学期、课程]。
 * </p>
 * 课程成绩由多个考试成绩组成，一般为平时、期末、补考、缓考、总评等成绩成分。
 *
 * @depend - - - Lesson
 * @depend - - - Course
 * @depend - - - CourseType
 * @depend - - - CourseTakeType
 * @composed 1 has * ExamGrade
 * @depend - - - Project
 * @depend - - - Education
 * @author chaostone
 * @since 2006
 */

class CourseGradeBean extends LongIdBean with CourseGrade {
  /**
   * 设置学生
   *
   * @param std
   *            学生
   */
  var std: Student = _
  /**
   * 设置课程
   *
   * @param course
   *            课程
   */
  var course: Course = _
  /**
   * 获得修读类别
   *
   * @return 修读类别
   */
  var courseTakeType: CourseTakeType = _
  /**
   * 返回学期
   *
   * @return 学期
   */
  var semester: Semester = _
  /**
   * 返回任务序号
   *
   * @return 任务序号
   */
  var lessonNo: String = _
  /**
   * 返回课程类别
   *
   * @return 课程类别
   */
  var courseType: CourseType = _
  /**
   * 设置绩点
   *
   * @param gp
   *            绩点
   */
  var gp: Float = _
  /**
   * 返回考试成绩
   *
   * @return 考试成绩
   */
  var examGrades: collection.mutable.Set[ExamGrade] = _
  /**
   * 返回指定类型的分数
   *
   * @param gradeType
   *            成绩类型
   * @return 考试成绩分数
   */
  //  var scoreText:GradeType
  /**
   * 得到指定的考试成绩
   *
   * @param gradeType
   *            成绩类型
   * @return 考试成绩
   */
  //var examGrade: ExamGrade= _
  /**
   * 返回考核方式
   *
   * @return 考核方式
   */
  var examMode: ExamMode = _
  /**
   * 返回备注
   *
   * @return 备注
   */
  var remark: String = _
  /**
   * 返回是否设置个人百分比
   *
   * @return boolean
   */
  var personPercent: Boolean = _
  /**
   * 返回外校交流课程
   *
   * @return
   */
  //   var exchanges:Set[ExchangeCourse]
  var score: java.lang.Float = _
  var scoreText: String = _
  var passed: Boolean = _
  var published: Boolean = _
  var status: Integer = _
  var beyondSubmit: Boolean = _
  var markStyle: ScoreMarkStyle = _
  var operator: String = _

  // 大的成绩放前面
  override def compare(grade: Grade): Int = {
    if (null == score) return 1
    else if (null == grade.score) return -1
    return grade.score.compareTo(score)
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



