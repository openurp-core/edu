package org.openurp.edu.base.code.service

import org.openurp.code.BaseCode
import org.openurp.edu.base.Project

trait BaseCodeService {

  def getCodes[T <: BaseCode](project: Project, clazz: Class[T]): Seq[T]

  def getCode[T <: BaseCode](clazz: Class[T], id: Integer): T
}