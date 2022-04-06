<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">

<ul>
    <#list eleves as eleve>
        <li>${eleve.id} - ${eleve.lastname} ${eleve.firstname}  ${eleve.listGommettes} </li>
    </#list>
</ul>

</body>

</html>