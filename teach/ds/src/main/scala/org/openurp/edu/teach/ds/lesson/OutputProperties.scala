package org.openurp.edu.teach.ds.lesson

import org.beangle.data.model.Entity
import org.openurp.base.Semester
import org.openurp.code.BaseCode
import org.openurp.edu.base.Student
import org.openurp.edu.base.Course
import org.openurp.edu.teach.lesson.{ LessonLimitGroup, CourseSchedule, CourseTake, ExamSchedule, Lesson, TeachClass }
import org.openurp.edu.teach.schedule.CourseActivity

object OutputProperties {

  def courseTakes(iscsv: Boolean): List[Tuple2[Class[_], List[String]]] = {
    if (iscsv) {
      List(classOf[CourseTake] -> List("std", "lesson", "course", "courseTakeType", "electionMode", "semester", "turn"),
        classOf[Entity[_]] -> List("id"))
    } else {
      List(
        classOf[CourseTake] -> List("std", "lesson", "courseTakeType", "electionMode", "semester", "course", "turn"),
        classOf[Semester] -> List("id", "code", "schoolYear", "name"),
        classOf[Course] -> List("id", "code", "name", "credits"),
        classOf[Student] -> List("id", "code", "name"),
        classOf[BaseCode] -> List("id", "code", "name"),
        classOf[Entity[_]] -> List("id"))
    }
  }

  def lessons(isCsv: Boolean): List[Tuple2[Class[_], List[String]]] = {
    if (isCsv) {
      List(classOf[Lesson] -> List("id", "no", "course", "courseType", "teachDepart", "teachers", "campus", "teachClass", "semester", "schedule", "exam", "langType", "group", "state", "tags"),
        classOf[TeachClass] -> List("name", "stdCount", "limitCount"),
        classOf[ExamSchedule] -> List("examMode"),
        classOf[CourseSchedule] -> List("startWeek", "endWeek", "period", "weekState", "roomType", "published"),
        classOf[Entity[_]] -> List("id"))
    } else {
      List(classOf[Lesson] -> List("id", "no", "course", "courseType", "teachDepart", "teachers", "campus", "teachClass", "semester", "schedule", "exam", "langType", "group", "state", "tags"),
        classOf[TeachClass] -> List("name", "stdCount", "limitCount", "limitGroups"),
        classOf[ExamSchedule] -> List("activities", "examMode"),
        classOf[CourseSchedule] -> List("startWeek", "endWeek", "period", "weekState", "activities", "roomType", "published"),
        classOf[Course] -> List("id", "code", "name"),
        classOf[BaseCode] -> List("id", "code", "name"),
        classOf[Entity[_]] -> List("id"))
    }
  }

  def LessonLimitGroups(isCsv: Boolean): List[Tuple2[Class[_], List[String]]] = {
    if (isCsv) {
      List(classOf[LessonLimitGroup] -> List("lesson", "maxCount", "curCount", "forClass"),
        classOf[Entity[_]] -> List("id"))
    } else {
      List(classOf[LessonLimitGroup] -> List("lesson", "maxCount", "curCount", "forClass", "items"),
        classOf[Entity[_]] -> List("id"))
    }
  }

  def courseActivities(isCsv: Boolean): List[Tuple2[Class[_], List[String]]] = {
    if (isCsv) {
      List(classOf[CourseActivity] -> List("lesson ", "time", "remark"),
        classOf[Entity[_]] -> List("id"))
    } else {
      List(classOf[CourseActivity] -> List("lesson ", "time", "teachers", "rooms", "remark"),
        classOf[Entity[_]] -> List("id"))
    }
  }
}