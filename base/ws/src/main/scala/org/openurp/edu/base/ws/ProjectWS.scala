package org.openurp.edu.base.ws

import org.openurp.edu.base.model.Project
import org.openurp.edu.base.model.{ ProjectClassroom, ProjectCode }
import org.beangle.webmvc.entity.action.RestfulService

class ProjectWS extends RestfulService[Project]

class ProjectClassroomWS extends ProjectRestfulService[ProjectClassroom]

class ProjectCodeWS extends ProjectRestfulService[ProjectCode]
