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
package org.openurp.edu.attendance.ws.web

import java.util.EnumSet
import org.beangle.commons.lang.Strings.replace
import org.beangle.commons.web.filter.CharacterEncodingFilter
import org.beangle.commons.web.servlet.DelegatingServletProxy
import org.beangle.spring.web.ContextListener
import javax.servlet.{ ServletContext, ServletException }
import javax.servlet.DispatcherType.REQUEST
import javax.servlet.ServletException
import org.beangle.commons.web.servlet.DelegatingServletProxy
import org.beangle.spring.web.ContextListener
import javax.servlet.ServletException
import org.beangle.commons.web.servlet.DelegatingServletProxy
import org.beangle.spring.web.ContextListener
import javax.servlet.ServletException
import org.beangle.commons.web.servlet.DelegatingServletProxy
import org.beangle.spring.web.ContextListener
import org.openurp.edu.attendance.ws.web.app.SyncServlet
import org.openurp.edu.attendance.ws.web.app.DeviceServlet
import org.openurp.edu.attendance.ws.web.app.ImporterServlet
import org.openurp.edu.attendance.ws.web.app.CourseTableServlet
import org.openurp.edu.attendance.ws.impl.ActivityService
import org.openurp.edu.attendance.ws.web.app.ActivityServlet
import org.openurp.edu.attendance.ws.web.app.NoticeServlet
import org.openurp.edu.attendance.ws.web.app.RateServlet
import org.openurp.edu.attendance.ws.web.app.SigninServlet
import org.openurp.edu.attendance.ws.web.app.DetailServlet
import org.openurp.edu.attendance.ws.web.app.UploadServlet
/**
 * 符合Servlet3规范的web初始化
 *
 * @author chaostone
 * @version 1.0, 2014/03/22
 * @since 0.0.1
 */
class Initializer extends org.beangle.commons.web.init.Initializer {

  @throws(classOf[ServletException])
  def onStartup(sc: ServletContext) {
    addServlet(sc, "/app/sync",classOf[SyncServlet])
    addServlet(sc, "/app/device",classOf[DeviceServlet])
    addServlet(sc, "/app/activity",classOf[ActivityServlet])
    addServlet(sc, "/app/coursetable",classOf[CourseTableServlet])
    addServlet(sc, "/app/rate",classOf[RateServlet])
    addServlet(sc, "/app/signin",classOf[SigninServlet])
    addServlet(sc, "/app/upload",classOf[UploadServlet])
    addServlet(sc, "/app/detail",classOf[DetailServlet])
    addServlet(sc, "/app/notice",classOf[NoticeServlet])
    addServlet(sc, "/app/importer",classOf[ImporterServlet])
  }

  private def addServlet(sc: ServletContext, mapping: String,clazz:Class[_]) {
    val prefix = "/teach/attendance"
    sc.addServlet(clazz.getName, classOf[DelegatingServletProxy]).addMapping(prefix + mapping)
  }
}