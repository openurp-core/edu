package org.openurp.edu.teach.grade.course.domain.impl

import org.openurp.edu.teach.grade.course.model.CourseGrade
import org.openurp.edu.teach.grade.course.domain.GpaPolicy

class DefaultGpaPolicy extends GpaPolicy {

  /**
   * 平均绩点和平均分的精确位
   */
  val precision = 2

  def calcGa(grades: Iterable[CourseGrade]): java.lang.Float = {
    var credits = 0f
    var creditGas = 0d
    for (grade <- grades) {
      var score = grade.score
      var add = true
      if (null == score) {
        score = 0f
        add = !(grade.passed)
      }
      if (add) {
        val credit = grade.course.credits
        credits += credit
        creditGas += (credit * score)
      }
    }
    round(if ((credits == 0)) null else new java.lang.Float(creditGas / credits))
  }

  /**
   * 标准Gpa算法<br>
   * gpa=∑绩点*学分/∑学分
   */
  def calcGpa(grades: Iterable[CourseGrade]): java.lang.Float = {
    var credits = 0d
    var creditGps = 0d
    for (grade <- grades if null != grade.gp) {
      val credit = grade.course.credits
      credits += credit
      creditGps += credit * (grade.gp.doubleValue)
    }
    round(if ((credits == 0)) null else new java.lang.Float(creditGps / credits))
  }

  /**
   * 保留小数位(默认四舍五入)
   */
  def round(score: java.lang.Float): java.lang.Float = {
    if (null == score) return null
    var result = score
    val mutilply = Math.pow(10, precision).toInt
    result *= mutilply
    if (score % 1 >= 0.5) {
      result += 1
    }
    result -= result % 1
    (new java.lang.Float(result / mutilply))
  }
}
