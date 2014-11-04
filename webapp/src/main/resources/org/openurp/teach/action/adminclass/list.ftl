[#ftl]
[@b.head/]
[@b.grid items=adminclasss var="adminclass"]
  [@b.gridbar]
    bar.addItem("${b.text("action.new")}",action.add());
    bar.addItem("${b.text("action.modify")}",action.edit());
    bar.addItem("${b.text("action.delete")}",action.remove("确认删除?"));
  [/@]
  [@b.row]
    [@b.boxcol /]
    [@b.col width="15%" property="code" title="代码"]${adminclass.code}[/@]
    [@b.col width="20%" property="name" title="名称"][@b.a href="!info?id=${adminclass.id}"]${adminclass.name}[/@][/@]
    [@b.col width="15%" property="abbreviation" title="简称"]${adminclass.abbreviation!}[/@]
    [@b.col width="20%" property="beginOn" title="生效时间"]${adminclass.beginOn!}[/@]
    [@b.col width="20%" property="endOn" title="失效时间"]${adminclass.endOn!}[/@]
  [/@]
[/@]
[@b.foot/]
