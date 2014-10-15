package org.openurp.teach.base.domain

import org.beangle.data.model.bean.IntIdBean
import org.openurp.teach.base.CourseGrade
import org.openurp.teach.base.ExamGrade
import org.openurp.teach.base.code.ExamStatus
import org.openurp.teach.base.code.ExamType
import org.openurp.teach.base.code.GradeType
import org.openurp.teach.base.code.ScoreMarkStyle
import org.beangle.data.model.bean.LongIdBean
import org.openurp.teach.base.Grade

/**
 * 考试成绩
 * </p>
 * 平时成绩,期中成绩,期末成绩,总评成绩,补考成绩,缓考成绩
 *
 * @depend - - - GradeType
 * @depend - - - ScoreMarkStyle
 * @depend - - - ExamStatus
 * @depend - - - CourseGrade
 * @author chaostone
 * @since 2005
 */
class ExamGradeBean extends LongIdBean with ExamGrade {

  /** 成绩类型 */
  var gradeType: GradeType = _
  /** 成绩记录方式 */
  var markStyle: ScoreMarkStyle = _
  var examType: ExamType = _
  /** 得分 */
  var score: java.lang.Float = _
  /** 得分字面值 */
  var scoreText: String = _
  /** 对应的课程成绩 */
  var courseGrade: CourseGrade = _
  /** 成绩状态 */
  var status: Integer = _
  /** 是否通过 */
  var passed: Boolean = _
  /** 操作者 */
  var operator: String = _
  /**考试情况 */
  var examstatus: ExamStatus = _
  /**个人百分比 */
  var percent: Integer = _

  var published: Boolean = _
  var beyondSubmit: Boolean = _
  
    // 大的成绩放前面
  override def compare(grade:Grade) :Int={
    if (null == score) return 1
    else if (null == grade.score) return -1
    return grade.score.compareTo(score)
  }


}