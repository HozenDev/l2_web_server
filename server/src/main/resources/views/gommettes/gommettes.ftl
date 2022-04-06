<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">

<ul>
    <#list gommettes as gommette>
        <li>${gommette.id} - ${gommette.color} ${gommette.description}</li>
    </#list>
</ul>

</body>

</html>