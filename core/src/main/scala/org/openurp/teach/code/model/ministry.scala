package org.openurp.teach.code.model

import org.openurp.platform.code.BaseCodeBean
import org.openurp.teach.code.{Discipline, DisciplineCatalog}

/**
 * 学科目录
 * 
 * 一般有：本科学科目录、研究生学术性学位目录、研究生专业性学位目录
 * 
 * @author qianjia
 * @since 3.0.0
 */

class DisciplineCatalogBean extends BaseCodeBean with DisciplineCatalog{
  
}
/**
 * 学科
 * （来自本专科科学科目录、研究生学术性学位目录、研究生专业性学位目录的学科）<br>
 * 一般认为4位代码的是一级学科，2位代码的是二级学科，但实际上可能没有一级学科、二级学科这种叫法
 * 
 * @author chaostone
 * @since 2005-9-7
 * @since 3.0.0
 */
class DisciplineBean extends BaseCodeBean with Discipline{
  
}