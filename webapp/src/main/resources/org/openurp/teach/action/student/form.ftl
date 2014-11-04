[#ftl]
[@b.head/]
[@b.toolbar title="修改学籍信息"]bar.addBack();[/@]
[@b.tabs]
  [@b.tab label="基本信息"]
  [@b.form action="!update?id=${student.id}" theme="list"]
    [@b.textfield name="student.code" label="学号" value="${student.code!}" required="true" maxlength="20"/]
    [@b.textfield name="student.name" label="姓名" value="${student.name!}" required="true" maxlength="20"/]
    [@b.textfield name="student.engName" label="英文名" value="${student.engName!}" maxlength="100"/]
    [@b.select name="student.gender.id" label="性别" value="${(student.gender.id)!}" required="true"
    	         style="width:200px;" items=genders option="id,name" empty="..."/]
    [@b.textfield name="student.grade" label="年级" value="${student.grade!}" required="true" /]    
    [@b.select name="student.department.id" label="行政管理院系" value="${(student.department.id)!}" required="true" 
               style="width:200px;" items=departments option="id,name" empty="..."/]    
    [@b.select name="student.major.id" label="专业" value="${(student.major.id)!}" required="true" 
               style="width:200px;" items=majors option="id,name" empty="..."/]    
    [@b.select name="student.direction.id" label="专业方向" value="${(student.direction.id)!}" required="true" 
               style="width:200px;" items=directions option="id,name" empty="..."/]    
    [@b.select name="student.majorDepart.id" label="专业所在院系" value="${(student.majorDepart.id)!}" required="true" 
               style="width:200px;" items=majorDeparts option="id,name" empty="..."/]
    [@b.select name="student.type1.id" label="学生类别" value="${(student.type1.id)!}" required="true" 
               style="width:200px;" items=type1s option="id,name" empty="..."/]
    [@b.select name="student.campus.id" label="校区" value="${(student.campus.id)!}" required="true" 
               style="width:200px;" items=campuse option="id,name" empty="..."/]
    [@b.textfield name="student.duration" label="学制" value="${student.duration!}" required="true" /]
    [@b.radios label="是否有学籍"  name="student.registed" value=student.registed items="1:common.yes,0:common.no"/]
    [@b.textfield name="student.enrollOn" label="入学报到日期" value="${student.enrollOn!}"/]
    [@b.textfield name="student.registOn" label="学籍生效日期" value="${student.registOn!}"/]
    [@b.textfield name="student.graduateOn" label="预计毕业日期" value="${student.graduateOn!}"/]
    [@b.textfield name="student.remark" label="备注" value="${student.remark!}"/]    
    [@b.select name="student.adminclass.id" label="行政班级" value="${(student.adminclass.id)!}" required="true" 
               style="width:200px;" items=adminclasses option="id,name" empty="..."/]
    [@b.select name="student.person.id" label="基本信息" value="${(student.person.id)!}" required="true" 
               style="width:200px;" items=persons option="id,name" empty="..."/]    
    [@b.select name="student.studyType.id" label="学习形式" value="${(student.studyType.id)!}" required="true" 
               style="width:200px;" items=studyTypes option="id,name" empty="..."/]    
    [@b.select name="student.tutor.id" label="导师" value="${(student.tutor.id)!}" required="true" 
               style="width:200px;" items=tutors option="id,name" empty="..."/]
    [@b.formfoot]
      [@b.reset/]&nbsp;&nbsp;[@b.submit value="action.submit"/]
  [/@]
[/@]
[/@]
  [#if student.id??]
  [@b.tab label="建设过程"]
  [@b.div href="student-journal!search?studentJournal.student.id=${student.id}"/]
    [/@]
  [/#if]
[/@]
[@b.foot/]