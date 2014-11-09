package org.openurp.teach.core.model

import java.sql.Date

import org.beangle.data.model.bean.{ IntIdBean, NamedBean, UpdatedBean }
import org.openurp.base.Department
import org.openurp.base.code.{ Degree, Education }
import org.openurp.teach.code.{ StdType, StudyType }
import org.openurp.teach.core.{ Direction, Major, Program, States }

/**
 * 专业培养方案
 * @author chaostone
 *
 */
class ProgramBean extends IntIdBean with UpdatedBean with NamedBean with Program {

  /**
   * 年级
   */
  var grade: String = _

  /**
   * 部门
   */
  var department: Department = _

  /**
   * 培养层次
   */
  var education: Education = _

  /**
   * 学生类别
   */
  var stdType: StdType = _

  /**
   * 专业
   */
  var major: Major = _

  /**
   * 专业方向
   */
  var direction: Direction = _

  /**
   * 学制
   */
  var duration: Float = _

  /**
   * 学习形式
   */
  var studyType: StudyType = _

  /**
   * 毕业授予学位
   */
  var degree: Degree = _

  /**
   * 开始日期
   */
  var beginOn: Date = _

  /**
   * 结束日期 结束日期包括在有效期内
   */
  var endOn: Date = _

  /**
   * 备注
   */
  var remark: String = _

  /**
   * 审核状态
   */
  var state: States.State = States.Draft
}
