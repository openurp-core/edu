package org.openurp.teach.domain

import org.beangle.data.model.bean.LongIdBean
import org.openurp.base.Room
import org.openurp.teach.Teacher
import org.openurp.teach.CourseActivity
import org.openurp.teach.CourseTime
import org.openurp.teach.Lesson
import org.beangle.data.model.TemporalAt
import org.beangle.data.model.bean.TemporalAtBean

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