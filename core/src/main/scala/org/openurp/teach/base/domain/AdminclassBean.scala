package org.openurp.teach.base.domain

import org.openurp.teach.base.Adminclass
import org.openurp.teach.base.EducationBasedObject
import org.beangle.data.model.bean.NamedBean
import org.beangle.data.model.bean.CodedBean
import org.openurp.teach.base.Major
import org.openurp.base.Department
import org.openurp.teach.base.code.StdType
import org.openurp.teach.base.Direction
import java.util.Date
import org.openurp.teach.base.Student
import org.openurp.teach.base.Teacher
import org.beangle.data.model.bean.IntIdBean
import org.beangle.data.model.bean.UpdatedBean
import org.openurp.teach.base.Teacher
import org.openurp.teach.base.Adminclass
/**
 * 学生行政班级信息
 *
 * @author chaostone
 * @since 2005-9-12
 */
class AdminclassBean extends EducationBasedObject[Integer] with CodedBean with NamedBean with UpdatedBean with Adminclass {
  /** 简称 */
  var abbreviation: String = _
  /**备注*/
  var remark: String = _
  /** 年级,形式为yyyy-p */
  var grade: String = _
  /** 院系 */
  var department: Department = _
  /** 专业 */
  var major: Major = _
  /** 方向 */
  var direction: Direction = _
  /** 学生类别 */
  var stdType: StdType = _
  /** 计划人数 */
  var planCount: Int = _
  /** 开始日期 */
  var effectiveAt: Date = _
  /** 结束日期 结束日期包括在有效期内 */
  var invalidAt: Date = _
  /** 学籍有效人数 */
  var stdCount: Int = _
  /** 辅导员 */
  var instructors: List[Teacher] = _
  /** 班导师 */
  var tutors: List[Teacher] = _
  /** 学生列表 班级学生 */
  var students: Set[Student] = _

}