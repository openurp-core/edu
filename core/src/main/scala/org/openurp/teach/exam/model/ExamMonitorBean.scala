package org.openurp.teach.exam.model

import org.openurp.base.Department
import org.openurp.base.Person
import org.beangle.data.model.bean.LongIdBean
import org.openurp.teach.exam.ExamMonitor
import org.openurp.teach.exam.ExamRoom

/**
 * 监考信息
 *
 * @author chaostone
 */
class ExamMonitorBean extends LongIdBean with ExamMonitor {

  /**
   * 排考活动
   */
  var examRoom: ExamRoom = _

  /**
   * 监考老师
   */
  var person: Person = _

  /**
   * 监考院系
   */
  var department: Department = _

  def this(examRoom: ExamRoom, person: Person, department: Department) {
    this()
    this.person = person
    this.examRoom = examRoom
    this.department = department
  }
}
