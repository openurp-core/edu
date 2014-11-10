package org.openurp.teach.core.model

import org.openurp.base.Department
import org.beangle.data.model.bean.CodedBean
import org.beangle.data.model.bean.NamedBean
import org.beangle.data.model.bean.UpdatedBean
import org.beangle.data.model.bean.TemporalOnBean
import org.openurp.teach.core.Adminclass
import org.openurp.teach.code.StdType
import org.openurp.teach.core.Major
import org.openurp.base.Teacher
import org.openurp.teach.core.EducationBasedObject
import org.openurp.teach.core.Student
import org.openurp.teach.core.Direction

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
  /** 学籍有效人数 */
  var stdCount: Int = _
  /** 辅导员 */
  var instructors: collection.mutable.Seq[Teacher] = new collection.mutable.ListBuffer[Teacher]
  /** 班导师 */
  var tutors: collection.mutable.Seq[Teacher] = new collection.mutable.ListBuffer[Teacher]
  /** 学生列表 班级学生 */
  var students: collection.mutable.Set[Student] = _

}