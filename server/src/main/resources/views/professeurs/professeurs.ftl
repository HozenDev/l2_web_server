<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">

<ul>
    <#list professeurs as professeur>
        <li> ID:${professeur.getId()} | ${professeur.getFirstName()} ${professeur.getLastName()}</li>
	<ul>
	    <#list professeur.getAllGommettes() as p_lg>
		<li> ${p_lg} </li>
	    </#list>
	</ul>
    </#list>
</ul>

</body>

</html>