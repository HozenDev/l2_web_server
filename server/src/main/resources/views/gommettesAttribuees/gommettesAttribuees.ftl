<#ftl encoding="utf-8">
<head>
  <style type="text/css">  
  <#include "../style/reset.css">
  </style>
</head>
<body xmlns="http://www.w3.org/1999/html">
<ul>
    <#list gommettesAttribuees as gommetteAttribuee>
        <li>${gommetteAttribuee.toString()}</li>
    </#list>
</ul>
</body>
</html>