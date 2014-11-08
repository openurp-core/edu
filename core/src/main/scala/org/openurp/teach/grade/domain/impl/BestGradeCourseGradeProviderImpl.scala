package org.openurp.teach.grade.domain.impl

import org.openurp.base.Semester
import org.openurp.teach.grade.domain.CourseGradeProvider
import org.beangle.data.model.dao.EntityDao
import org.beangle.data.jpa.dao.OqlBuilder
import org.openurp.teach.grade.CourseGrade
import org.openurp.teach.core.Student
import org.openurp.teach.grade.Grade

class BestGradeCourseGradeProviderImpl(entityDao: EntityDao, bestGradeFilter: BestGradeFilter) extends CourseGradeProvider {

  def getPublished(std: Student, semesters: Semester*): Seq[CourseGrade] = {
    val query = OqlBuilder.from(classOf[CourseGrade], "grade")
    query.where("grade.std = :std", std)
    query.where("grade.status =:status", Grade.Status.PUBLISHED)
    if (null != semesters && semesters.length > 0) {
      query.where("grade.semester in(:semesters)", semesters)
    }
    query.orderBy("grade.semester.beginOn")
    bestGradeFilter.filter(entityDao.search(query))
  }

  def getAll(std: Student, semesters: Semester*): Seq[CourseGrade] = {
    val query = OqlBuilder.from(classOf[CourseGrade], "grade")
    query.where("grade.std = :std", std)
    if (null != semesters && semesters.length > 0) {
      query.where("grade.semester in(:semesters)", semesters)
    }
    query.orderBy("grade.semester.beginOn")
    bestGradeFilter.filter(entityDao.search(query))
  }

  def getPublished(stds: Iterable[Student], semesters: Semester*): collection.Map[Student, Seq[CourseGrade]] = {
    val query = OqlBuilder.from(classOf[CourseGrade], "grade")
    query.where("grade.std in (:stds)", stds)
    query.where("grade.status =:status", Grade.Status.PUBLISHED)
    if (null != semesters && semesters.length > 0) {
      query.where("grade.semester in(:semesters)", semesters)
    }
    val allGrades = entityDao.search(query)
    val gradeMap = new collection.mutable.HashMap[Student, collection.mutable.ListBuffer[CourseGrade]]
    for (std <- stds) {
      gradeMap.put(std, new collection.mutable.ListBuffer[CourseGrade])
    }
    for (g <- allGrades) gradeMap(g.std) += g
    val result = new collection.mutable.HashMap[Student, Seq[CourseGrade]]
    for (std <- stds) {
      result.put(std, bestGradeFilter.filter(gradeMap(std)))
    }
    result
  }

  def getAll(stds: Iterable[Student], semesters: Semester*): collection.Map[Student, Seq[CourseGrade]] = {
    val query = OqlBuilder.from(classOf[CourseGrade], "grade")
    query.where("grade.std in (:stds)", stds)
    if (null != semesters && semesters.length > 0) {
      query.where("grade.semester in(:semesters)", semesters)
    }
    val allGrades = entityDao.search(query)
    val gradeMap = new collection.mutable.HashMap[Student, collection.mutable.ListBuffer[CourseGrade]]
    for (std <- stds) {
      gradeMap.put(std, new collection.mutable.ListBuffer[CourseGrade])
    }
    for (g <- allGrades) gradeMap(g.std) += g
    val result = new collection.mutable.HashMap[Student, Seq[CourseGrade]]
    for (std <- stds) {
      result.put(std, bestGradeFilter.filter(gradeMap(std)))
    }
    result
  }

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
