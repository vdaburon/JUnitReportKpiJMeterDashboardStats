<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta content="text/html; charset=utf-8">
  <title>HTML KPIs Result From Dashboard Statistics</title>
  </head>
  <body>
<style>
table.table_jp4 {border-collapse: collapse;}
table.table_jp4, table.table_jp4 th, table.table_jp4 tr, table.table_jp4 td {
border: 1px solid black;
text-align: left;
font-family: sans-serif;
font-size:medium; }
table.table_jp4 th:{background-color: #f8f8f8;}
table.table_jp4 tr:nth-child(even) {background-color: #f2f2f2;}
table.table_jp4 td:nth-child(5) { text-align: right; }
</style>
<h1>HTML KPIs Result From Dashboard Statistics</h1>
<h2>Files In<h2>
<table class="table_jp4">
  <tr><td>File with KPIs</td><td>${globalResult.kpiFile}</td></tr>
  <tr><td>File JSON Stats</td><td>${globalResult.jsonJmeterStats}</td></tr>
  </table>
<br>
<h2>Test Summary</h2>
  <table class="table_jp4">
  <tr><td>Number of failed tests</td><td <#if (globalResult.numberFailed &gt; 0)>style="color:Red;bold"</#if>><b>${globalResult.numberFailed}</b></td></tr>
  <tr><td>Number of tests</td><td><b>${globalResult.numberOfKpis}</b></td></tr>
  </table>
<br>
<h2>Table KPIs Results<h2>
  <table class="table_jp4">
  <tr><th>name_kpi</th><th>metric_json_attribute</th><th>label_regex</th><th>comparator</th><th>threshold</th><th>result</th><th>fail_msg</th></tr>
  <#list globalResult.checkKpiResults as checkKpiResult>
    <tr>
        <td>${checkKpiResult.nameKpi}</td>
        <td>${checkKpiResult.metricJsonAttribute}</td>
        <td>${checkKpiResult.labelRegex}</td>
         <td>${checkKpiResult.comparator}</td>
         <td>${checkKpiResult.threshold}</td>
        <td><#if checkKpiResult.kpiFail>fail<#else>sucess</#if></td>
        <td><#if checkKpiResult.kpiFail>${checkKpiResult.failMessage}</#if></td>
    </tr>
  </#list>
  </table>  
  </body>
</html>
