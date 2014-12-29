package org.openurp.edu.teach.grade.model

import java.{ util => ju }

import org.beangle.data.model.annotation.config
import org.openurp.base.Semester
import org.openurp.edu.base.ProjectBasedObject
import org.openurp.edu.teach.code.GradeType

@config
class GradeInputSwitch extends ProjectBasedObject[Integer] {

  /**
   * 教学日历
   */
  var semester: Semester = _

  /**
   * 开始时间
   */
  var startAt: ju.Date = _

  /**
   * 关闭时间
   */

  var endAt: ju.Date = _

  /**
   * 允许录入成绩类型
   */
  var types = new collection.mutable.HashSet[GradeType]

  /**
   * 成绩录入开关
   */

  var opened: Boolean = _

  /**
   * 备注
   */

  var remark: String = _

  /**
   * 检查该开关是否开放
   */
  def checkOpen(date: ju.Date): Boolean = {
    if (null == startAt || null == endAt) {
      return false
    }
    if (date.after(endAt) || startAt.after(date)) {
      false
    } else {
      opened
    }
  }

  def isOpen: Boolean = checkOpen(new ju.Date())
}