package org.openurp.teach.action

import org.beangle.data.model.Entity
import org.beangle.webmvc.api.view.View
import org.beangle.webmvc.entity.action.RestfulAction
import javax.swing.AbstractAction
import org.beangle.webmvc.entity.action.AbstractEntityAction
import org.openurp.teach.Student
import org.openurp.teach.CourseGrade

class StdGradeReportAction extends AbstractEntityAction {
  def index(): String = {
    val stdCode = "2012134135"
    val stds = entityDao.findBy(classOf[Student], "code", List(stdCode))
    put("stdGradeReports", List(Report(stds.head, List.empty)))
    forward()
  }
}

case class Report(std: Student, grades: Seq[CourseGrade])