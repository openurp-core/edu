package org.openurp.teach.grade.model

import org.beangle.data.model.bean.{ LongIdBean, UpdatedBean }
import org.openurp.teach.code.{ ExamStatus, GradeType, ScoreMarkStyle }
import org.openurp.teach.grade.{ CourseGrade, ExamGrade, Grade }
import org.openurp.teach.grade.GaGrade

/**
 * 总评成绩
 * </p>
 * 期末总评成绩,补考总评成绩
 *
 * @depend - - - GradeType
 * @depend - - - ScoreMarkStyle
 * @depend - - - ExamStatus
 * @depend - - - CourseGrade
 * @author chaostone
 * @since 2005
 */
class GaGradeBean extends LongIdBean with GaGrade with UpdatedBean {

  def this(id: java.lang.Long, gradeType: GradeType, score: java.lang.Float, scoreText: String, markStyle: ScoreMarkStyle, passed: Boolean, status: Int) {
    this()
    this.id = id
    this.gradeType = gradeType
    this.score = score
    this.scoreText = scoreText
    this.markStyle = markStyle
    this.passed = passed
    this.status = status
  }
  /** 成绩类型 */
  var gradeType: GradeType = _
  /** 成绩记录方式 */
  var markStyle: ScoreMarkStyle = _
  /** 得分 */
  var score: java.lang.Float = _
  /** 得分字面值 */
  var scoreText: String = _
  /** 对应的课程成绩 */
  var courseGrade: CourseGrade = _
  /** 成绩状态 */
  var status: Int = _
  /** 是否通过 */
  var passed: Boolean = _
  /** 操作者 */
  var operator: String = _
  /**绩点*/
  var gp: java.lang.Float = _
  /***/
  var ratio: Short = 100

  def std = courseGrade.std
  // 大的成绩放前面
  override def compare(grade: Grade): Int = {
    if (null == score) return 1
    else if (null == grade.score) return -1
    return grade.score.compareTo(score)
  }

}