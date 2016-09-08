package org.openurp.edu.grade.course.domain

import org.openurp.base.model.Semester
import org.openurp.edu.grade.course.model.CourseGrade
import org.openurp.edu.base.model.Student
import org.openurp.edu.grade.course.domain.impl.DefaultGpaPolicy

/**
 * @author chaostone
 */
final class GpaCalculator(gpaPolicy: GpaPolicy,courseGradeProvider: CourseGradeProvider) {
  /**
   * 统计学生的在校所有学期的平均绩点
   *
   * <pre>
   *      平均绩点为： gpa=(∑(绩点*学分))/∑(学分)
   *      平均分为： ga=(∑(得分*学分))/∑(学分)
   * </pre>
   */
  def calcGpa(std: Student): java.lang.Float = {
    gpaPolicy.calcGpa(courseGradeProvider.getPublished(std))
  }

  /**
   * 统计学生的平均绩点<br>
   * 平均绩点为： gpa=(∑(绩点*学分))/∑(学分) 平均绩点以截断的方式保留后面两位
   */
  def calcGpa(std: Student, grades: Iterable[CourseGrade]): java.lang.Float = gpaPolicy.calcGpa(grades)

  /**
   * 统计学生的平均绩点<br>
   * 除"学生"之外的其他参数均为可选参数。<br>
   * 平均绩点为： gpa=(∑(绩点*学分))/∑(学分) 平均绩点以截断的方式保留后面两位
   *
   * @param semester    可以为null
   */
  def calcGpa(std: Student, semester: Semester): java.lang.Float = {
    gpaPolicy.calcGpa(courseGradeProvider.getPublished(std, semester))
  }

}
