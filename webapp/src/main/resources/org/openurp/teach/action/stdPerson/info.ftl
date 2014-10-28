[#ftl]
[@b.head/]
[@b.toolbar title="专业方向信息"]
  bar.addBack("${b.text("action.back")}");
[/@]
<table class="infoTable">
  <tr>
    <td class="title" width="20%">代码</td>
    <td class="content">${stdPerson.code}</td>
  </tr>
  <tr>
    <td class="title" width="20%">名称</td>
    <td class="content">${stdPerson.name}</td>
  </tr>
  <tr>
    <td class="title" width="20%">英文名</td>
    <td class="content">${stdPerson.enName!}</td>
  </tr>
  <tr>
    <td class="title" width="20%">生效时间</td>
    <td class="content" >${stdPerson.beginOn!}</td>
  </tr>
  <tr>
    <td class="title" width="20%">失效时间</td>
    <td class="content" >${stdPerson.endOn!}</td>
  </tr>
  <tr>
    <td class="title" width="20%">备注</td>
    <td class="content">${stdPerson.remark!}</td>
  </tr>
  <tr>
    <td class="title" width="20%">专业</td>
    <td class="content">${stdPerson.major.name!}</td>
  </tr>
</table>

[@b.foot/]