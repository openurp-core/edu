package org.openurp.teach.grade.service

import org.openurp.base.Semester
import org.openurp.teach.core.Student
import org.openurp.teach.grade.CourseGrade

/**
 * 平均绩点计算服务
 *
 * @author chaostone
 */
trait GpaService {

  /**
   * 统计学生的在校所有学期的平均绩点
   *
   * <pre>
   *      平均绩点为： gpa=(∑(绩点*学分))/∑(学分)
   *      平均分为： ga=(∑(得分*学分))/∑(学分)
   * </pre>
   */
  def getGpa(std: Student): java.lang.Float

  /**
   * 统计学生的平均绩点<br>
   * 平均绩点为： gpa=(∑(绩点*学分))/∑(学分) 平均绩点以截断的方式保留后面两位
   */
  def getGpa(std: Student, grades: Iterable[CourseGrade]): java.lang.Float

  /**
   * 统计学生的平均绩点<br>
   * 除"学生"之外的其他参数均为可选参数。<br>
   * 平均绩点为： gpa=(∑(绩点*学分))/∑(学分) 平均绩点以截断的方式保留后面两位
   *
   * @param semester    可以为null
   */
  def getGpa(std: Student, semester: Semester): java.lang.Float
}
