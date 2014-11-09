package org.beangle.data.serializer.io.json

import org.beangle.commons.bean.PropertyUtils
import org.beangle.commons.collection.Properties

class MyJsonObject extends Properties {

  def this(obj: Object, attrs: String*) {
    this()
    for (attr <- attrs) {
      val idx = attr.indexOf("->")
      if (-1 == idx) {
        val value = PropertyUtils.getProperty[Any](obj, attr)
        if (null != value) this.put(attr, value)
      } else {
        val value = PropertyUtils.getProperty[Any](obj, attr.substring(0, idx))
        if (null != value) this.put(attr.substring(idx + 2), value)
      }
    }
  }

  override def add(attr: String, obj: Object, nestedAttrs: String*): Unit = {
    if (null != obj)
      put(attr, new MyJsonObject(obj, nestedAttrs: _*))
  }
}