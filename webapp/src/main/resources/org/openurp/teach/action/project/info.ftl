[#ftl]
[@b.head/]
[@b.toolbar title="项目信息"]
  bar.addBack("${b.text("action.back")}");
[/@]
<table class="infoTable">
  <tr>
    <td class="title" width="20%">代码</td>
    <td class="content">${project.code}</td>
  </tr>
  <tr>
    <td class="title" width="20%">名称</td>
    <td class="content">${project.name}</td>
  </tr>
  <tr>
    <td class="title" width="20%">英文名</td>
    <td class="content">${project.enName!}</td>
  </tr>
  <tr>
    <td class="title" width="20%">生效时间</td>
    <td class="content" >${project.beginOn!}</td>
  </tr>
  <tr>
    <td class="title" width="20%">失效时间</td>
    <td class="content" >${project.endOn!}</td>
  </tr>
  <tr>
    <td class="title" width="20%">备注</td>
    <td class="content">${project.remark!}</td>
  </tr>
</table>

[@b.foot/]