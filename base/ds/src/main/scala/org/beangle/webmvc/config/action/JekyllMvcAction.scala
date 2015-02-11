/*
 * Beangle, Agile Development Scaffold and Toolkit
 *
 * Copyright (c) 2005-2014, Beangle Software.
 *
 * Beangle is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Beangle is distributed in the hope that it will be useful.
 * but WITHOUT ANY WARRANTY without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Beangle.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.beangle.webmvc.config.action

import org.beangle.commons.io.{ IOs, ResourcePatternResolver }
import org.beangle.commons.lang.Strings
import org.beangle.commons.lang.annotation.description
import org.beangle.commons.lang.reflect.BeanManifest
import org.beangle.webmvc.api.action.ActionSupport
import org.beangle.webmvc.config.Configurer
import org.beangle.webmvc.dispatch.impl.HierarchicalUrlMapper
import org.beangle.commons.text.i18n.DefaultTextFormater
import org.beangle.commons.text.i18n.DefaultTextBundleRegistry
import java.util.Locale
import org.beangle.webmvc.config.ActionConfig
import org.beangle.commons.text.i18n.HierarchicalTextResource

/**
 * @author chaostone
 */
@description("Beange WebMVC Jekyll Template Generator")
class JekyllMvcAction extends ActionSupport {

  var configurer: Configurer = _

  def index(): String = {
    val packageName = get("packageName", "")
    val actionNames = new collection.mutable.HashSet[String]
    val configs = configurer.actionConfigs.values.toSet
    val descriptions = new collection.mutable.HashMap[String, String]
    val bundleRegistry = new DefaultTextBundleRegistry()
    val formater = new DefaultTextFormater()
    val messages = new Messages(Locale.SIMPLIFIED_CHINESE)
    val configMap = new collection.mutable.HashMap[String, ActionConfig]
    configs foreach { config =>
      if (config.clazz.getName.startsWith(packageName)) {
        val actionName = config.name
        actionNames += actionName
        descriptions.put(actionName, messages.get(config.clazz, "class"))
        configMap.put(actionName, config)
      }
    }
    put("messages", messages)
    put("configMap", configMap)
    put("actionNames", actionNames.toList.sorted)
    put("descriptions", descriptions)
    forward()
  }
}

class Messages(val locale: Locale) {
  val registry = new DefaultTextBundleRegistry()
  val format = new DefaultTextFormater()
  def get(clazz: Class[_], key: String): String = {
    if (key == "class") {
      val bundle = registry.load(locale, clazz.getPackage.getName + ".package")
      bundle.get(clazz.getSimpleName).orNull
    } else {
      new HierarchicalTextResource(clazz, locale, registry, format)(key).orNull
    }
  }
}