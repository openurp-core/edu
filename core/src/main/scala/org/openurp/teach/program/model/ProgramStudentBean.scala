package org.openurp.teach.program.model

import org.beangle.data.model.bean.LongIdBean
import org.openurp.teach.core.Student
import org.beangle.data.model.bean.UpdatedBean
import org.openurp.teach.program.Program


/**
 * 学生培养方案绑定
 *
 */
class ProgramStudentBean extends LongIdBean with UpdatedBean {

  /**
   * 学生
   */
  var std: Student = _

  /**
   * 培养方案
   */
  var program: Program = _
}
