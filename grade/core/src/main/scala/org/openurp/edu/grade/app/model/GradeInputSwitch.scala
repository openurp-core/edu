package org.openurp.edu.grade.app.model

import org.beangle.data.model.LongId
import org.beangle.data.model.TemporalAt
import org.openurp.edu.base.model.Project
import org.openurp.base.model.Semester
import org.beangle.data.model.TemporalAt
import org.openurp.edu.base.model.Project
import org.openurp.base.model.Semester
import org.openurp.edu.grade.code.model.GradeType
import org.beangle.commons.collection.Collections

class GradeInputSwitch extends LongId with TemporalAt {

  var project: Project = _

  var semester: Semester = _

  var types = Collections.newSet[GradeType]

  var opened: Boolean = _
}