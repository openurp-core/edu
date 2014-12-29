package org.openurp.edu.teach.grade.domain

import org.beangle.data.model.dao.Operation
import org.openurp.edu.teach.grade.model.CourseGradeState
import org.openurp.edu.teach.code.GradeType
import org.openurp.edu.teach.grade.CourseGrade

/**
 * 成绩发布监听器堆栈
 *
 * @author chaostone
 */
class CourseGradePublishStack(listeners: List[CourseGradePublishListener]) {

  def onPublish(grade: CourseGrade, gradeTypes: Array[GradeType]): Seq[Operation] = {
    val results = new collection.mutable.ListBuffer[Operation]
    for (listener <- listeners) {
      results ++= listener.onPublish(grade, gradeTypes)
    }
    results
  }

  def onPublish(grades: Iterable[CourseGrade], gradeState: CourseGradeState, gradeTypes: Array[GradeType]): Seq[Operation] = {
    val results = new collection.mutable.ListBuffer[Operation]
    for (listener <- listeners) {
      results ++= listener.onPublish(grades, gradeState, gradeTypes)
    }
    results
  }
}
