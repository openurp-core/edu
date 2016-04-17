package org.openurp.edu.teach.grade.course.domain.impl

import org.openurp.edu.teach.grade.domain.NumPrecisionReserveMethod

/**
 * 四舍五入进位法
 *
 * @author chaostone
 */
class MoreHalfReserveMethod extends NumPrecisionReserveMethod {

  def reserve(value: Float, precision: Int): Float = {
    val mutilply = Math.pow(10, precision + 1).toInt
    var num = value
    num *= mutilply
    if (num % 10 >= 5) num += 10
    num -= num % 10
    num / mutilply
  }

  def reserve(value: Double, precision: Int): Double = {
    val mutilply = Math.pow(10, precision + 1).toInt
    var num = value
    num *= mutilply
    if (num % 10 >= 5) num += 10
    num -= num % 10
    num / mutilply
  }
}
