[#ftl]
[@b.head/]
[@b.toolbar title="教师日志信息"/]
<table class="indexpanel">
  <tr>
    <td class="index_view">
    [@b.form name="teacherJournalSearchForm" action="!search" target="teacherJournallist" title="ui.searchForm" theme="search"]
      [@b.textfields names="teacherJournal.id;id"/]
      <input type="hidden" name="orderBy" value="teacherJournal.id"/>
    [/@]
    </td>
    <td class="index_content">[@b.div id="teacherJournallist" href="!search?orderBy=teacherJournal.id"/]
    </td>
  </tr>
</table>
[@b.foot/]