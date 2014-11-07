package org.openurp.teach.grade.domain.impl

import org.openurp.teach.grade.domain.GradeFilter

/**
 * 成绩过滤器注册表
 *
 * @author chaostone
 */
trait GradeFilterRegistry {

  def getFilter(name: String): GradeFilter

  def getFilters(names: String): List[GradeFilter]
}
