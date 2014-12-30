[#ftl]
[@b.head/]
[@b.toolbar title="新建外聘教师单位类别"]bar.addBack();[/@]
[@b.tabs]
  [@b.form action="!save" theme="list"]
    [@b.textfield name="teacherUnitType.code" label="代码" value="${teacherUnitType.code!}" required="true" maxlength="20"/]
    [@b.textfield name="teacherUnitType.name" label="名称" value="${teacherUnitType.name!}" required="true" maxlength="20"/]
    [@b.textfield name="teacherUnitType.enName" label="英文名" value="${teacherUnitType.enName!}" maxlength="100"/]
    [@b.startend label="生效失效时间" 
      name="teacherUnitType.beginOn,teacherUnitType.endOn" required="false,false" 
      start=teacherUnitType.beginOn end=teacherUnitType.endOn format="date"/]
    [@b.textfield name="teacherUnitType.remark" label="备注" value="${teacherUnitType.remark!}" maxlength="30"/]
    [@b.formfoot]
      [@b.reset/]&nbsp;&nbsp;[@b.submit value="action.submit"/]
    [/@]
  [/@]
[/@]
[@b.foot/]