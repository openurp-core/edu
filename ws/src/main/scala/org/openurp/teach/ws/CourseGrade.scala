package org.openurp.teach.ws

import org.beangle.webmvc.entity.action.RestfulService
import org.openurp.teach.{Course, CourseGrade, CourseHour}

class CourseAction extends RestfulService[Course]

class CourseGradeAction extends RestfulService[CourseGrade]

class CourseHourAction extends RestfulService[CourseHour]