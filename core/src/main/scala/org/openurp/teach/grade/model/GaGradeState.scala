package org.openurp.teach.grade.model

import org.openurp.teach.code.GradeType
import org.beangle.data.model.annotation.config
/**
 * 考试成绩状态
 *
 * @author chaostone
 */
@config
class GaGradeState extends AbstractGradeState {

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
}
