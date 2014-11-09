package org.openurp.teach.lesson.model

import org.beangle.data.model.bean.LongIdBean
import org.openurp.base.code.RoomType
import org.openurp.teach.core.WeekState
import org.openurp.teach.lesson.{CourseSchedule, Lesson}
import org.openurp.teach.schedule.CourseActivity

class CourseScheduleBean extends LongIdBean with CourseSchedule {

  /**
   * 所属教学任务
   */
  var lesson: Lesson = _

  /** 起始周 */
  var startWeek: Int = _

  /** 结束周 */
  var endWeek: Int = _

  /** 已安排课时 */
  var period: Int = _
  
  /** 任务课时 */
  var coursePeriod: Int = _
  /**
   * 周状态
   */
  var weekState: WeekState = _

  /** 具体排课结果 */
  var activities: collection.mutable.Set[CourseActivity] = _

  /** 教室类型 */
  var roomType: RoomType = _

  /** 发布状态 **/
  var published: Boolean = _

}