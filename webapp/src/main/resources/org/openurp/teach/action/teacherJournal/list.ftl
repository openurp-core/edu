[#ftl]
[@b.head/]
[@b.grid items=teacherJournals var="teacherJournal"]
  [@b.gridbar]
    bar.addItem("${b.text("action.new")}",action.add());
    bar.addItem("${b.text("action.modify")}",action.edit());
    bar.addItem("${b.text("action.delete")}",action.remove("确认删除?"));
  [/@]
  [@b.row]
    [@b.boxcol /]
    [@b.col width="15%" property="code" title="代码"]${teacherJournal.code}[/@]
    [@b.col width="20%" property="name" title="名称"][@b.a href="!info?id=${teacherJournal.id}"]${teacherJournal.name}[/@][/@]
    [@b.col width="15%" property="engName" title="英文名"]${teacherJournal.engName!}[/@]
    [@b.col width="15%" property="major" title="专业"]${teacherJournal.major.name!}[/@]
    [@b.col width="10%" property="beginOn" title="生效时间"]${teacherJournal.beginOn!}[/@]
    [@b.col width="10%" property="endOn" title="失效时间"]${teacherJournal.endOn!}[/@]
  [/@]
[/@]
[@b.foot/]
