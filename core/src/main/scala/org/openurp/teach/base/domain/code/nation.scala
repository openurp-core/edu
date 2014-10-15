package org.openurp.teach.base.domain.code

import org.openurp.platform.model.BaseCodeBean
import org.openurp.teach.base.code.TeacherTitle
import org.openurp.teach.base.code.Degree
import org.openurp.teach.base.code.TeacherTitleLevel
import org.openurp.teach.base.code.StudyType
/**
 * 教师职称
 * 
 * @author chaostone
 * @since 2005-9-7
 */

class TeacherTitleBean extends BaseCodeBean with TeacherTitle{
  
}


/**
 * 教师职称等级
 * 
 * @author chaostone
 * @since 2005-9-7
 */
class TeacherTitleLevelBean extends BaseCodeBean with TeacherTitleLevel{
  
}

/**
 * 学位
 * 
 * @author chaostone
 * @since 2005-9-7
 */

class DegreeBean extends BaseCodeBean with Degree{
  
}

class StudyTypeBean extends BaseCodeBean with StudyType