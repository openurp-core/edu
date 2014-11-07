package org.openurp.teach.exam.model

import org.beangle.data.model.bean.LongIdBean
import org.openurp.base.Department
import org.openurp.teach.exam.{ExamBatch, ExamBatchLesson}
import org.openurp.teach.lesson.Lesson

class ExamBatchLessonBean extends LongIdBean with ExamBatchLesson {

  /** 排考批次 */
  var examBatch: ExamBatch = _

  /** 教学任务 */
  var lesson: Lesson = _

  /** 排考院系 */
  var department: Department = _

  /**试卷考试代码*/
  var examCode: String = _

}