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
import org.openurp.base.Department
import org.openurp.edu.base.Adminclass
import org.openurp.code.geo.Country
import org.openurp.edu.base.code.StdType
import org.openurp.code.person.Nation
import org.openurp.edu.base.Major
import org.openurp.people.base.Person
import org.openurp.code.person.Gender
import org.openurp.code.person.IdType

class StudentWS extends AbstractWS[Student] {
  
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