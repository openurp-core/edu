[#ftl]
[@b.head/]
[@b.grid items=projectConfigs var="projectConfig"]
  [@b.gridbar]
    bar.addItem("${b.text("action.new")}",action.add());
    bar.addItem("${b.text("action.modify")}",action.edit());
    bar.addItem("${b.text("action.delete")}",action.remove("确认删除?"));
  [/@]
  [@b.row]
    [@b.boxcol /]
    [@b.col width="15%" property="name" title="项目名称"]${projectConfig.project.name!}[/@]
    [@b.col width="20%" property="meta" title="代码元"]${projectConfig.meta.name!}[/@]
    [@b.col width="20%" property="codeId" title="代码Id"]${projectConfig.codeId!}[/@]
  [/@]
[/@]
[@b.foot/]
