<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">

<ul>
    <#list gommettesAttribuees as gommetteAttribuee>
        <li>${gommetteAttribuee.id} - ${gommetteAttribuee.idStudent} ${gommetteAttribuee.idGommette}  ${gommetteAttribuee.date} ${gommetteAttribuee.behavior} </li>
    </#list>
</ul>

</body>

</html>