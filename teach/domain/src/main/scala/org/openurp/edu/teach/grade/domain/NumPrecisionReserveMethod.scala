package org.openurp.edu.teach.grade.domain

/**
 * 保留数字精确位的方法
 *
 * @author chaostone
 */
trait NumPrecisionReserveMethod {

  def reserve(num: Float, precision: Int): Float

  def reserve(num: Double, precision: Int): Double
}
