package org.openurp.teach.domain

import org.openurp.teach.ProjectBasedObject
import org.beangle.data.model.bean.NamedBean
import org.beangle.data.model.bean.IntIdBean
import org.openurp.base.Semester
import org.openurp.teach.ExamBatch
import org.openurp.teach.ExamActivity
import org.openurp.teach.ProjectBasedObject
import org.openurp.teach.code.ExamType

class ExamBatchBean extends ExamBatch with ProjectBasedObject[Integer] with NamedBean{

  /** 排考批次学期 */
  def semester: Semester = _

  /** 批次时间开关 */
  def batchTime: ExamBatchTime = _

  /** 默认考试类型 */
  def defaultExamType: ExamType = _

  /** 批次任务范围 */
  def lessons: collection.mutable.Set[ExamBatchLesson] = _

  /** 批次考试名单 */
  def examTakes: collection.mutable.Set[ExamTake] = _

  def activities: collection.mutable.Set[ExamActivity] = _

  /** 是否归档 */
  def archived: Boolean = _

}