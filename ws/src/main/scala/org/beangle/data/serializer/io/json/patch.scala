package org.beangle.data.serializer.io.json

import org.beangle.commons.bean.PropertyUtils

class MyJsonObject extends JsonObject {

  def this(obj: Object, attrs: String*) {
    this()
    for (attr <- attrs) {
      val value = PropertyUtils.getProperty[Any](obj, attr)
      if (null != value) this.put(attr, value)
    }
  }

  def add(attr: String, obj: Object, nestedAttrs: String*): Unit = {
    if (null != obj)
      put(attr, new MyJsonObject(obj, nestedAttrs: _*))
  }
}