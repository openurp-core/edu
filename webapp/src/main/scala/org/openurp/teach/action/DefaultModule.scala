package org.openurp.teach.action

import org.beangle.commons.inject.bind.AbstractBindModule
import org.openurp.teach.action.code.{ CourseAbilityRateAction, CourseCategoryAction, CourseTakeTypeAction, CourseTypeAction, DegreeAction, DisciplineAction, DisciplineCatalogAction, ExamModeAction, ExamStatusAction, ExamTypeAction, GradeTypeAction, ScoreMarkStyleAction, StdLabelAction, StdLabelTypeAction, StdStatusAction, StdTypeAction, StudyTypeAction, TeacherStateAction, TeacherTitleAction, TeacherTitleLevelAction, TeacherTypeAction, TeacherUnitTypeAction, TutorTypeAction }

class DefaultModule extends AbstractBindModule {

  protected override def binding() {
    bind(classOf[TeacherTypeAction], classOf[TeacherStateAction], classOf[TeacherUnitTypeAction], classOf[TutorTypeAction], classOf[StdStatusAction])
    bind(classOf[DisciplineAction], classOf[DisciplineCatalogAction])
    bind(classOf[TeacherTitleAction], classOf[TeacherTitleLevelAction], classOf[StudyTypeAction], classOf[DegreeAction])
    bind(classOf[StdLabelAction], classOf[StdLabelTypeAction], classOf[StdTypeAction])
    bind(classOf[AdminclassAction], classOf[MajorAction], classOf[DirectionAction], classOf[DirectionJournalAction], classOf[MajorJournalAction])
    bind(classOf[ProjectAction], classOf[ProjectCodeAction], classOf[ProjectClassroomAction])
    bind(classOf[StudentAction], classOf[StudentJournalAction])
    bind(classOf[ExamModeAction], classOf[ExamStatusAction], classOf[ExamTypeAction])
    bind(classOf[CourseAbilityRateAction], classOf[CourseCategoryAction], classOf[CourseHourAction], classOf[CourseTakeTypeAction], classOf[CourseTypeAction])
    bind(classOf[GradeTypeAction], classOf[ScoreMarkStyleAction])
    bind(classOf[CourseAction], classOf[CourseGradeAction], classOf[CourseHourAction], classOf[ExamGradeAction])
    bind(classOf[StdGradeReportAction])
  }
}