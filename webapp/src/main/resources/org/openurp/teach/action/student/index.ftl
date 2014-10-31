[#ftl]
[@b.head/]
[@b.toolbar title="学籍信息"/]
<table class="indexpanel">
  <tr>
    <td class="index_view">
    [@b.form name="studentSearchForm" action="!search" target="studentlist" title="ui.searchForm" theme="search"]
      [@b.textfields names="student.code;代码"/]
      [@b.textfields names="student.name;名称"/]
      [@b.textfields names="student.major.name;专业"/]
      <input type="hidden" name="orderBy" value="student.name"/>
    [/@]
    </td>
    <td class="index_content">[@b.div id="studentlist" href="!search?orderBy=student.code"/]
    </td>
  </tr>
</table>
[@b.foot/]