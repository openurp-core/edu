[#ftl]
[@b.head/]
[@b.toolbar title="项目配置属性"/]
<table class="indexpanel">
  <tr>
    <td class="index_view">
    [@b.form name="projectPropertySearchForm" action="!search" target="projectPropertylist" title="ui.searchForm" theme="search"]
      
      [@b.textfields names="projectProperty.name;名称"/]
      <input type="hidden" name="orderBy" value="projectProperty.name"/>
    [/@]
    </td>
    <td class="index_content">[@b.div id="projectPropertylist" href="!search?orderBy=projectProperty.id"/]
    </td>
  </tr>
</table>
[@b.foot/]