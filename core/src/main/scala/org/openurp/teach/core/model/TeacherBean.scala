package org.openurp.teach.core.model

import java.sql.Date
import org.beangle.data.model.bean.{ CodedBean, LongIdBean, NamedBean, TemporalOnBean }
import org.openurp.base.{ Department, Person }
import org.openurp.base.code.Education
import org.openurp.teach.core.ProjectBasedObject
import org.openurp.teach.core.Habilitation
import org.openurp.base.Teacher

/**
 * 授课资格
 *
 * @author chaostone
 */
class HabilitationBean extends ProjectBasedObject[Integer] with Habilitation {
  /**教师*/
  var teacher: Teacher = _
  /**生效日期*/
  var effectiveOn: Date = _
  /**失效日期*/
  var invalidOn: Date = _
  /**是否合格*/
  var qualified: Boolean = _
}