package org.openurp.teach.grade.model

import java.lang.{Short => JShort}
import org.beangle.data.model.annotation.config
import org.openurp.teach.code.GradeType

/**
 * 考试成绩状态
 *
 * @author chaostone
 */
@config
class ExamGradeState extends AbstractGradeState{

  /**
   * 成绩类型
   */
  var gradeType: GradeType = _

  /**
   * 总成绩状态
   */
  var gradeState: CourseGradeState = _

  /**
   * 备注
   */
  var remark: String = _

  /**
   * 百分比描述 <br>
   * 10% 就是 10， 20% 就是 20<br>
   */
  var percent: JShort = _
}