package org.openurp.edu.base.ws

import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.webmvc.api.context.Params
import org.beangle.webmvc.entity.action.RestfulService
import org.beangle.webmvc.api.annotation.mapping
import org.openurp.edu.base.model.StudentBean
import org.beangle.webmvc.api.annotation.response
import org.beangle.webmvc.api.annotation.param
import org.beangle.data.model.Entity
import org.openurp.edu.base.Student

class StudentWS extends AbstractWS[Student]