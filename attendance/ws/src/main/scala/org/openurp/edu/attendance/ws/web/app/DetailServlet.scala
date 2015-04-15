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
package org.openurp.edu.attendance.ws.web.app

import java.{ util => ju }
import java.sql.Date
import org.beangle.commons.lang.Dates.{ today, now, join }
import org.beangle.commons.logging.Logging
import org.beangle.data.jdbc.query.JdbcExecutor
import org.openurp.edu.attendance.ws.domain.ShardPolicy._
import org.openurp.edu.attendance.ws.impl.{ ActivityService, DeviceRegistry }
import org.openurp.edu.attendance.ws.web.util.Consts.{ DeviceId, SigninDate, SigninTime, Rule }
import org.openurp.edu.attendance.ws.domain.DateFormats.{ toCourseTime, toDateStr, toTimeStr }
import org.openurp.edu.attendance.ws.web.util.Params
import org.openurp.edu.attendance.ws.web.util.Render.render
import com.google.gson.{ JsonArray, JsonObject }
import javax.servlet.{ ServletRequest, ServletResponse }
import javax.servlet.http.HttpServlet
import java.sql.Time
import java.{util => ju}
import java.{util => ju}

/**
 * 本次考勤的出勤明细
 *
 * @author chaostone
 * @version 1.0, 2014/03/22
 * @since 0.0.1
 */
class DetailServlet extends HttpServlet with Logging {
  var deviceRegistry: DeviceRegistry = _
  var activityService: ActivityService = _
  var jdbcExecutor: JdbcExecutor = _

  override def service(req: ServletRequest, res: ServletResponse) {
    var retcode, devid = 0
    var retmsg, classname = ""
    val json = new JsonObject()
    val array = new JsonArray()

    val params = Params.require(DeviceId).optional(SigninDate, SigninTime).get(req, Rule)
    if (!params.ok) {
      retmsg = params.msg.values.mkString(";")
      retcode = -1
    } else {
      devid = params(DeviceId)
      deviceRegistry.get(devid) foreach { device =>
        val signinDate: Date = params.get(SigninDate).getOrElse(today)
        val signinTime: Time = params.get(SigninTime).getOrElse(new Time(now.getTime))
        val activity = activityService.getActivity(device.room, join(signinDate, signinTime))
        activity.foreach { l => classname = l.className }
        val datas = jdbcExecutor.query("select xs.xh,xs.xm,d.signin_at from " + detailTable(signinDate) + " d,xsxx_t xs," + activityTable(signinDate) + " aa where " +
          " aa.room_id=? and aa.course_date = ?" +
          " and ? between aa.attend_begin_time and aa.end_time and xs.id=d.std_id and aa.id=d.activity_id order by d.signin_at desc", device.room.id, signinDate, toCourseTime(signinTime))
        datas foreach { data =>
          val attendJson = new JsonObject()
          attendJson.addProperty("stuempno", data(0).toString)
          attendJson.addProperty("custname", data(1).toString)
          val signinAt = data(2).asInstanceOf[ju.Date]
          if (null != signinAt) {
            attendJson.addProperty("signindate", toDateStr(signinAt))
            attendJson.addProperty("signintime", toTimeStr(signinAt))
          } else {
            attendJson.addProperty("signindate", "")
            attendJson.addProperty("signintime", "")
          }
          array.add(attendJson)
        }
      }
    }
    json.addProperty("retcode", retcode)
    json.addProperty("retmsg", retmsg)
    json.addProperty("devid", devid)
    json.addProperty("classname", classname)
    json.add("list", array)
    render(res, json)
  }

}