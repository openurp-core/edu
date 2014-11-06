package org.openurp.teach.domain

import org.beangle.data.model.bean.LongIdBean
import org.beangle.data.model.bean.NamedBean
import org.openurp.teach.LessonGroup
import org.openurp.base.Department
import org.openurp.teach.Lesson
import org.openurp.base.Semester
import org.openurp.teach.ProjectBasedObject
import org.openurp.teach.ProjectBasedObject
import org.openurp.teach.LessonGroup
import org.openurp.teach.Lesson

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