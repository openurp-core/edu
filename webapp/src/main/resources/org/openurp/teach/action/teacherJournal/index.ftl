[#ftl]
[@b.head/]
[@b.toolbar title="专业方向"/]
<table class="indexpanel">
  <tr>
    <td class="index_view">
    [@b.form name="teacherJournalSearchForm" action="!search" target="teacherJournallist" title="ui.searchForm" theme="search"]
      [@b.textfields names="teacherJournal.code;代码"/]
      [@b.textfields names="teacherJournal.name;名称"/]
      [@b.textfields names="teacherJournal.major.name;专业"/]
      <input type="hidden" name="orderBy" value="teacherJournal.name"/>
    [/@]
    </td>
    <td class="index_content">[@b.div id="teacherJournallist" href="!search?orderBy=teacherJournal.code"/]
    </td>
  </tr>
</table>
[@b.foot/]