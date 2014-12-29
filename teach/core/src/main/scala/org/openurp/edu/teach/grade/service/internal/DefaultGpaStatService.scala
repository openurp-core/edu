package org.openurp.edu.teach.grade.service.internal

import java.util.Date

import org.openurp.base.Semester
import org.openurp.edu.base.Student
import org.openurp.edu.teach.Course
import org.openurp.edu.teach.grade.CourseGrade
import org.openurp.edu.teach.grade.domain.{CourseGradeProvider, GpaPolicy, StdGpa, StdSemesterGpa, StdYearGpa}
import org.openurp.edu.teach.grade.service.{GpaStatService, MultiStdGpa}

class DefaultGpaStatService extends GpaStatService {

  var courseGradeProvider: CourseGradeProvider = _

  var gpaPolicy: GpaPolicy = _

  def statGpa(std: Student, grades: Iterable[CourseGrade]): StdGpa = {
    val gradesMap = new collection.mutable.HashMap[Semester, collection.mutable.ListBuffer[CourseGrade]]
    val courseMap = new collection.mutable.HashMap[Course, CourseGrade]
    for (grade <- grades) {
      val semesterGrades = gradesMap.getOrElseUpdate(grade.semester, new collection.mutable.ListBuffer[CourseGrade])
      courseMap.get(grade.course) match {
        case Some(exist) => if (!exist.passed) courseMap.put(grade.course, grade)
        case None => courseMap.put(grade.course, grade)
      }
      semesterGrades += grade
    }
    val stdGpa = new StdGpa(std)
    val yearGradeMap = new collection.mutable.HashMap[String, collection.mutable.ListBuffer[CourseGrade]]
    for (semester <- gradesMap.keySet) {
      val stdTermGpa = new StdSemesterGpa()
      stdTermGpa.semester = semester
      stdGpa.add(stdTermGpa)
      val semesterGrades = gradesMap(semester)
      val yearGrades = yearGradeMap.getOrElseUpdate(semester.schoolYear, new collection.mutable.ListBuffer[CourseGrade])
      yearGrades ++= semesterGrades
      stdTermGpa.gpa = gpaPolicy.calcGpa(semesterGrades)
      stdTermGpa.ga = gpaPolicy.calcGa(semesterGrades)
      stdTermGpa.count = semesterGrades.size
      val stats = statCredits(semesterGrades)
      stdTermGpa.totalCredits = stats(0)
      stdTermGpa.credits = stats(1)
    }
    for (year <- yearGradeMap.keySet) {
      val stdYearGpa = new StdYearGpa()
      stdYearGpa.schoolYear = year
      stdGpa.add(stdYearGpa)
      val yearGrades = yearGradeMap(year)
      stdYearGpa.gpa = gpaPolicy.calcGpa(yearGrades)
      stdYearGpa.ga = gpaPolicy.calcGa(yearGrades)
      stdYearGpa.count = yearGrades.size
      val stats = statCredits(yearGrades)
      stdYearGpa.totalCredits = stats(0)
      stdYearGpa.credits = stats(1)
    }
    stdGpa.gpa = gpaPolicy.calcGpa(grades)
    stdGpa.ga = gpaPolicy.calcGa(grades)
    stdGpa.count = courseMap.size
    val totalStats = statCredits(courseMap.values)
    stdGpa.totalCredits = totalStats(0)
    stdGpa.credits = totalStats(1)
    val now = new Date()
    stdGpa.updatedAt = now
    stdGpa
  }

  def statGpa(std: Student, semesters: Semester*): StdGpa = {
    statGpa(std, courseGradeProvider.getPublished(std, semesters: _*))
  }

  def statGpas(stds: Iterable[Student], semesters: Semester*): MultiStdGpa = {
    val semesterGpas = new collection.mutable.ListBuffer[StdGpa]
    for (std <- stds) {
      semesterGpas += statGpa(std, semesters: _*)
    }
    new MultiStdGpa(stds, semesterGpas)
  }

  /**
   * 统计学分，0为修读学分，1为实得学分
   */
  private def statCredits(grades: Iterable[CourseGrade]): Array[Float] = {
    var credits = 0f
    var all = 0f
    for (grade <- grades) {
      if (grade.passed) credits += grade.course.credits
      all += grade.course.credits
    }
    Array(all, credits)
  }
}
