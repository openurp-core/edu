package org.openurp.teach.core.model

import scala.collection.mutable.{ Buffer, ListBuffer }

import org.beangle.data.model.bean.{ IntIdBean, LongIdBean, NamedBean, TemporalOnBean }
import org.openurp.base.{ Calendar, Campus, Department, Room, School, TimeSetting }
import org.openurp.base.code.Education
import org.openurp.base.model.code.CodeMeta
import org.openurp.teach.code.{ StdLabel, StdType }
import org.openurp.teach.core.{ Project, ProjectBasedObject, ProjectClassroom }
/**
 * 项目
 *
 * @has 1..* AssignedTo 1..* Department
 * @has 1..* AssignedTo 1..* Education
 * @has 1..* AssignedTo 1..* StudentType
 * @has 1..* AssignedTo 1..* StdLabel
 * @depend - - - Calendar
 */
class ProjectBean extends IntIdBean with NamedBean with TemporalOnBean with Project {
  /** 适用学校 */
  var school: School = _
  /** 校区列表 */
  var campuses: Buffer[Campus] = new ListBuffer[Campus]
  /** 部门列表 */
  var departments: Buffer[Department] = new ListBuffer[Department]
  /** 学历层次列表 */
  var educations: Buffer[Education] = new ListBuffer[Education]
  /** 学生分类列表 */
  var labels: Buffer[StdLabel] = new ListBuffer[StdLabel]
  /** 学生类别列表 */
  var types: Buffer[StdType] = new ListBuffer[StdType]
  /** 使用校历 */
  var calendar: Calendar = _
  /** 小节设置 */
  var timeSettings: Buffer[TimeSetting] = new ListBuffer[TimeSetting]
  /** 描述 */
  var description: String = _
  /** 是否辅修 */
  var minor: Boolean = _

  var properties: collection.mutable.Map[String, String] = new collection.mutable.HashMap[String, String]

}
/**
 * 项目基础代码配置
 * 表示项目使用了基础代码集合中的哪些基础代码
 *
 * @author chaostone
 */
class ProjectCodeBean extends LongIdBean {
  /**项目*/
  var project: Project = _
  /**代码元*/
  var meta: CodeMeta = _
  /**代码ID*/
  var codeId: Integer = _
}

/**
 * 项目教室配置
 * @author chaostone
 *
 */
class ProjectClassroomBean extends ProjectBasedObject[java.lang.Long] with ProjectClassroom {
  /** 教室 */
  var room: Room = _
  /** 固定使用部门 */
  var departs: collection.mutable.Set[Department] = new collection.mutable.HashSet[Department]
  /** 保留时间 */
  //  var reserved:List[TimeUnit]=_
} 

