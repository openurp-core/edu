package org.openurp.edu.teach.ds

import org.beangle.commons.inject.bind.AbstractBindModule
import org.openurp.edu.teach.ds.grade.{ CourseGradeWS, ExamGradeWS }
import org.openurp.edu.teach.ds.code.ExamTypeWS

class DefaultModule extends AbstractBindModule {

  protected override def binding() {
    bind(classOf[ExamGradeWS], classOf[CourseGradeWS])

    bind(classOf[ExamTypeWS])
  }

}