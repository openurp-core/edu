package org.beangle.commons.bean

import org.beangle.commons.conversion.impl.DefaultConversion
import org.beangle.commons.conversion.Conversion

object PropertyUtils {

  @throws(classOf[NoSuchMethodException])
  def setProperty(bean: AnyRef, name: String, value: Any) {
    Properties.set(bean, name, value)
  }

  def getProperty[T <: Any](inputBean: Any, propertyName: String): T = {
    Properties.get(inputBean, propertyName)
  }

  def copyProperty(bean: AnyRef, propertyName: String, value: Any, conversion: Conversion): Any = {
    Properties.copy(bean, propertyName, value, conversion)
  }
  def copyProperty(bean: AnyRef, name: String, value: AnyRef): Any = {
    Properties.copy(bean, name, value, DefaultConversion.Instance)
  }

  def getPropertyType(clazz: Class[_], name: String): Class[_] = {
    Properties.getType(clazz, name)
  }

  def getWritableProperties(clazz: Class[_]): Set[String] = {
    Properties.writables(clazz)
  }

  def isWriteable(bean: AnyRef, name: String): Boolean = {
    Properties.isWriteable(bean, name)
  }

}