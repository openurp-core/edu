package org.openurp.teach.schedule.model

import org.beangle.data.model.bean.{LongIdBean, TemporalAtBean}
import org.openurp.base.Room
import org.openurp.base.Teacher
import org.openurp.teach.lesson.Lesson
import org.openurp.teach.schedule.{CourseActivity, CourseTime}

class CourseActivityBean extends LongIdBean with CourseActivity with TemporalAtBean{

  /** 教学任务 */
  var lesson: Lesson = _

  /** 上课时间 */
  var time: CourseTime = _

  /** 授课教师列表 */
  var teachers: collection.mutable.Set[Teacher] = _

  /** 教室列表 */
  var rooms: collection.mutable.Set[Room] = _

  /** 排课备注 */
  var remark: String = _

  override def compare(other: CourseActivity): Int = {
    //fix me
    -1
  }

}