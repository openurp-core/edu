package org.openurp.teach.grade.service

import org.openurp.base.Semester
import org.openurp.teach.core.Student
import org.openurp.teach.grade.CourseGrade
import org.openurp.teach.grade.domain.StdGpa

/**
 * 平均绩点统计服务
 *
 * @author chaostone
 *
 */
trait GpaStatService {

  /**
   * 如果semesters不包含元素或者为null则统计所有学期 否则统计学生的在校semesters所包含的学期的平均绩点
   *
   * <pre>
   *      平均绩点为： gpa=(∑(绩点*学分))/∑(学分)
   *      平均分为： ga=(∑(得分*学分))/∑(学分)
   * </pre>
   *
   * @param std
   * @return
   */
  def statGpa(std: Student, semesters: Semester*): StdGpa

  /**
   * 给定成绩统计平均绩点
   *
   * @param std
   * @param grades
   * @return
   */
  def statGpa(std: Student, grades: Iterable[CourseGrade]): StdGpa

  /**
   * 统计多个学生的平均绩点和其他信息 如果semesters不包含元素或者为null则统计这些所有学期
   * 否则统计这些学生的semesters所包含的学期的平均绩点
   *
   * @param stds
   * @param education
   * @return
   */
  def statGpas(stds: Iterable[Student], semesters: Semester*): MultiStdGpa
}

/**
 * 多个学生的绩点汇总
 *
 * @author chaostone
 *
 */
class MultiStdGpa(val unit: Any, val stdGpas: Iterable[StdGpa]) {

  val semesters: List[Semester] = statSemesters(stdGpas)

  def statSemesters(stdGpas: Iterable[StdGpa]): List[Semester] = {
    val semesters = new collection.mutable.HashSet[Semester]
    for (stdGp <- stdGpas; stdSemesterGpa <- stdGp.semesterGpas) {
      semesters += stdSemesterGpa.semester
    }
    semesters.toList
  }
}
