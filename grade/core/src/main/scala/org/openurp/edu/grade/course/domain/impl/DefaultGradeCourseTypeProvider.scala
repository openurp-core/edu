package org.openurp.edu.grade.course.domain.impl

import org.beangle.data.dao.{ EntityDao, OqlBuilder }
import org.openurp.edu.base.code.model.CourseType
import org.openurp.edu.base.model.{ Course, Student }
import org.openurp.edu.grade.course.domain.GradeCourseTypeProvider
import org.openurp.edu.program.plan.domain.CoursePlanProvider
import org.openurp.edu.program.plan.model.SharePlan

class DefaultGradeCourseTypeProvider(entityDao: EntityDao, coursePlanProvider: CoursePlanProvider) extends GradeCourseTypeProvider {

  def getCourseType(std: Student, course: Course, defaultCourseType: CourseType): CourseType = {
    val plan = coursePlanProvider.getCoursePlan(std)
    var planCourseType: CourseType = null
    if (null != plan) {
      val groupIter = plan.groups.iterator
      while (null == planCourseType && groupIter.hasNext) {
        groupIter.next().planCourses.find(pc => pc.course == course) foreach { pc =>
          planCourseType = pc.group.courseType
        }
      }
    }

    if (null == planCourseType) {
      val grade = std.state.grade.substring(0, 4)
      val builder = OqlBuilder.from(classOf[SharePlan], "sp").join("sp.groups", "spg")
        .join("spg.planCourses", "spgp")
        .where("spgp.course=:course", course)
        .where("sp.project=:project", std.project)
        .where("year(sp.effectiveOn)<=:grade and (sp.invalidOn is null or year(sp.invalidOn)>=:grade)",
          grade)
        .select("spg.courseType")
      val types = entityDao.search(builder)
      if (!types.isEmpty) planCourseType = types(0).asInstanceOf[CourseType]
    }
    if (null == planCourseType) planCourseType = defaultCourseType
    planCourseType
  }

}