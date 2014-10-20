package org.openurp.teach.ws

import org.beangle.webmvc.entity.action.RestfulService
import org.openurp.teach.Project
import org.openurp.teach.domain.{ProjectClassroomBean, ProjectCode}

class ProjectAction extends RestfulService[Project]

class ProjectClassroomAction extends RestfulService[ProjectClassroomBean]

class ProjectCodeAction extends RestfulService[ProjectCode]
