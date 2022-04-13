<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">

<ul>
    <#list professeurs as professeur>
        <li>${professeur.id} - ${professeur.firstName} ${professeur.lastName} ${professeur.strListGommette}</li>
    </#list>
</ul>

</body>

</html>