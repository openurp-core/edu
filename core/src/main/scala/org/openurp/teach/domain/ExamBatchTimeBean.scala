package org.openurp.teach.domain

import org.openurp.teach.ExamBatchTime
import org.openurp.teach.ExamBatch
import java.util.Date
import org.openurp.teach.ExamBatchTime
import org.openurp.teach.ExamBatch

class ExamBatchTimeBean extends ExamBatchTime {

  /** 排考批次 */
  def examBatch: ExamBatch = _

  /** 安排时间开始 */
  def timeBeginAt: Date = _

  /** 安排时间结束 */
  def timeEndAt: Date = _

  /** 安排地点开始 */
  def roomBeginAt: Date = _

  /** 安排地点结束 */
  def roomEndAt: Date = _

  /** 安排监考开始 */
  def monitorBeginAt: Date = _

  /** 安排监考结束 */
  def monitorEndAt: Date = _
}