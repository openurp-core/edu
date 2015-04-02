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

import java.util.Calendar
import org.beangle.commons.lang.Dates.join
import org.beangle.commons.lang.Strings.concat
import org.beangle.commons.lang.time.Stopwatch
import org.beangle.commons.logging.Logging
import org.openurp.edu.attendance.ws.impl.SigninService
import org.openurp.edu.attendance.ws.domain.SigninData
import org.openurp.edu.attendance.ws.web.util.{ JsonBuilder, Params }
import org.openurp.edu.attendance.ws.web.util.Consts.{ CardId, DeviceId, Rule, SigninDate, SigninTime }
import org.openurp.edu.attendance.ws.domain.DateFormats.{ toDateStr, toTimeStr }
import org.openurp.edu.attendance.ws.web.util.Render.render
import com.google.gson.JsonObject
import javax.servlet.{ ServletRequest, ServletResponse }
import javax.servlet.http.HttpServlet
/**
 * 刷卡签到服务
 *
 * @author chaostone
 * @version 1.0, 2014/03/22
 * @since 0.0.1
 */
class SigninServlet extends HttpServlet with Logging {
  var signinService: SigninService = _

  override def service(req: ServletRequest, res: ServletResponse) {
    val watch = new Stopwatch(true)
    var json: JsonObject = null
    val params = Params.require(DeviceId, CardId, SigninDate, SigninTime).get(req, Rule)
    if (!params.ok) {
      val signinAt = Calendar.getInstance
      val rs = new JsonBuilder
      rs.add("retcode", -1).add("retmsg", params.msg.values.mkString(";"))
      rs.add("classname", "").add("stuempno", "")
      rs.add("custname", "").add("signindate", toDateStr(signinAt.getTime))
      rs.add("signintime", toTimeStr(signinAt.getTime))
      json = rs.mkJson
    } else {
      val paramStr = concat("&", DeviceId, "=", req.getParameter(DeviceId), "&", CardId, "=", req.getParameter(CardId), "&", SigninDate, "=", req.getParameter(SigninDate), "&", SigninTime, "=", req.getParameter(SigninTime))
      json = signinService.signin(new SigninData(params(DeviceId), params(CardId), join(params(SigninDate), params(SigninTime)), paramStr))
    }
    render(res, json)
    if (watch.elapsedMillis > 50) logger.warn(s"signin ${params.get(CardId).orNull} at ${params.get(DeviceId).orNull} using ${watch}")
  }

}