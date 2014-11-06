package org.openurp.teach.domain

import org.beangle.data.model.bean.LongIdBean

class ExamScheduleBean extends ExamSchedule with LongIdBean {

  /** 具体排考结果 */
  var activities: collection.mutable.Set[ExamActivity] = _

  /** 考试类型 */
  var examTypes: collection.mutable.Set[ExamType] = _
  
//  fix me 
//  public List<Classroom> getExamRooms(ExamBatch examBatch) {

  /**
   * 返回主考老师
   */
//  fix me
//  public List<Teacher> getExaminers(ExamBatch examBatch) {

/**
   * @return Returns the activities.
   */
//  fix me
//  public ExamActivity getActivity(ExamBatch examBatch) {

  //  fix me
//  public ExamSchedule clone() {
}