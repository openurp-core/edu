package org.openurp.edu.grade.course.domain

/**
 * 成绩过滤器注册表
 *
 * @author chaostone
 */
trait GradeFilterRegistry {

  def getFilter(name: String): GradeFilter

  def getFilters(names: String): Seq[GradeFilter]
}
