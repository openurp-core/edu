package org.openurp.teach.domain

import org.openurp.base.Department
import org.openurp.teach.Adminclass
import org.openurp.teach.code.StdType
import org.openurp.teach.Major
import org.openurp.teach.Teacher
import org.openurp.teach.EducationBasedObject
import org.beangle.data.model.bean.CodedBean
import org.openurp.teach.Student
import org.beangle.data.model.bean.NamedBean
import org.beangle.data.model.bean.UpdatedBean
import java.util.Date
import org.openurp.teach.Direction
import org.beangle.data.model.bean.TemporalOnBean

/**
 * 学生行政班级信息
 *
 * @author chaostone
 * @since 2005-9-12
 */
class AdminclassBean extends EducationBasedObject[Integer] with CodedBean with NamedBean with UpdatedBean  with TemporalOnBean with Adminclass {
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
//  var effectiveAt: Date = _
  /** 结束日期 结束日期包括在有效期内 */
//  var invalidAt: Date = _
  /** 学籍有效人数 */
  var stdCount: Int = _
  /** 辅导员 */
  var instructors: Seq[Teacher] = _
  /** 班导师 */
  var tutors: Seq[Teacher] = _
  /** 学生列表 班级学生 */
  var students: collection.mutable.Set[Student] = _

}