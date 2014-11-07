package org.openurp.teach.core.model

import java.sql.Date

import collection.mutable.Buffer

import org.beangle.data.model.bean.{ CodedBean, IntIdBean, NamedBean, TemporalOnBean }
import org.openurp.base.Department
import org.openurp.base.code.{ DisciplineCategory, Education }
import org.openurp.teach.core.{ Direction, Major, MajorJournal, Project }

/**
 * 专业
 *
 * @author hs
 */
class MajorBean extends IntIdBean with CodedBean with NamedBean with TemporalOnBean with Major {

  /** 专业英文名 */
  var enName: String = _
  /** 备注 */
  var remark: String = _
  /** 项目 */
  var project: Project = _
  /** 获得方向 */
  var directions: collection.mutable.Set[Direction] = new collection.mutable.HashSet[Direction]
  /** 学科门类 */
  var category: DisciplineCategory = _
  /** 培养层次 */
  var educations: collection.mutable.Set[Education] = new collection.mutable.HashSet[Education]
  /** 修读年限 */
  var duration: Float = _
  /** 部门 */
  var journals: Buffer[MajorJournal] = new collection.mutable.ListBuffer[MajorJournal]

  /** 简称 */
  var abbreviation: String = _

  def allDepartments: Set[Department] = {
    journals.map(j => j.depart).toSet
  }

  def departments: Set[Department] = {
    departments(new Date(System.currentTimeMillis))
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
class MajorJournalBean extends IntIdBean with TemporalOnBean with MajorJournal {
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
  /**备注*/
  var remark: String = _

}