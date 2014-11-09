package org.openurp.teach.ws.core

import org.beangle.webmvc.entity.action.RestfulService
import org.openurp.teach.core.Project
import org.openurp.teach.core.model.{ ProjectClassroomBean, ProjectCodeBean }

class ProjectAction extends RestfulService[Project]

class ProjectClassroomAction extends RestfulService[ProjectClassroomBean]

class ProjectCodeAction extends RestfulService[ProjectCodeBean]
