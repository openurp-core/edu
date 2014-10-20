package org.openurp.teach.domain.code

import org.beangle.data.model.annotation.code
import org.openurp.platform.model.BaseCodeBean
import org.openurp.teach.code.StdLabel
import org.openurp.teach.code.StdLabelType
import org.openurp.teach.code.StdType



/**
 * 学生分类标签
 *
 * @author chaostone
 * @since 3.0.0
 */
class StdLabelBean extends BaseCodeBean with StdLabel {

 var labelType: StdLabelType=_
}
/**
 * 学生分类标签类型
 * 
 * @author chaostone
 * @since 3.0.0
 */

class StdLabelTypeBean extends BaseCodeBean with StdLabelType{
  
}

/**
 * 学生类别
 *
 * @author chaostone
 * @since 3.0.0
 */
class StdTypeBean extends BaseCodeBean with StdType {

   var labelType: StdLabelType=_
}