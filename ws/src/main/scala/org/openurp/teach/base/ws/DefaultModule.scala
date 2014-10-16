package org.openurp.teach.base.ws

import org.beangle.commons.inject.bind.AbstractBindModule
import org.openurp.teach.base.ws.code.{CourseCategoryAction, CourseTypeAction, DegreeAction, DisciplineAction, DisciplineCatalogAction, ExamModeAction, ExamStatusAction, ExamTypeAction, StdLabelAction, StdLabelTypeAction, StdStatusAction, StdTypeAction, StudyTypeAction, TeacherStateAction, TeacherTitleAction, TeacherTitleLevelAction, TeacherTypeAction, TeacherUnitTypeAction, TutorTypeAction}

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