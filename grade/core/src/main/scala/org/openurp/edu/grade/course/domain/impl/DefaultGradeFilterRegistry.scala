package org.openurp.edu.grade.course.domain.impl

import org.beangle.commons.lang.Strings
import org.beangle.commons.inject.Container
import org.openurp.edu.grade.course.domain.GradeFilter
import org.beangle.commons.inject.ContainerListener
import org.openurp.edu.grade.course.domain.GradeFilterRegistry

/**
 * 基于spring的过滤器注册表
 *
 * @author chaostone
 */
class DefaultGradeFilterRegistry extends GradeFilterRegistry with ContainerListener {

  var filters: Map[Any, GradeFilter] = _

  override def onStarted(container: Container): Unit = {
    filters = container.getBeans(classOf[GradeFilter])
  }

  def getFilter(name: String): GradeFilter = filters.get(name).orNull

  def getFilters(name: String): List[GradeFilter] = {
    if (Strings.isBlank(name)) return List.empty
    val filterNames = Strings.split(name, Array('|', ',')).toSet
    filters.filter(e => filterNames.contains(e._1.asInstanceOf[String])).values.toList
  }
}
