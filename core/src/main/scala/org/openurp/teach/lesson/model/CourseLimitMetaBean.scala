package org.openurp.teach.lesson.model

import org.beangle.data.model.bean.{LongIdBean, NamedBean}
import org.openurp.teach.lesson.CourseLimitMeta

class CourseLimitMetaBean extends LongIdBean with CourseLimitMeta with NamedBean {

  /** 备注 */
  var remark: String = _

}