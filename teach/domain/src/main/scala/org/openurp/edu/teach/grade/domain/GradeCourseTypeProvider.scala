package org.openurp.edu.teach.grade.domain

import org.openurp.edu.base.Student
import org.openurp.edu.teach.Course
import org.openurp.edu.teach.code.CourseType

/**
 * 判断学生修读课程的课程类别
 *
 * @author chaostone
 */
trait GradeCourseTypeProvider {

  def getCourseType(std: Student, course: Course, defaultCourseType: CourseType): CourseType
}
