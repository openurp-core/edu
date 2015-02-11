package org.openurp.edu.base.ds

import org.openurp.edu.base.Project
import org.openurp.edu.base.model.{ ProjectClassroomBean, ProjectCodeBean }
import org.beangle.webmvc.entity.action.RestfulService

class ProjectWS extends RestfulService[Project]

class ProjectClassroomWS extends ProjectRestfulService[ProjectClassroomBean]

class ProjectCodeWS extends ProjectRestfulService[ProjectCodeBean]
