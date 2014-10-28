package org.openurp.teach.domain

import scala.collection.mutable.Buffer

import org.beangle.data.model.bean.IntIdBean
import org.beangle.data.model.bean.LongIdBean
import org.beangle.data.model.bean.NamedBean
import org.beangle.data.model.bean.TemporalOnBean
import org.openurp.base.Calendar
import org.openurp.base.Campus
import org.openurp.base.Department
import org.openurp.base.Room
import org.openurp.base.School
import org.openurp.base.TimeSetting
import org.openurp.base.code.Education
import org.openurp.base.domain.code.CodeMeta
import org.openurp.teach.Project
import org.openurp.teach.ProjectBasedObject
import org.openurp.teach.ProjectClassroom
import org.openurp.teach.ProjectConfig
import org.openurp.teach.ProjectProperty
import org.openurp.teach.code.StdLabel
import org.openurp.teach.code.StdType
/**
 * 项目
 * 
 * @has 1..* AssignedTo 1..* Department
 * @has 1..* AssignedTo 1..* Education
 * @has 1..* AssignedTo 1..* StudentType
 * @has 1..* AssignedTo 1..* StdLabel
 * @depend - - - Calendar
 */
class ProjectBean extends IntIdBean with NamedBean with TemporalOnBean with Project  {
	/** 适用学校 */
  var school:School=_
  	/** 校区列表 */
 var campuses: Buffer[Campus]= new collection.mutable.ListBuffer[Campus]
 	/** 部门列表 */
 var departments:Buffer[Department]= new collection.mutable.ListBuffer[Department]
   /** 学历层次列表 */
 var educations:Buffer[Education]=new collection.mutable.ListBuffer[Education]
 	/** 学生分类列表 */
 var labels:Buffer[StdLabel]=new collection.mutable.ListBuffer[StdLabel]
 /** 学生类别列表 */
 var types:Buffer[StdType]=new collection.mutable.ListBuffer[StdType]
 	/** 使用校历 */
 var calendar:Calendar=_
 	/** 小节设置 */
 var timeSettings:Buffer[TimeSetting]=new collection.mutable.ListBuffer[TimeSetting]
 	/** 描述 */
 var description:String=_
 	/** 是否辅修 */
 var minor:Boolean=_
// 	/** 生效时间 */
// var effectiveAt:Date=_
//	/** 失效时间 */
// var invalidAt : Date=_
 
 

}

/**
 * 项目教室配置
 * @author chaostone
 *
 */
class ProjectClassroomBean extends ProjectBasedObject[java.lang.Long] with ProjectClassroom {
  	/** 教室 */
  var room:Room=_
  	/** 固定使用部门 */
  var departs:collection.mutable.Set[Department]= new collection.mutable.HashSet[Department]
  /** 保留时间 */
//  var reserved:List[TimeUnit]=_
} 

/**
 * 项目基础代码配置
 * 表示项目使用了基础代码集合中的哪些基础代码
 * 
 * @author chaostone
 */
class ProjectCodeBean extends LongIdBean {
  	/**项目*/
  var project:Project=_
  	/**代码元*/
  var meta:CodeMeta=_
  	/**代码ID*/
  var codeId:Integer=_
}


/**
 * 项目配置
 * @author chaostone
 *
 */
class ProjectConfigBean extends ProjectBasedObject[Integer] with ProjectConfig{

  	/**
	 * 项目配置项
	 */
  var properties:java.util.Map[Long,ProjectProperty]=_
}


/**
 * 项目配置属性
 * @author chaostone
 *
 */
class ProjectPropertyBean extends  LongIdBean with NamedBean with ProjectProperty{
  
  
	/**项目配置*/
  var config:ProjectConfig=_
  	/**值*/
  var value:String=_
  
//  var  properties:Map[String,ProjectProperty]=_
}


