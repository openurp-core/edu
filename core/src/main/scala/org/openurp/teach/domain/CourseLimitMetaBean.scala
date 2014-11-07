package org.openurp.teach.domain

import org.beangle.data.model.bean.LongIdBean
import org.openurp.teach.CourseLimitMeta
import org.beangle.data.model.bean.NamedBean

class CourseLimitMetaBean extends LongIdBean with CourseLimitMeta with NamedBean {

  /** 备注 */
  var remark: String = _

}