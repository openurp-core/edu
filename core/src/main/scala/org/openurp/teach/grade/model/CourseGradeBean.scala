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
import org.openurp.teach.grade.GaGrade
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Buffer
import org.openurp.teach.code.model.GradeTypeBean

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
   */
  var std: Student = _
  /**
   * 设置课程
   */
  var course: Course = _
  /**
   * 获得修读类别
   */
  var courseTakeType: CourseTakeType = _
  /**
   * 学期
   */
  var semester: Semester = _
  /**
   * 任务序号
   */
  var lessonNo: String = _
  /**
   * 课程类别
   */
  var courseType: CourseType = _
  /**
   * 设置绩点
   */
  var gp: java.lang.Float = _

  var bonus: java.lang.Float = _

  /**
   * 总评成绩
   */
  var gaGrades: Buffer[GaGrade] = new ListBuffer[GaGrade]
  /**
   * 考核成绩
   */
  var examGrades: Buffer[ExamGrade] = new ListBuffer[ExamGrade]
  /**
   * 得到指定的考试成绩
   */
  def getGrade(gradeType: GradeType): Grade = {
    if (gradeType.isGa) gaGrades.find(eg => eg.gradeType == gradeType).orNull
    else examGrades.find(eg => eg.gradeType == gradeType).orNull
  }

  def getGrade(gradeTypeId: Integer): Grade = {
    getGrade(new GradeTypeBean(gradeTypeId))
  }
  /**
   * 考核方式
   */
  var examMode: ExamMode = _
  /**
   * 备注
   */
  var remark: String = _
  var score: java.lang.Float = _
  var scoreText: String = _
  var passed: Boolean = _
  var status: Int = _
  var markStyle: ScoreMarkStyle = _
  var operator: String = _
  var lesson: Lesson = _

  def gradeType:GradeType={
    new GradeTypeBean(GradeType.Final)
  }
  // 大的成绩放前面
  override def compare(grade: Grade): Int = {
    if (null == score) return 1
    else if (null == grade.score) return -1
    return grade.score.compareTo(score)
  }
}
