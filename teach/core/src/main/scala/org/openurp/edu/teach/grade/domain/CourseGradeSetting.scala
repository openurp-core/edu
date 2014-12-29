package org.openurp.edu.teach.grade.domain

import collection.mutable

import org.openurp.edu.base.{ Project, ProjectBasedObject }
import org.openurp.edu.teach.code.{ ExamStatus, ExamType, GradeType, ScoreMarkStyle }
import org.openurp.edu.teach.code.model.{ ExamStatusBean, GradeTypeBean }
/**
 * 课程成绩配置
 *
 * @author chaostone
 */
class CourseGradeSetting extends ProjectBasedObject[Integer] {

  var precision: Short = 0
  /**
   * 总评成绩的组成部分
   */
  var endGaElements: collection.Set[GradeType] = new mutable.HashSet[GradeType]

  /**
   * 总评成绩的组成部分
   */
  var delayGaElements: collection.Set[GradeType] = new mutable.HashSet[GradeType]
  /**
   * 总评成绩的组成部分
   */
  var makeupGaElements: collection.Set[GradeType] = new mutable.HashSet[GradeType]

  /**
   * 允许补考考试类型
   */
  var allowExamStatuses: collection.Set[ExamStatus] = new mutable.HashSet[ExamStatus]

  /**
   * 不允许录入成绩的考试类型列表
   */
  var emptyScoreStatuses: collection.Set[ExamStatus] = new mutable.HashSet[ExamStatus]

  /**
   * 是否提交即发布
   */
  var submitIsPublish: Boolean = false

  def this(project: Project) {
    this()
    endGaElements += new GradeTypeBean(GradeType.Usual, "0003", "平时成绩", "Component Score")
    //    endGaElements += new GradeTypeBean(GradeType.Middle, "0001", "期中成绩", "Middle Score")
    endGaElements += new GradeTypeBean(GradeType.End, "0002", "期末成绩", "Final Exam Score")

    delayGaElements += new GradeTypeBean(GradeType.Usual)
    delayGaElements += new GradeTypeBean(GradeType.Middle)
    delayGaElements += new GradeTypeBean(GradeType.Delay)

    makeupGaElements += new GradeTypeBean(GradeType.Makeup)

    allowExamStatuses += new ExamStatusBean(ExamStatus.Normal)
    allowExamStatuses += new ExamStatusBean(ExamStatus.Misc)
    emptyScoreStatuses += new ExamStatusBean(ExamStatus.Absent)
    emptyScoreStatuses += new ExamStatusBean(ExamStatus.Cheat)
    emptyScoreStatuses += new ExamStatusBean(ExamStatus.Violation)
    emptyScoreStatuses += new ExamStatusBean(ExamStatus.Delay)
    emptyScoreStatuses += new ExamStatusBean(ExamStatus.Misc)
    emptyScoreStatuses += new ExamStatusBean(ExamStatus.Unqualify)
  }

  def getRemovableElements(gradeType: GradeType): collection.Set[GradeType] = {
    gradeType.id match {
      case GradeType.EndGa => endGaElements
      case GradeType.DelayGa => Set(new GradeTypeBean(GradeType.Delay))
      case GradeType.MakeupGa => makeupGaElements
      case _ => Set.empty
    }
  }
}

class GradeTypeConfig {

  var publishable: Boolean = _

  var finalCandinate: Boolean = _

  var gaElement: Boolean = _

  var examType: ExamType = _

  var markStyles = new collection.mutable.ListBuffer[ScoreMarkStyle]

  var precision: Int = _
}
