package org.openurp.edu.grade.course.domain.impl

import org.openurp.base.model.Semester
import org.openurp.edu.grade.course.domain.CourseGradeProvider
import org.beangle.data.dao.EntityDao
import org.beangle.data.dao.OqlBuilder
import org.openurp.edu.grade.course.model.CourseGrade
import org.openurp.edu.base.model.Student
import org.openurp.edu.grade.model.Grade

class BestGradeCourseGradeProvider(entityDao: EntityDao, bestGradeFilter: BestGradeFilter) extends CourseGradeProvider {

  def getPublished(std: Student, semesters: Semester*): Seq[CourseGrade] = {
    val query = OqlBuilder.from(classOf[CourseGrade], "grade")
    query.where("grade.std = :std", std)
    query.where("grade.status =:status", Grade.Status.Published)
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
    query.where("grade.status =:status", Grade.Status.Published)
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


}
