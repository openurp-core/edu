package org.openurp.edu.teach.grade.domain

import collection.mutable

import org.beangle.data.model.bean.{ LongIdBean, UpdatedBean }
import org.openurp.base.Semester
import org.openurp.edu.base.Student

/**
 * 学生历学期的成绩绩点
 */
class StdGpa extends LongIdBean with UpdatedBean {
  /**
   *  学生
   */
  var std: Student = _

  /**
   * 每学期平均绩点
   */
  var semesterGpas: mutable.Buffer[StdSemesterGpa] = new mutable.ListBuffer[StdSemesterGpa]

  /**
   * 每学年平均绩点
   *
   * @see StdSemesterGpa
   */
  var yearGpas: mutable.Buffer[StdYearGpa] = new mutable.ListBuffer[StdYearGpa]

  /**
   * 总平均绩点
   */
  var gpa: java.lang.Float = _

  /**
   * 平均分
   */
  var ga: java.lang.Float = _

  /**
   * 总学分
   */
  var credits: java.lang.Float = _

  /**
   * 修读学分
   */
  var totalCredits: java.lang.Float = _

  /**
   * 成绩的门数
   */
  var count: Int = _

  /**
   * 查询类缓存
   */
  @transient private var semesterGpaCache: Map[Semester, StdSemesterGpa] = _

  @transient private var yearGpaCache: Map[String, StdYearGpa] = _

  def this(id: java.lang.Long) {
    this()
    this.id = id
  }

  def this(std: Student) {
    this()
    this.std = std
    this.semesterGpas = new collection.mutable.ListBuffer[StdSemesterGpa]
    this.yearGpas = new collection.mutable.ListBuffer[StdYearGpa]
    this.credits = 0f
    this.count = 0
    this.ga = new java.lang.Float(0)
    this.gpa = new java.lang.Float(0)
  }

  def getGpa(semester: Semester): java.lang.Float = {
    val gpterm = getStdTermGpa(semester)
    if (null == gpterm) null else gpterm.gpa
  }

  def getStdTermGpa(semester: Semester): StdSemesterGpa = {
    if (null == semesterGpaCache || semesterGpaCache.size != semesterGpas.size) {
      semesterGpaCache = semesterGpas.map(f => (f.semester, f)).toMap
    }
    semesterGpaCache.get(semester).orNull
  }

  def getYearGpa(schoolYear: String): StdYearGpa = {
    if (null == yearGpaCache || yearGpaCache.size != yearGpas.size) {
      yearGpaCache = yearGpas.map(f => (f.schoolYear, f)).toMap
    }
    yearGpaCache.get(schoolYear).orNull
  }

  def add(stdTermGpa: StdSemesterGpa) {
    stdTermGpa.stdGpa = this
    semesterGpas += stdTermGpa
  }

  def add(stdYearGpa: StdYearGpa) {
    stdYearGpa.stdGpa = this
    yearGpas += stdYearGpa
  }
}
