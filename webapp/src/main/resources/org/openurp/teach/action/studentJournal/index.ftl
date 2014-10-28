[#ftl]
[@b.head/]
[@b.toolbar title="专业方向"/]
<table class="indexpanel">
  <tr>
    <td class="index_view">
    [@b.form name="studentJournalSearchForm" action="!search" target="studentJournallist" title="ui.searchForm" theme="search"]
      [@b.textfields names="studentJournal.code;代码"/]
      [@b.textfields names="studentJournal.name;名称"/]
      [@b.textfields names="studentJournal.major.name;专业"/]
      <input type="hidden" name="orderBy" value="studentJournal.name"/>
    [/@]
    </td>
    <td class="index_content">[@b.div id="studentJournallist" href="!search?orderBy=studentJournal.code"/]
    </td>
  </tr>
</table>
[@b.foot/]