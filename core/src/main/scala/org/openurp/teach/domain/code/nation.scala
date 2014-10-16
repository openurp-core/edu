package org.openurp.teach.domain.code

import org.openurp.platform.model.BaseCodeBean
import org.openurp.teach.code.TeacherTitle
import org.openurp.teach.code.Degree
import org.openurp.teach.code.TeacherTitleLevel
import org.openurp.teach.code.StudyType
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