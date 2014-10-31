[#ftl]
[@b.head/]
[@b.toolbar title="学籍状态日志"/]
<table class="indexpanel">
  <tr>
    <td class="index_view">
    [@b.form name="studentJournalSearchForm" action="!search" target="studentJournallist" title="ui.searchForm" theme="search"]
      [@b.textfields names="studentJournal.id;id"/]
      [@b.textfields names="studentJournal.major.name;专业"/]
      <input type="hidden" name="orderBy" value="studentJournal.id"/>
    [/@]
    </td>
    <td class="index_content">[@b.div id="studentJournallist" href="!search?orderBy=studentJournal.id"/]
    </td>
  </tr>
</table>
[@b.foot/]