package org.openurp.edu.teach.grade.domain

import org.openurp.base.Semester
import org.openurp.edu.base.Student
import org.openurp.edu.teach.grade.CourseGrade

/**
 * 学生成绩查询<br>
 *
 * @author chaostone
 */
trait CourseGradeProvider {

  /**
   * 查询学生发布的成绩
   */
  def getPublished(std: Student, semesters: Semester*): Seq[CourseGrade]

  /**
   * 查询学生所有成绩
   */
  def getAll(std: Student, semesters: Semester*): Seq[CourseGrade]

  /**
   * 查询一批学生发布的成绩
   */
  def getPublished(stds: Iterable[Student], semesters: Semester*): collection.Map[Student, Seq[CourseGrade]]

  /**
   * 查询一批学生所有成绩
   */
  def getAll(stds: Iterable[Student], semesters: Semester*): collection.Map[Student, Seq[CourseGrade]]

  /**
   * 查看学生各个课程的通过状态
   */
  def getPassedStatus(std: Student): collection.Map[java.lang.Long, Boolean]
}
