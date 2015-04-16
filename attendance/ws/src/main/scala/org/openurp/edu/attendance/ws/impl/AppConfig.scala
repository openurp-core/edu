/*
 * OpenURP, Open University Resouce Planning
 *
 * Copyright (c) 2013-2014, OpenURP Software.
 *
 * OpenURP is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * OpenURP is distributed in the hope that it will be useful.
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Beangle.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.openurp.edu.attendance.ws.impl

import scala.collection.JavaConversions.propertiesAsScalaMap
import org.beangle.commons.bean.Initializing
import org.beangle.commons.lang.ClassLoaders
import org.beangle.commons.lang.Numbers
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import org.beangle.commons.lang.SystemInfo
/**
 * 应用配置
 *
 * @author chaostone
 * @version 1.0, 2014/03/22
 * @since 0.0.1
 */
object AppConfig {

  val properties = new collection.mutable.HashMap[String, String]

  def init() {
    val configFile = new File("/etc/openurp/edu/attendance/conf.properties")
    if (configFile.exists()) {
      properties ++= loadProperties(new FileInputStream(configFile))
    }

    val openurpHome = SystemInfo.properties.get("OPENURP_HOME").getOrElse(SystemInfo.user.home + "/.openurp");
    val myConfigFile = new File(openurpHome + "/edu/attendance/conf.properties")
    if (myConfigFile.exists()) {
      properties ++= loadProperties(new FileInputStream(myConfigFile))
    }
  }

  init()

  //默认迟到最大15分钟
  def lateMax: Int = Numbers.toInt(properties.get("lateMax").getOrElse("15"))

  def courseURL: String = properties("courseURL")

  def descSecretKey: String = properties("desc_secret_key")

  private def loadProperties(in: InputStream): java.util.Properties = {
    val props = new java.util.Properties
    props.load(in)
    in.close()
    props
  }

}