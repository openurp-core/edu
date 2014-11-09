package org.openurp.teach.ws

import org.beangle.commons.inject.bind.AbstractBindModule
import org.openurp.teach.ws.code.{ CourseCategoryAction, CourseTypeAction, DisciplineAction, DisciplineCatalogAction, ExamModeAction, ExamStatusAction, ExamTypeAction, StdLabelAction, StdLabelTypeAction, StdStatusAction, StdTypeAction, StudyTypeAction }
import org.openurp.teach.ws.core.{ AdminclassAction, DirectionAction, DirectionJournalAction, HabilitationAction, MajorAction, MajorJournalAction, ProjectAction, ProjectClassroomAction, ProjectCodeAction, StudentAction, StudentJournalAction }
import org.openurp.teach.ws.grade.{ CourseAction, CourseGradeAction, CourseHourAction, ExamGradeAction, StdCourseGradeAction }

class DefaultModule extends AbstractBindModule {

  protected override def binding() {
    bind(classOf[ExamModeAction], classOf[ExamStatusAction], classOf[ExamTypeAction])
    bind(classOf[CourseTypeAction], classOf[CourseCategoryAction])
    bind(classOf[StdStatusAction])
    bind(classOf[DisciplineCatalogAction], classOf[DisciplineAction])
    bind(classOf[StudyTypeAction])
    bind(classOf[StdLabelAction], classOf[StdLabelTypeAction], classOf[StdTypeAction])

    bind(classOf[DirectionAction], classOf[DirectionJournalAction])
    bind(classOf[ExamGradeAction])
    bind(classOf[MajorAction], classOf[MajorJournalAction])
    bind(classOf[ProjectAction], classOf[ProjectClassroomAction], classOf[ProjectCodeAction])
    bind(classOf[StudentAction], classOf[StudentJournalAction])
    bind(classOf[HabilitationAction])
    bind(classOf[CourseAction], classOf[CourseGradeAction], classOf[StdCourseGradeAction], classOf[CourseHourAction])
    bind(classOf[AdminclassAction])

  }

}