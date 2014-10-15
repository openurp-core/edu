package org.openurp.teach.base.domain.code

import org.openurp.platform.model.BaseCodeBean








/**
 * 课程类别
 * 
 * @author chaostone
 * @since 2005-9-7
 */
class CourseTypeBean extends BaseCodeBean{
  var theoretical:Boolean=_
} 

/**
 * 课程种类
 * （一般、体育、挂牌、双语）
 * 
 * @author chaostone
 * @since 2005-11-17
 */
class CourseCategoryBean extends BaseCodeBean{
  
}





/**
 * 修课类别
 * （重修、增修、免修不免试、主修，选修）
 * 
 * @author chaostone
 * @since 2005-12-2
 */
class CourseTakeTypeBean extends BaseCodeBean{
  	/** 是否重修 */
  var retake:Boolean=_
  	/** 是否考核 */
  var exam:Boolean=_
  
}


/**
 * 成绩类型
 * 
 * @author chaostone
 * @since 2005-9-7
 */
class GradeTypeBean extends BaseCodeBean{
  	/**
	 * 简名
	 */
  var shortName:String=_
  
  
}


/**
 * 成绩记录方式
 * 
 * @author chaostone
 * @since 2005-9-7
 */
class ScoreMarkStyleBean extends BaseCodeBean{

  var numStyle:Boolean=_
}

/**
 * 课时类别代码
 * 
 * @author chaostone
 * @since 2009
 */
class CourseHourTypeBean extends BaseCodeBean{
 
}

/**
 * 课程能力等级
 * 
 * @author chaostone
 * @since 2011-09-19
 */
class CourseAbilityRateBean extends BaseCodeBean


