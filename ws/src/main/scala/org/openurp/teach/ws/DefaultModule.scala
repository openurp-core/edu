package org.openurp.teach.ws

import org.beangle.commons.inject.bind.AbstractBindModule
import org.openurp.teach.ws.code.{CourseCategoryAction, CourseTypeAction, DegreeAction, DisciplineAction, DisciplineCatalogAction, ExamModeAction, ExamStatusAction, ExamTypeAction, StdLabelAction, StdLabelTypeAction, StdStatusAction, StdTypeAction, StudyTypeAction, TeacherStateAction, TeacherTitleAction, TeacherTitleLevelAction, TeacherTypeAction, TeacherUnitTypeAction, TutorTypeAction}


class DefaultModule extends AbstractBindModule {

  protected override def binding() {
    bind(classOf[ExamModeAction], classOf[ExamStatusAction], classOf[ExamTypeAction])
    bind(classOf[CourseTypeAction], classOf[CourseCategoryAction])
    bind(classOf[StdStatusAction], classOf[TeacherStateAction], classOf[TeacherTypeAction], classOf[TeacherUnitTypeAction], classOf[TutorTypeAction])
    bind(classOf[DisciplineCatalogAction], classOf[DisciplineAction])
    bind(classOf[TeacherTitleAction], classOf[TeacherTitleLevelAction],classOf[DegreeAction], classOf[StudyTypeAction])
    bind(classOf[StdLabelAction], classOf[StdLabelTypeAction], classOf[StdTypeAction])
    
    
    bind(classOf[DirectionAction], classOf[DirectionJournalAction])
    bind(classOf[ExamGradeAction])
    bind(classOf[MajorAction], classOf[MajorJournalAction])
    bind(classOf[ProjectAction], classOf[ProjectClassroomAction], classOf[ProjectCodeAction])
    bind(classOf[StudentAction], classOf[StudentJournalAction], classOf[StdPersonAction])
    bind(classOf[TeacherAction], classOf[TeacherJournalAction], classOf[HabilitationAction])
    bind(classOf[CourseAction], classOf[CourseGradeAction], classOf[StdCourseGradeAction],classOf[CourseHourAction])
    bind(classOf[AdminclassAction])

  }

}