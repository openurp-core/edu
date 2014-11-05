package org.openurp.teach.action

import org.beangle.commons.inject.bind.AbstractBindModule
import org.openurp.teach.action.code.CourseAbilityRateAction
import org.openurp.teach.action.code.CourseCategoryAction
import org.openurp.teach.action.code.CourseTakeTypeAction
import org.openurp.teach.action.code.CourseTypeAction
import org.openurp.teach.action.code.DegreeAction
import org.openurp.teach.action.code.DisciplineAction
import org.openurp.teach.action.code.DisciplineCatalogAction
import org.openurp.teach.action.code.ExamModeAction
import org.openurp.teach.action.code.ExamStatusAction
import org.openurp.teach.action.code.ExamTypeAction
import org.openurp.teach.action.code.GradeTypeAction
import org.openurp.teach.action.code.ScoreMarkStyleAction
import org.openurp.teach.action.code.StdLabelAction
import org.openurp.teach.action.code.StdLabelTypeAction
import org.openurp.teach.action.code.StdStatusAction
import org.openurp.teach.action.code.StdTypeAction
import org.openurp.teach.action.code.StudyTypeAction
import org.openurp.teach.action.code.TeacherStateAction
import org.openurp.teach.action.code.TeacherTitleAction
import org.openurp.teach.action.code.TeacherTitleLevelAction
import org.openurp.teach.action.code.TeacherTypeAction
import org.openurp.teach.action.code.TeacherUnitTypeAction
import org.openurp.teach.action.code.TutorTypeAction

class DefaultModule extends AbstractBindModule {

  protected override def binding() {
    bind(classOf[TeacherTypeAction],classOf[TeacherStateAction],classOf[TeacherUnitTypeAction],classOf[TutorTypeAction],classOf[StdStatusAction])
    bind(classOf[DisciplineAction],classOf[DisciplineCatalogAction])
    bind(classOf[TeacherTitleAction],classOf[TeacherTitleLevelAction],classOf[StudyTypeAction],classOf[DegreeAction])
    bind(classOf[StdLabelAction],classOf[StdLabelTypeAction],classOf[StdTypeAction])
    bind(classOf[AdminclassAction],classOf[MajorAction],classOf[DirectionAction],classOf[DirectionJournalAction],classOf[MajorJournalAction])
    bind(classOf[ProjectAction],classOf[ProjectCodeAction],classOf[ProjectClassroomAction],classOf[ProjectConfigAction],classOf[ProjectPropertyAction])
    bind(classOf[StdPersonAction],classOf[StudentAction],classOf[StudentJournalAction],classOf[TeacherAction],classOf[TeacherJournalAction])
    bind(classOf[ExamModeAction],classOf[ExamStatusAction],classOf[ExamTypeAction])
    bind(classOf[CourseAbilityRateAction],classOf[CourseCategoryAction],classOf[CourseHourAction],classOf[CourseTakeTypeAction],classOf[CourseTypeAction])
    bind(classOf[GradeTypeAction],classOf[ScoreMarkStyleAction])
    bind(classOf[CourseAction],classOf[CourseGradeAction],classOf[CourseHourAction],classOf[ExamGradeAction])
  }
}