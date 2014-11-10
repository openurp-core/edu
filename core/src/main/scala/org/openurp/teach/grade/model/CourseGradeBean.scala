package org.openurp.teach.grade.model

import org.beangle.data.model.bean.{ IntIdBean, UpdatedBean }
import org.openurp.base.Semester
import org.openurp.teach.code.{ CourseHourType, CourseTakeType, CourseType, ExamMode, ScoreMarkStyle }
import org.openurp.teach.core.{ Course, ProjectBasedObject, Student }
import org.openurp.teach.lesson.Lesson
import org.openurp.teach.grade.ExamGrade
import org.openurp.teach.grade.CourseGrade
import org.openurp.teach.grade.Grade
import org.openurp.teach.code.GradeType

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

class CourseGradeBean extends ProjectBasedObject[java.lang.Long] with CourseGrade with UpdatedBean {
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
  var gp: java.lang.Float = _
  /**
   * 返回考试成绩
   *
   * @return 考试成绩
   */
  var examGrades: collection.mutable.Set[ExamGrade] = _
  /**
   * 得到指定的考试成绩
   */
  def getExamGrade(gradeType: GradeType): ExamGrade = {
    examGrades.find(eg => eg.gradeType == gradeType).orNull
  }
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
  var score: java.lang.Float = _
  var scoreText: String = _
  var passed: Boolean = _
  var status: Int = _
  var markStyle: ScoreMarkStyle = _
  var operator: String = _
  var lesson: Lesson = _

  // 大的成绩放前面
  override def compare(grade: Grade): Int = {
    if (null == score) return 1
    else if (null == grade.score) return -1
    return grade.score.compareTo(score)
  }
}