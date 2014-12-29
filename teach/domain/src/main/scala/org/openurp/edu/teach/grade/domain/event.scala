package org.openurp.edu.teach.grade.domain

import org.beangle.commons.event.BusinessEvent
import org.openurp.edu.teach.grade.CourseGrade
import org.openurp.edu.teach.lesson.Lesson
/**
 * 已发布成绩变化事件(由于已发布成绩发生变化如修改申请或加分等引起的成绩改变的事件)
 */
class CourseGradeModifyEvent(source: Seq[CourseGrade]) extends BusinessEvent(source)
/**
 * 成绩提交事件
 */
class CourseGradeSubmitEvent(source: Lesson) extends BusinessEvent(source)
