package org.openurp.teach.exam.model

import java.util.Date

import org.openurp.teach.exam.{ExamBatch, ExamBatchTime}

class ExamBatchTimeBean extends ExamBatchTime {

  /** 排考批次 */
  var examBatch: ExamBatch = _

  /** 安排时间开始 */
  var timeBeginAt: Date = _

  /** 安排时间结束 */
  var timeEndAt: Date = _

  /** 安排地点开始 */
  var roomBeginAt: Date = _

  /** 安排地点结束 */
  var roomEndAt: Date = _

  /** 安排监考开始 */
  var monitorBeginAt: Date = _

  /** 安排监考结束 */
  var monitorEndAt: Date = _
}