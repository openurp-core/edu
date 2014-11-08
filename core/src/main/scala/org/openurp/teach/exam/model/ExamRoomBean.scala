package org.openurp.teach.exam.model

import org.openurp.base.Semester
import org.openurp.teach.exam.ExamTake
import org.openurp.base.Department
import org.openurp.base.Teacher
import org.openurp.teach.exam.ExamActivity
import javax.persistence.ManyToMany
import org.beangle.data.model.bean.LongIdBean
import org.openurp.teach.lesson.Lesson
import org.openurp.teach.exam.ExamMonitor
import org.openurp.teach.exam.ExamRoom
import org.openurp.base.Room
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Buffer

/**
 * 考场
 *
 * @author chaostone
 */
class ExamRoomBean extends LongIdBean with ExamRoom {

  var room: Room = _

  /**
   * 主考教师
   */
  var examiner: Teacher = _

  /**
   * 主考教师院系
   */
  var department: Department = _

  /**
   * 考试活动
   */
  var activities: Buffer[ExamActivity] = new ListBuffer[ExamActivity]

  /**
   * 监考信息
   */
  var monitors: Buffer[ExamMonitor] = new ListBuffer[ExamMonitor]

  var roomApplyId: java.lang.Long = _

  def this(activity: ExamActivity, room: Room) {
    this()
    this.room = room
    this.activities += activity
    activity.rooms.asInstanceOf[Buffer[ExamRoom]] += this
  }

  def lessons: Set[Lesson] = {
    activities.map(a => a.lesson).toSet
  }
}
