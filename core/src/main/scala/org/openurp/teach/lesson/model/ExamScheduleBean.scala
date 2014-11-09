package org.openurp.teach.lesson.model

import org.beangle.data.model.bean.LongIdBean
import org.openurp.teach.code.ExamType
import org.openurp.teach.exam.ExamActivity
import org.openurp.teach.lesson.ExamSchedule
import org.openurp.teach.code.ExamForm
import org.openurp.teach.code.ExamMode

class ExamScheduleBean extends LongIdBean with ExamSchedule {

  /** 具体排考结果 */
  var activities: collection.mutable.Set[ExamActivity] = _

  /** 考试形式 开/闭卷 */
  var examForm: ExamForm = _

  /** 考试方式 */
  var examMode: ExamMode = _

}