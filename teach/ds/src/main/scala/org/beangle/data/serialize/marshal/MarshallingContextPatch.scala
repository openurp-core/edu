package org.beangle.data.serialize.marshal

import scala.collection.mutable
import scala.language.existentials

import org.beangle.commons.collection.IdentityCache
import org.beangle.commons.lang.reflect.BeanManifest
import org.beangle.data.serialize.StreamSerializer
import org.beangle.data.serialize.io.{ Path, StreamWriter }

class MarshallingContext(val serializer: StreamSerializer, val writer: StreamWriter, val registry: MarshallerRegistry, val params: Map[String, Any]) {

  val references = new IdentityCache[AnyRef, Id]

  val currents = new collection.mutable.HashSet[Any]

  var beanType: Class[_] = _

  val propertyMap = new collection.mutable.HashMap[Class[_], List[String]]

  init()

  def init(): Unit = {
    val properties = params.get("properties").getOrElse(List.empty).asInstanceOf[Seq[Tuple2[Class[_], List[String]]]]
    if (serializer.hierarchical) {
      propertyMap ++= properties
    } else {
      properties foreach { tuple =>
        val getters = BeanManifest.get(tuple._1).getters
        val filted = new collection.mutable.ListBuffer[String]
        tuple._2 foreach { p =>
          getters.get(p) match {
            case Some(getter) => if (!isCollectionType(getter.returnType)) filted += p
            case None => throw new RuntimeException("cannot find property $p of class ${tuple2._1.getName}")
          }
        }
        propertyMap.put(tuple._1, filted.toList)
      }
    }
    params.get("elementType") match {
      case Some(cls) =>
        beanType = cls.asInstanceOf[Class[_]]
        //search bean type (interface first)
        getProperties(beanType)
      case None =>
    }
    if (!properties.isEmpty && null == beanType) beanType = properties.head._1
  }

  def getProperties(clazz: Class[_]): List[String] = {
    val result = propertyMap.get(clazz) match {
      case Some(p) => p
      case None => {
        if (registry.lookup(clazz).targetType == Type.Object) {
          val p = searchProperties(clazz)
          if (null == p) {
            val bp =
              if (BeanManifest.get(clazz).getters.contains("id") && null != beanType && beanType != clazz) {
                List("id")
              } else {
                if (serializer.hierarchical) {
                  BeanManifest.get(clazz).getters.filter(!_._2.isTransient).keySet.toList
                } else {
                  BeanManifest.get(clazz).getters.filter { g => !g._2.isTransient && !isCollectionType(g._2.returnType) }.keySet.toList
                }
              }
            propertyMap.put(clazz, bp)
            bp
          } else {
            p
          }
        } else {
          List()
        }
      }
    }
    if (beanType == null && !isCollectionType(clazz)) beanType = clazz
    result
  }

  private def searchProperties(targetType: Class[_]): List[String] = {
    val interfaces = new mutable.LinkedHashSet[Class[_]]
    val classQueue = new mutable.Queue[Class[_]]
    classQueue += targetType
    while (!classQueue.isEmpty) {
      val currentClass = classQueue.dequeue
      val props = propertyMap.get(currentClass).orNull
      if (props != null) return props
      val superClass = currentClass.getSuperclass
      if (superClass != null && superClass != classOf[AnyRef]) classQueue += superClass
      for (interfaceType <- currentClass.getInterfaces) addInterfaces(interfaceType, interfaces)
    }
    var iter = interfaces.iterator
    while (iter.hasNext) {
      val interfaceType = iter.next
      val props = propertyMap.get(interfaceType).orNull
      if (props != null) return props
    }
    null
  }

  private def addInterfaces(interfaceType: Class[_], interfaces: mutable.Set[Class[_]]) {
    interfaces.add(interfaceType)
    for (inheritedInterface <- interfaceType.getInterfaces) addInterfaces(inheritedInterface, interfaces)
  }

  def marshal(item: Object, marshaller: Marshaller[Object] = null): Unit = {
    if (marshaller == null) {
      serializer.marshal(item, registry.lookup(item.getClass.asInstanceOf[Class[Object]]), this)
    } else {
      serializer.marshal(item, marshaller, this)
    }
  }

  def marshalNull(item: Object, property: String): Unit = {
    serializer.marshalNull(item, property, this)
  }

  def lookupReference(item: Object): Id = {
    references.get(item)
  }

  private def isCollectionType(clazz: Class[_]): Boolean = {
    clazz.isArray() || classOf[java.util.Collection[_]].isAssignableFrom(clazz) || classOf[Iterable[_]].isAssignableFrom(clazz)
  }

}

class Id(val key: AnyRef, val path: Path) {
  override def toString: String = {
    path.toString()
  }
}