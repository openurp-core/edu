package org.openurp.teach.domain.code

import org.openurp.platform.model.BaseCodeBean
import org.openurp.teach.code.StdType
import org.openurp.teach.code.StdLabel
import org.openurp.teach.code.StdLabelType



/**
 * 学生分类标签
 *
 * @author chaostone
 * @since 3.0.0
 */
class StdLabelBean extends BaseCodeBean with StdLabel {

 var labelType: StdLabelType=_
}

class StdLabelTypeBean extends BaseCodeBean with StdLabelType{
  
}

/**
 * 学生类别
 *
 * @author chaostone
 * @since 3.0.0
 */
class StdTypeBean extends BaseCodeBean with StdType {

   var lableType: StdLabelType=_
}