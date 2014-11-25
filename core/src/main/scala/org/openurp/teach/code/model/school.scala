package org.openurp.teach.code.model

import org.openurp.platform.code.BaseCodeBean
import org.openurp.teach.code.{ StdLabel, StdLabelType, StdType }
import org.openurp.teach.code.ElectionMode
import org.openurp.teach.code.ExamForm
import org.openurp.teach.code.TeachLangType
import org.openurp.teach.code.GradeType
import org.openurp.teach.code.ExamMode
import org.openurp.teach.code.ExamStatus
import org.openurp.teach.code.ExamType
import org.openurp.teach.code.ScoreMarkStyle
import org.openurp.teach.code.CourseHourType
import org.openurp.teach.code.CourseType
import org.openurp.teach.code.CourseCategory
import org.openurp.teach.code.CourseTakeType
import org.openurp.teach.code.CourseAbilityRate
import org.openurp.teach.code.LessonTag

/**
 * 学生分类标签
 *
 * @author chaostone
 * @since 3.0.0
 */
class StdLabelBean extends BaseCodeBean with StdLabel {

  var labelType: StdLabelType = _
}
/**
 * 学生分类标签类型
 *
 * @author chaostone
 * @since 3.0.0
 */

class StdLabelTypeBean extends BaseCodeBean with StdLabelType {

}

/**
 * 学生类别
 *
 * @author chaostone
 * @since 3.0.0
 */
class StdTypeBean extends BaseCodeBean with StdType

class ElectionModeBean extends BaseCodeBean with ElectionMode {

}

class ExamFormBean extends BaseCodeBean with ExamForm

class TeachLangTypeBean extends BaseCodeBean with TeachLangType

/**
 * 考核方式
 *
 * @author chaostone
 * @since 2005-9-7
 */
class ExamModeBean extends BaseCodeBean with ExamMode

/**
 * 考试情况
 * 正常、作弊、旷考等
 *
 * @author chaostone
 * @since 2005-9-7
 */
class ExamStatusBean extends BaseCodeBean with ExamStatus {
  /**
   * 是否参加考试
   */
  var attend: Boolean = _
  /**
   * 是否需要参加下一次缓考
   * @return
   */
  var needAttendDelay: Boolean = _
  /**
   * 能否录入成绩
   * @return
   */
  var inputable: Boolean = _

  def this(id: Integer) {
    this()
    this.id = id
  }
}

/**
 * 考试类型
 *
 * @author 塞外狂人
 * @author chaostone
 * @since 2005-9-7
 */
class ExamTypeBean extends BaseCodeBean with ExamType {

  def this(id: Integer, code: String, name: String, enName: String) {
    this()
    this.id = id
    this.code = code
    this.name = name
    this.enName = enName
  }
  var gradeType: GradeType = _
}

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

  def this(id: Integer) {
    this()
    this.id = id
  }

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
 */
class ScoreMarkStyleBean extends BaseCodeBean with ScoreMarkStyle {

  var numStyle: Boolean = _
  def this(id: Integer) {
    this()
    this.id = id
  }
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
 */
class CourseHourTypeBean extends BaseCodeBean with CourseHourType {

}

/**
 * 课程能力等级
 */
class CourseAbilityRateBean extends BaseCodeBean with CourseAbilityRate

/**
 * 教学任务标签
 */
class LessonTagBean extends BaseCodeBean with LessonTag
