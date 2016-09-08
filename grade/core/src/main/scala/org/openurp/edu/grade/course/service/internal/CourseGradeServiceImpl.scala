package org.openurp.edu.grade.course.service.internal

import org.beangle.data.dao.{ EntityDao, OqlBuilder }
import org.openurp.base.model.Semester
import org.openurp.edu.base.model.Student
import org.openurp.edu.grade.course.domain.{ CourseGradeProvider, GpaStatService }
import org.openurp.edu.grade.course.model.{ CourseGrade, StdGpa }
import org.openurp.edu.grade.course.service.CourseGradeService

class CourseGradeServiceImpl extends CourseGradeService {

  var entityDao:EntityDao =_
  
  var courseGradeProvider: CourseGradeProvider = _

  var gpaStatService: GpaStatService = _

  def getGrades(std: Student, semesters: Semester*): Seq[CourseGrade] = {
    courseGradeProvider.getPublished(std, semesters: _*)
  }
  /**
   * 查询一批学生发布的成绩
   */
  def getGrades(stds: Iterable[Student], semesters: Semester*): collection.Map[Student, Seq[CourseGrade]] = {
    courseGradeProvider.getPublished(stds, semesters: _*)
  }

  /**
   * 如果semesters不包含元素或者为null则统计所有学期 否则统计学生的在校semesters所包含的学期的平均绩点
   *
   * @param std
   * @return
   */
  def getGpa(std: Student, semesters: Semester*): StdGpa = {
    gpaStatService.statGpa(std, semesters: _*)
  }

  /**
   * 查看学生各个课程的通过状态
   */
  def getPassedStatus(std: Student): collection.Map[java.lang.Long, Boolean] = {
    val query = OqlBuilder.from(classOf[CourseGrade], "cg")
    query.where("cg.std = :std", std)
    query.select("cg.course.id,cg.passed")
    val rs = entityDao.search(query).asInstanceOf[List[Array[Any]]]
    val courseMap = new collection.mutable.HashMap[java.lang.Long, Boolean]
    for (obj <- rs) {
      val courseId = obj(0).asInstanceOf[java.lang.Long]
      if (null != obj(1)) {
        courseMap.get(courseId) match {
          case Some(passed) => if (!passed) courseMap.put(courseId, obj(1).asInstanceOf[java.lang.Boolean])
          case None => courseMap.put(courseId, obj(1).asInstanceOf[java.lang.Boolean])
        }
      } else {
        courseMap.put(courseId, false)
      }
    }
    courseMap
  }
}