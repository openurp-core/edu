package org.openurp.edu.teach.ds

import org.beangle.commons.inject.bind.AbstractBindModule
import org.beangle.webmvc.config.action.JekyllMvcAction
import org.openurp.edu.teach.ds.code.{CourseCategoryWS, CourseTypeWS, ExamModeWS, ExamStatusWS, ExamTypeWS}
import org.openurp.edu.teach.ds.grade.{CourseGradeWS, CourseHourWS, CourseWS, ExamGradeWS}

class DefaultModule extends AbstractBindModule {

  protected override def binding() {
    bind(classOf[ExamGradeWS])
    bind(classOf[CourseWS], classOf[CourseGradeWS], classOf[CourseHourWS])

    bind(classOf[JekyllMvcAction])
    bind(classOf[CourseTypeWS], classOf[CourseCategoryWS], classOf[ExamModeWS],
      classOf[ExamStatusWS],
      classOf[ExamTypeWS])
  }

}