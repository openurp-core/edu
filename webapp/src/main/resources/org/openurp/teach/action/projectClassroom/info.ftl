[#ftl]
[@b.head/]
[@b.toolbar title="项目教室配置信息"]
  bar.addBack("${b.text("action.back")}");
[/@]
<table class="infoTable">
  <tr>
    <td class="title" width="20%">项目</td>
    <td class="content">${projectClassroom.project.name!}</td>
  </tr>
  <tr>
    <td class="title" width="20%">教室</td>
    <td class="content">${projectClassroom.room.name!}</td>
  </tr>
</table>

[@b.foot/]