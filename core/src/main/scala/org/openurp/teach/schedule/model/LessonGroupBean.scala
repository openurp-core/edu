package org.openurp.teach.schedule.model

import org.beangle.data.model.bean.NamedBean
import org.openurp.base.{ Department, Semester }
import org.openurp.teach.core.ProjectBasedObject
import org.openurp.teach.schedule.LessonGroup
import org.openurp.teach.lesson.Lesson

class LessonGroupBean extends ProjectBasedObject[java.lang.Long] with LessonGroup with NamedBean {

  /** 任务集合 */
  var lessons: collection.mutable.Set[Lesson] = _

  /** 教学任务数目 */
  var lessonSize: Int = _

  /**开课部门*/
  var teachDepart: Department = _

  /** 学期 */
  var semester: Semester = _
}