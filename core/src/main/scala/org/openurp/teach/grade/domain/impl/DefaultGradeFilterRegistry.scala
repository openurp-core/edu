package org.openurp.teach.grade.domain.impl

import org.beangle.commons.inject.ContainerRefreshedHook
import org.beangle.commons.lang.Strings
import org.beangle.commons.inject.Container
import org.openurp.teach.grade.domain.GradeFilter

/**
 * 基于spring的过滤器注册表
 *
 * @author chaostone
 */
class DefaultGradeFilterRegistry extends GradeFilterRegistry with ContainerRefreshedHook {

  var filters: Map[Any, GradeFilter] = _

  def notify(container: Container): Unit = {
    filters = container.getBeans(classOf[GradeFilter])
  }

  def getFilter(name: String): GradeFilter = filters.get(name).orNull

  def getFilters(name: String): List[GradeFilter] = {
    if (Strings.isBlank(name)) return List.empty
    val filterNames = Strings.split(name, Array('|', ',')).toSet
    filters.filter(e => filterNames.contains(e._1.asInstanceOf[String])).values.toList
  }
}
