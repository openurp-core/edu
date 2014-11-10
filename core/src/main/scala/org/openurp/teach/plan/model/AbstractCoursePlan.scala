package org.openurp.teach.plan.model

import org.openurp.teach.code.CourseType
import org.openurp.teach.plan.CoursePlan
import org.openurp.teach.plan.CourseGroup
import org.beangle.data.model.bean.LongIdBean
import org.beangle.commons.lang.Strings
import collection.mutable.{ Buffer, ListBuffer }
import org.openurp.teach.core.States
import org.beangle.data.model.bean.UpdatedBean
/**
 * 抽象课程方案
 *
 * @author chaostone
 * @since 2009
 */
trait AbstractCoursePlan extends UpdatedBean with CoursePlan {

  /**
   * 课程组
   */
  var groups: Buffer[CourseGroup] = new ListBuffer[CourseGroup]

  /**
   * 要求学分
   */
  var credits: Float = _

  /**
   * 起始学期
   */
  var startTerm: Short = _

  /**
   * 结束学期
   */
  var endTerm: Short = _

  /**
   * 审核状态
   */
  var state: States.State = States.Draft

  var remark: String = _
  
  def terms = (endTerm - startTerm + 1).asInstanceOf[Short]

  /**
   * 返回课程中出现的所有学期
   */
  def termList: List[String] = {
    val terms = new collection.mutable.HashSet[String]
    for (g <- groups; pc <- g.planCourses if null != pc.terms && pc.terms != "*"; t <- Strings.split(pc.terms)) {
      terms += t
    }
    terms.toList.sorted
  }

  def addGroup(group: CourseGroup) {
    groups += group
  }

  override def tops: Seq[CourseGroup] = {
    val res = new ListBuffer[CourseGroup]
    for (group <- groups if group.parent == null) res += group
    res
  }

  override def group(courseType: CourseType): CourseGroup = {
    groups.find(_.courseType == courseType).orNull
  }
}
