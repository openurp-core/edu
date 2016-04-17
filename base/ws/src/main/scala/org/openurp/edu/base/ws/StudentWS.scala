package org.openurp.edu.base.ws

import org.openurp.edu.base.model.{ Student, StudentState }
import org.beangle.data.jpa.dao.OqlBuilder
import org.beangle.webmvc.api.context.Params
import org.beangle.webmvc.entity.action.RestfulService
import org.openurp.base.model.Department
import org.beangle.data.model.Entity
import org.openurp.edu.base.model.Major
import org.openurp.edu.base.code.model.StdType
import org.openurp.edu.base.model.Adminclass
import org.beangle.webmvc.api.annotation.mapping
import org.beangle.webmvc.api.annotation.response
import org.beangle.webmvc.api.annotation.param
import org.openurp.code.person.model.Gender
import org.openurp.code.geo.model.Country
import org.openurp.code.person.model.Nation
import org.openurp.code.person.model.IdType
import org.openurp.people.base.model.Person

class StudentWS extends ProjectRestfulService[Student] {
  override def getQueryBuilder(): OqlBuilder[Student] = {
    put("properties", List(this.entityType -> List("id", "code", "person", "department", "stdType", "major", "adminclass"),
      classOf[Person] -> List("id", "name"), classOf[Department] -> List("id", "name"),
      classOf[StdType] -> List("id", "name"), classOf[Major] -> List("id", "name"),
      classOf[Adminclass] -> List("id", "name"), classOf[Entity[_]] -> List("id")))
    val query = super.getQueryBuilder()
    query
  }

  @response
  @mapping(value = "{id}")
  override def info(@param("id") id: String): Student = {
    put("properties", List(this.entityType -> List("id", "code", "person", "department", "stdType", "major", "adminclass"),
      classOf[Person] -> List("id", "name", "enName", "gender", "country", "nation", "birthday", "idType", "code"),
      classOf[Gender] -> List("id", "name"), classOf[Country] -> List("id", "name"),
      classOf[Nation] -> List("id", "name"), classOf[IdType] -> List("id", "name"),
      classOf[Department] -> List("id", "name"), classOf[StdType] -> List("id", "name"),
      classOf[Major] -> List("id", "name"), classOf[Adminclass] -> List("id", "name"),
      classOf[Entity[_]] -> List("id")))
    super.info(id)
  }
}

class StudentStateWS extends RestfulService[StudentState] {
  override def getQueryBuilder(): OqlBuilder[StudentState] = {
    super.getQueryBuilder().where(this.shortName + ".std.project.code = :project", Params.get("project").get)
  }

}

