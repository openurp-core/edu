package org.openurp.teach.domain

import java.io.File
import java.util.Locale
import org.beangle.data.jpa.hibernate.tool.DdlGenerator
import org.hibernate.dialect.PostgreSQL82Dialect
import org.junit.runner.RunWith
import org.scalatest.{ FunSpec, Matchers }
import org.scalatest.junit.JUnitRunner
import org.beangle.commons.lang.ClassLoaders

@RunWith(classOf[JUnitRunner])
class TeachBaseOrmTest extends FunSpec with Matchers {
  describe("DDL generator") {
    it("generate") {
      println(ClassLoaders.getResource("org/openurp/teach/domain/code/nation.hbm.xml"))
      val generator = new DdlGenerator(new PostgreSQL82Dialect(), Locale.SIMPLIFIED_CHINESE)
      val dir = "/tmp"
      generator.gen(dir,"org.openurp.teach")
      for (fileName <- Array("/1-tables.sql", "/2-sequences.sql", "/3-comments.sql")) {
        val file = new File(dir + fileName)
        assert(file.exists())
        //file.delete()
      }
    }
  }
}