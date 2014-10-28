package org.openurp.teach.domain

import java.util.Date

import scala.collection.mutable.Buffer

import org.beangle.data.model.bean.CodedBean
import org.beangle.data.model.bean.IntIdBean
import org.beangle.data.model.bean.NamedBean
import org.beangle.data.model.bean.TemporalOnBean
import org.openurp.base.Department
import org.openurp.base.code.DisciplineCategory
import org.openurp.base.code.Education
import org.openurp.teach.Direction
import org.openurp.teach.Major
import org.openurp.teach.MajorJournal
import org.openurp.teach.Project

/**
 * 专业
 *
 * @author hs
 */
class MajorBean extends IntIdBean with CodedBean with NamedBean  with TemporalOnBean with Major {

  /** 专业英文名 */
  var engName: String = _
  /** 备注 */
  var remark: String = _
  /** 生效时间 */
//  var beginOn: Date = _
  /** 失效时间 */
//  var endOn: Date = _
  /** 项目 */
  var project: Project = _
  /** 获得方向 */
  var directions: collection.mutable.Set[Direction] = new collection.mutable.HashSet[Direction]
  /** 学科门类 */
  var category: DisciplineCategory = _
  /** 培养层次 */
  var educations:collection.mutable.Set[Education]=new collection.mutable.HashSet[Education]
//  Set[Education] = _
  /** 修读年限 */
  var duration: Float = _
  /** 部门 */
  var journals:Buffer[MajorJournal]=new collection.mutable.ListBuffer[MajorJournal]
//  List[MajorJournal] = _
  
  /** 简称 */
  var abbreviation: String = _

  def allDepartments: Set[Department] = {
    journals.map(j => j.depart).toSet
  }

  def departments: Set[Department] = {
    departments(new Date)
  }

  def departments(date: Date): Set[Department] = {
    journals.filter(j => date.after(j.beginOn) && (null == j.endOn || date.before(j.endOn)))
      .map(j => j.depart).toSet
  }
}

/**
 * 专业建设过程
 * @author chaostone
 *
 */
class MajorJournalBean extends IntIdBean with TemporalOnBean  with MajorJournal {
  /** 英文名 */
//  var engName: String = _
  /**专业*/
  var major: Major = _
  /** 教育部代码 */
  var disciplineCode: String = _
  /** 学科门类 */
  var category: DisciplineCategory = _
  /** 修读年限 */
  var duration: Float = _
  /**培养层次*/
  var education: Education = _
  /**部门*/
  var depart: Department = _
  /** 生效时间 */
//  var effectiveAt: Date = _
  /** 失效时间 */
//  var invalidAt: Date = _
  /**备注*/
  var remark: String = _

}