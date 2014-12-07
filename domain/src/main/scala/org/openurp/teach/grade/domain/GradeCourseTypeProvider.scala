package org.openurp.teach.grade.domain

import org.openurp.teach.code.CourseType
import org.openurp.teach.core.Student
import org.openurp.teach.core.Course

/**
 * 判断学生修读课程的课程类别
 *
 * @author chaostone
 */
trait GradeCourseTypeProvider {

  def getCourseType(std: Student, course: Course, defaultCourseType: CourseType): CourseType
}
