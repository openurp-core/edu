package org.openurp.teach.grade.domain

import org.openurp.base.Semester
import org.beangle.data.model.bean.LongIdBean

/**
 * 每学期绩点
 *
 * @author chaostone
 */
class StdSemesterGpa extends LongIdBean {

  /**
   * 学生绩点
   */
  var stdGpa: StdGpa = _

  /**
   * 学期
   */
  var semester: Semester = _

  /**
   * 平均绩点
   */
  var gpa: Float = _

  /**
   * 平均分
   */
  var ga: Float = _

  /**
   * 获得学分
   */
  var credits: Float = _

  /**
   * 修读学分
   */
  var totalCredits: Float = _

  /**
   * 总成绩数量
   */
  var count: Int = 0

  def this(semester: Semester, gpa: java.lang.Float) {
    this()
    this.semester = semester
    this.gpa = gpa
  }
}
