[#ftl]
[@b.head/]
[@b.toolbar title="项目配置属性信息"]
  bar.addBack("${b.text("action.back")}");
[/@]
<table class="infoTable">
   <tr>
    <td class="title" width="20%">名称</td>
    <td class="content">${projectProperty.name!}</td>
  </tr>
  <tr>
    <td class="title" width="20%">值</td>
    <td class="content">${projectProperty.value!}</td>
  </tr>
</table>

[@b.foot/]