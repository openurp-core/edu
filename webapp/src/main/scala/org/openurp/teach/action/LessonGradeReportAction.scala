package org.openurp.teach.action

import org.beangle.data.model.Entity
import org.beangle.webmvc.api.view.View
import org.beangle.webmvc.entity.action.RestfulAction
import javax.swing.AbstractAction
import org.beangle.webmvc.entity.action.AbstractEntityAction
import org.openurp.teach.core.Student
import org.openurp.teach.grade.CourseGrade
import org.beangle.webmvc.api.context.ContextHolder
import org.openurp.teach.lesson.Lesson

class LessonGradeReportAction extends AbstractEntityAction {
  def index(): String = {
    val lessonId = "2007137130"
    val lesson = entityDao.findBy(classOf[Lesson], "id", List(lessonId))
    put("lessonGradeReports", List(LessonReport(lesson.head, List.empty)))
    forward("index_"+ContextHolder.context.locale.getLanguage)
  }
}

case class LessonReport(lesson: Lesson, grades: Seq[CourseGrade])