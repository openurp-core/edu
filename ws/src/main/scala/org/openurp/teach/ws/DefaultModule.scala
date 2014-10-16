package org.openurp.teach.ws

import org.openurp.teach.ws.code.DisciplineCatalogAction
import org.openurp.teach.ws.code.CourseCategoryAction
import org.openurp.teach.ws.code.TutorTypeAction
import org.openurp.teach.ws.code.StdStatusAction
import org.openurp.teach.ws.code.StdLabelTypeAction
import org.openurp.teach.ws.code.DisciplineAction
import org.beangle.commons.inject.bind.AbstractBindModule
import org.openurp.teach.ws.code.TeacherTitleAction
import org.openurp.teach.ws.code.TeacherTitleLevelAction
import org.openurp.teach.ws.code.StudyTypeAction
import org.openurp.teach.ws.code.DegreeAction
import org.openurp.teach.ws.code.ExamTypeAction
import org.openurp.teach.ws.code.TeacherUnitTypeAction
import org.openurp.teach.ws.code.StdTypeAction
import org.openurp.teach.ws.code.ExamStatusAction
import org.openurp.teach.ws.code.StdLabelAction
import org.openurp.teach.ws.code.ExamModeAction
import org.openurp.teach.ws.code.CourseTypeAction
import org.openurp.teach.ws.code.TeacherTypeAction
import org.openurp.teach.ws.code.TeacherStateAction


class DefaultModule extends AbstractBindModule {

  protected override def binding() {
    bind(classOf[ExamModeAction], classOf[ExamStatusAction], classOf[ExamTypeAction])
    bind(classOf[CourseTypeAction], classOf[CourseCategoryAction])
    bind(classOf[StdStatusAction], classOf[TeacherStateAction], classOf[TeacherTypeAction], classOf[TeacherUnitTypeAction], classOf[TutorTypeAction])
    bind(classOf[DisciplineCatalogAction], classOf[DisciplineAction])
    bind(classOf[TeacherTitleAction], classOf[TeacherTitleLevelAction],classOf[DegreeAction], classOf[StudyTypeAction])
    bind(classOf[StdLabelAction], classOf[StdLabelTypeAction], classOf[StdTypeAction])

  }

}