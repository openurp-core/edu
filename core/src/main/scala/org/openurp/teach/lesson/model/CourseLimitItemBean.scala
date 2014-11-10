package org.openurp.teach.lesson.model

import org.beangle.data.model.bean.IntIdBean
import org.openurp.teach.lesson.{ CourseLimitGroup, CourseLimitItem, CourseLimitMeta }

class CourseLimitItemBean extends IntIdBean with CourseLimitItem {

  /** 限制具体项目 */
  var meta: CourseLimitMeta = _

  /** 所在限制组 */
  var group: CourseLimitGroup = _

  /** 操作符 */
  var operator: String = _

  /** 限制内容 */
  var content: String = _

}