package org.openurp.teach.grade.domain

import org.beangle.data.model.bean.LongIdBean

/**
 * 学生学年绩点
 *
 * @author chaostone
 */
class StdYearGpa extends LongIdBean {

  /**
   * 学生绩点
   */
  var stdGpa: StdGpa = _

  /**
   * 学年度
   */
  var schoolYear: String = _

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
  var count: Int = _
}
