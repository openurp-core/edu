package org.beangle.data.serialize

import org.beangle.data.serialize.marshal.{ Marshaller, MarshallerRegistry }
import org.beangle.data.serialize.io.StreamWriter
import org.beangle.data.serialize.mapper.Mapper
import org.beangle.data.serialize.marshal.{ Marshaller, MarshallingContext }
import org.beangle.commons.conversion.ConverterRegistry
import org.beangle.data.serialize.io.StreamDriver
import java.io.StringWriter
import java.io.Writer
import java.io.OutputStream
import scala.collection.immutable.TreeMap
import org.beangle.data.serialize.marshal.Id
import org.beangle.commons.lang.Strings

abstract class AbstractSerializer extends StreamSerializer {

  def driver: StreamDriver
  def mapper: Mapper
  def registry: MarshallerRegistry

  def alias(alias: String, clazz: Class[_]): Unit = {
    mapper.alias(alias, clazz)
  }

  def alias(alias: String, className: String): Unit = {
    mapper.alias(alias, className)
  }

  override def serialize(obj: AnyRef, out: OutputStream, params: Map[String, Any]): Unit = {
    val writer = driver.createWriter(out)
    try {
      serialize(obj, writer, params)
    } finally {
      writer.flush()
    }
  }

  def serialize(obj: Object): String = {
    val writer = new StringWriter()
    serialize(obj, writer, Map.empty[String, Any])
    writer.toString()
  }

  def serialize(obj: Object, params: Map[String, Any]): String = {
    val writer = new StringWriter()
    serialize(obj, writer, params)
    writer.toString()
  }

  def serialize(obj: Object, out: Writer, params: Map[String, Any]) {
    val writer = driver.createWriter(out)
    try {
      serialize(obj, writer, params)
    } finally {
      writer.flush()
    }
  }

  override def serialize(item: Object, writer: StreamWriter, params: Map[String, Any]): Unit = {
    val context = new MarshallingContext(this, writer, registry, params)
    writer.start(context)
    if (item == null) {
      writer.startNode(mapper.serializedClass(classOf[Null]), classOf[Null])
    } else {
      writer.startNode(mapper.serializedClass(item.getClass()), item.getClass())
      context.marshal(item, null)
    }
    writer.endNode()
    writer.end(context)
  }

  override def marshal(item: Object, marshaller: Marshaller[Object], context: MarshallingContext): Unit = {
    val writer = context.writer
    if (marshaller.targetType.scalar) {
      // strings, ints, dates, etc... don't bother using references.
      marshaller.marshal(item, writer, context)
    } else {
      if (context.currents.contains(item)) {
        val key = Strings.unCamel(item.getClass().getSimpleName) + "_" + System.identityHashCode(item)
        val attributeName = mapper.aliasForSystemAttribute("id")
        if (attributeName != null) context.writer.addAttribute(attributeName, key.toString())
      } else {
        context.currents .put( item,item)
        marshaller.marshal(item, writer, context)
        context.currents.remove(item)
      }
    }
  }

  override def marshalNull(obj: Object, property: String, context: MarshallingContext): Unit = {

  }

  override def hierarchical: Boolean = {
    true
  }
}
