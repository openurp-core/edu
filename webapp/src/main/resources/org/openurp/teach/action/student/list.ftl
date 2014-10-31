[#ftl]
[@b.head/]
[@b.grid items=students var="student"]
  [@b.gridbar]
    bar.addItem("${b.text("action.new")}",action.add());
    bar.addItem("${b.text("action.modify")}",action.edit());
    bar.addItem("${b.text("action.delete")}",action.remove("确认删除?"));
  [/@]
  [@b.row]
    [@b.boxcol /]
    [@b.col width="15%" property="code" title="学号"]${student.code}[/@]
    [@b.col width="20%" property="name" title="姓名"][@b.a href="!info?id=${student.id}"]${student.name}[/@][/@]
    [@b.col width="15%" property="grade" title="年级"]${student.grade!}[/@]
    [@b.col width="15%" property="major" title="专业"]${student.major.name!}[/@]
    [@b.col width="10%" property="department" title="行政管理院系"]${student.department.name!}[/@]
    [@b.col width="10%" property="gender" title="性别"]${student.gender.name!}[/@]
  [/@]
[/@]
[@b.foot/]
