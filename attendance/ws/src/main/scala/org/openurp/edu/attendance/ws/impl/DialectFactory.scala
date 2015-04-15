package org.openurp.edu.attendance.ws.impl

import org.beangle.commons.bean.Factory
import javax.sql.DataSource

class DialectFactory(ds: DataSource) extends Factory[Dialect] {

  def result: Dialect = {
    val conn = ds.getConnection
    val db = conn.getMetaData.getDatabaseProductName.toLowerCase()
    if (db.contains("oracle")) new OracleDialect
    else new PostgreSQLDialect
  }

}