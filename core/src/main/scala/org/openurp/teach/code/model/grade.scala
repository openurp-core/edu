package org.openurp.teach.code.model

import org.openurp.platform.model.BaseCodeBean
import org.openurp.teach.code.{CourseAbilityRate, CourseCategory, CourseHourType, CourseTakeType, CourseType, GradeType, ScoreMarkStyle}

/**
 * 课程类别
 *
 * @author chaostone
 * @since 2005-9-7
 */
class CourseTypeBean extends BaseCodeBean with CourseType {
  var theoretical: Boolean = _

  def this(id: Integer, code: String, name: String, enName: String) {
    this()
    this.id = id
    this.code = code
    this.name = name
    this.enName = enName
  }
}

/**
 * 课程种类
 * （一般、体育、挂牌、双语）
 *
 * @author chaostone
 * @since 2005-11-17
 */
class CourseCategoryBean extends BaseCodeBean with CourseCategory {

}

/**
 * 修课类别
 * （重修、增修、免修不免试、主修，选修）
 *
 * @author chaostone
 * @since 2005-12-2
 */
class CourseTakeTypeBean extends BaseCodeBean with CourseTakeType {
  /** 是否重修 */
  var retake: Boolean = _
  /** 是否考核 */
  var exam: Boolean = _

  def this(id: Integer, code: String, name: String, enName: String) {
    this()
    this.id = id
    this.code = code
    this.name = name
    this.enName = enName
  }
}

/**
 * 成绩类型
 *
 * @author chaostone
 * @since 2005-9-7
 */
class GradeTypeBean extends BaseCodeBean with GradeType {
  /**
   * 简名
   */
  var shortName: String = _
  def this(id: Integer, code: String, name: String, enName: String) {
    this()
    this.id = id
    this.code = code
    this.name = name
    this.enName = enName
  }
}

/**
 * 成绩记录方式
 *
 * @author chaostone
 * @since 2005-9-7
 */
class ScoreMarkStyleBean extends BaseCodeBean with ScoreMarkStyle {

  var numStyle: Boolean = _
  def this(id: Integer, code: String, name: String, enName: String) {
    this()
    this.id = id
    this.code = code
    this.name = name
    this.enName = enName
  }
}

/**
 * 课时类别代码
 *
 * @author chaostone
 * @since 2009
 */
class CourseHourTypeBean extends BaseCodeBean with CourseHourType {

}

/**
 * 课程能力等级
 *
 * @author chaostone
 * @since 2011-09-19
 */
class CourseAbilityRateBean extends BaseCodeBean with CourseAbilityRate


