package org.openurp.edu.attendance.ws.impl

trait Dialect {

  def sqlFindTable(tableName: String): String
  def name: String
  def sqlNow: String
  def sqlNextVal(seq: String): String
}

class OracleDialect extends Dialect {

  def sqlFindTable(tableName: String): String = {
    "select count(*) from user_tables where table_name='" + tableName.toUpperCase() + "'"
  }
  def name: String = {
    "oracle"
  }
  def sqlNow: String = {
    "sysdate"
  }
  def sqlNextVal(seq: String): String = {
    seq + ".nextval"
  }
}

class PostgreSQLDialect extends Dialect {

  def sqlFindTable(tableName: String): String = {
    "select count(*) from information_schema.tables where table_name='" + tableName.toLowerCase() + "'"
  }
  def name: String = {
    "postgresql"
  }

  def sqlNow: String = {
    "current_timestamp"
  }
  def sqlNextVal(seq: String): String = {
    "nextval('" + seq + "')"
  }
}