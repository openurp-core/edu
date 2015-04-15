package org.openurp.teach.action

import org.beangle.commons.inject.bind.AbstractBindModule
import org.openurp.teach.action.code.{ CourseAbilityRateAction, CourseCategoryAction, CourseTakeTypeAction, CourseTypeAction, DegreeAction, DisciplineAction, DisciplineCatalogAction, ExamModeAction, ExamStatusAction, ExamTypeAction, GradeTypeAction, ScoreMarkStyleAction, StdLabelAction, StdLabelTypeAction, StdStatusAction, StdTypeAction, StudyTypeAction, TeacherStateAction, TeacherTitleAction, TeacherTitleLevelAction, TeacherTypeAction, TeacherUnitTypeAction, TutorTypeAction }

class DefaultModule extends AbstractBindModule {

  protected override def binding() {
    bind(classOf[TeacherTypeAction], classOf[TeacherStateAction], classOf[TeacherUnitTypeAction], classOf[TutorTypeAction], classOf[StdStatusAction])
    bind(classOf[DisciplineAction], classOf[DisciplineCatalogAction])
    bind(classOf[TeacherTitleAction], classOf[TeacherTitleLevelAction], classOf[StudyTypeAction], classOf[DegreeAction])
    bind(classOf[StdLabelAction], classOf[StdLabelTypeAction], classOf[StdTypeAction])
    bind(classOf[ExamModeAction], classOf[ExamStatusAction], classOf[ExamTypeAction])
    bind(classOf[CourseAbilityRateAction], classOf[CourseCategoryAction], classOf[CourseHourAction], classOf[CourseTakeTypeAction], classOf[CourseTypeAction])
    bind(classOf[GradeTypeAction], classOf[ScoreMarkStyleAction])
    bind(classOf[classOf[CourseGradeAction], classOf[ExamGradeAction])
    bind(classOf[StdGradeReportAction])
    bind(classOf[LessonGradeReportAction])
  }
}
