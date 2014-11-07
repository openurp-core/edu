package org.openurp.teach.domain

import org.beangle.data.model.bean.LongIdBean
import org.openurp.teach.CourseLimitGroup
import org.openurp.teach.CourseLimitItem
import org.openurp.teach.CourseLimitMeta
import org.openurp.teach.Operator

class CourseLimitItemBean extends LongIdBean with CourseLimitItem {

  /** 限制具体项目 */
  var meta: CourseLimitMeta = _

  /** 所在限制组 */
  var group: CourseLimitGroup = _

  /** 操作符 */
  var operator: Operator = _

  /** 限制内容 */
  var content: String = _

}