package org.openurp.edu.base.ws

import org.openurp.code.BaseCode
import org.beangle.webmvc.entity.action.AbstractEntityAction
import org.beangle.webmvc.api.annotation.mapping
import org.beangle.webmvc.api.annotation.response
import org.beangle.webmvc.api.annotation.param
import org.beangle.data.model.Entity
import org.beangle.webmvc.entity.helper.PopulateHelper
import org.beangle.commons.conversion.impl.DefaultConversion
import org.beangle.commons.bean.PropertyUtils
import org.beangle.data.model.meta.Type
import org.beangle.webmvc.api.action.ActionSupport
import org.beangle.webmvc.api.annotation.response
import scala.collection.mutable.ListBuffer
import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.JSON
import org.beangle.data.model.dao.EntityDao
import org.beangle.data.model.Entity
import org.beangle.commons.bean.PropertyUtils
import org.beangle.commons.conversion.impl.DefaultConversion
import org.beangle.webmvc.entity.helper.PopulateHelper
import org.beangle.data.model.meta.Type
import com.sun.org.apache.bcel.internal.util.ClassLoader
import org.beangle.commons.lang.ClassLoaders
import org.beangle.webmvc.api.context.Params
import org.beangle.data.jpa.dao.OqlBuilder

class AbstractWS[T <: Entity[_ <: java.io.Serializable]] extends AbstractEntityAction[T] {
  

  @response
  @mapping(value = "{id}")
  def info(@param("id") id: String): T = {
    Params.converter.convert(id, entityMetaData.getType(entityName).get.idType) match {
      case None => null.asInstanceOf[T]
      case Some(entityId) => getModel[T](entityName, entityId)
    }
  }
  
  @response
  def index(): Any = {
    getInt("pageIndex") match {
      case Some(p) => entityDao.search(getQueryBuilder())
      case None => entityDao.search(getQueryBuilder().limit(null))
    }
  }
  
  override def getQueryBuilder(): OqlBuilder[T] = {
    put("elementType", this.entityType)
    val query = super.getQueryBuilder().where(this.shortName + ".project.code = :project", Params.get("project").get)
    val select = get("select")
    if (select.isDefined){
      query.select(select.get)
    }
    query
  }
  
  @mapping(method = "post")
  @response
  def save(): Any = {
    val ar = new ActionResult
    try {
      val data = get("data")
      val clazz = ClassLoaders.loadClass(entityName, this.getClass().getClassLoader())
      val nation = getBean(clazz.asInstanceOf[Class[Entity[java.io.Serializable]]], data.get);
      saveOrUpdate(nation)
      ar.status = ActionResult.SUCCESS
    } catch {
      case t => 
        t.printStackTrace();
        ar.status = ActionResult.ERROR
    }
    ar
  }
  
  @mapping(value = "{id}", method = "put")
  @response
  def update(@param("id") id: String): Any = {
    save()
  }
  @mapping(method = "delete")
  @response
  def remove(): Any = {
    val ar = new ActionResult
    try {
      val idclass = entityMetaData.getType(entityName).get.idType
      val entityId = getId(shortName, idclass)
      val entities: Seq[T] =
        if (null == entityId) getModels(entityName, getIds(shortName, idclass))
        else List(getModel(entityName, entityId))
      remove(entities)
      ar.status = ActionResult.SUCCESS
    } catch {
      case t => ar.status = ActionResult.ERROR
    }
    ar
  }

  def getBean(clazz:Class[Entity[java.io.Serializable]], jsonStr:String):Entity[java.io.Serializable] = {
    val classType = PopulateHelper.getType(clazz)
    val idType = classType.idType
    val conversion = DefaultConversion.Instance
    val data = JSON.parseObject(jsonStr)
    val bean = if(data.get("id") == null) clazz.newInstance() else {
      val id = conversion.convert(data.get("id"), idType).asInstanceOf[java.io.Serializable]
//      val id = data.get("id").asInstanceOf[java.io.Serializable]
      entityDao.get(clazz, id)
    }
    populate(bean, classType, data, conversion)
    bean
  }

  private def populate(obj: Object, objType: Type, data: JSONObject, conversion: DefaultConversion) {
    for (key <- collection.JavaConversions.asScalaSet(data.keySet)) {
      val ptype = objType.getPropertyType(key).orNull
      if (ptype != null) {
        val value = data.get(key);
        if (value.isInstanceOf[JSONObject]) {
          val json = value.asInstanceOf[JSONObject]
          if (json.keySet().size() > 0) {
            val property = {
              val p = PropertyUtils.getProperty[Object](obj, key)
              if (p == null) {
                if (json.containsKey("id")) {
                  val id = conversion.convert(data.get("id"), ptype.returnedClass).asInstanceOf[java.io.Serializable]
                  entityDao.get(ptype.returnedClass.asInstanceOf[Class[Entity[java.io.Serializable]]], id)
                } else ptype.newInstance
              } else p
            }
            if (property != null) {
              PropertyUtils.setProperty(obj, key, property)
              populate(property.asInstanceOf[Object], ptype, json, conversion)
            }
          }
        } else {
          try {
            PropertyUtils.copyProperty(obj, key, value, conversion)
          } catch {
            case t: Throwable => logger.warn(key + " can't copied.")
          }
        }
      }
    }
  }

}
object ActionResult {
  val ERROR = "error"
  val SUCCESS = "success"
}

class ActionResult {

  var status: String = _
  var msg: String = _
}