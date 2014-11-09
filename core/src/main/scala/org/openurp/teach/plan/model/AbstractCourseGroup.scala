package org.openurp.teach.plan.model

import collection.mutable.{ Buffer, ListBuffer }

import org.beangle.commons.lang.{ Numbers, Strings }
import org.beangle.data.model.Named
import org.beangle.data.model.bean.LongIdBean
import org.openurp.teach.code.CourseType
import org.openurp.teach.plan.{ CourseGroup, CoursePlan, PlanCourse }
import org.openurp.teach.plan.domain.Terms

/**
 * 课程设置中的课程组 </p>
 *
 * @author chaostone
 * @since 2009
 */
trait AbstractCourseGroup extends LongIdBean with CourseGroup with Named with Cloneable with Ordered[CourseGroup] {
  /**
   * 计划
   */
  var plan: CoursePlan = _

  /**
   * 上级组
   */
  var parent: CourseGroup = _

  /**
   * 下级组列表
   */
  var children: Buffer[AbstractCourseGroup] = new ListBuffer[AbstractCourseGroup]

  /**
   * 计划课程列表
   */
  var planCourses: Buffer[PlanCourse] = new ListBuffer[PlanCourse]

  /**
   * 课程类别
   */
  var courseType: CourseType = _

  /**
   * 要求学分
   */
  var credits: Float = _

  /**
   * 要求完成组数
   */
  var groupNum: Short = _

  /**
   * 要求门数
   */
  var courseNum: Short = _

  /**
   * 备注
   */
  var remark: String = _

  /**
   * 学期学分分布
   */
  var termCredits: String = _

  /**
   * index no
   */
  var indexno: String = _

  def name(): String = {
    if ((null == courseType)) null else courseType.name
  }

  def index(): Int = {
    var index = Strings.substringAfterLast(indexno, ".")
    if (Strings.isEmpty(index)) index = indexno
    var idx = Numbers.toInt(index)
    if (idx <= 0) idx = 1
    idx
  }

  def compulsory: Boolean = {
    val requiredGroupNum = if (groupNum == -1) children.size else groupNum
    (requiredGroupNum == children.size && !planCourses.exists(p => !p.compulsory))
  }

  def addGroup(group: AbstractCourseGroup) {
    group.parent = this
    children += group
  }

  def addCourse(planCourse: AbstractPlanCourse): Unit = {
    if (planCourses.exists(_.course == planCourse.course)) return
    planCourse.group = this
    planCourses += planCourse
  }

  def removeCourse(pc: PlanCourse) {
    planCourses -= pc
  }

  /**
   * 添加计划课程
   */
  def addCourses(planCourses: Iterable[AbstractPlanCourse]) {
    for (element <- planCourses) {
      addCourse(element)
    }
  }

  def follow(plan: CoursePlan) {
    this.plan = plan
    children.foreach { c =>
      c.follow(plan)
    }
  }

  def planCourses(terms: String): Seq[PlanCourse] = {
    if (Strings.isEmpty(terms)) return planCourses.toList

    val result = new collection.mutable.HashSet[PlanCourse]
    val termSeq = Strings.splitToInt(terms)
    for (i <- 0 until termSeq.length) {
      result ++= planCourses.filter(pc => Terms.matches(pc.terms, termSeq(i)))
    }
    result.toSeq
  }

  override def compare(o: CourseGroup): Int = indexno.compareTo(o.indexno)
}
