<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">

<ul>
    <li> ID:${eleve.id} | ${eleve.lastName} ${eleve.firstName} </li>
	<ul>
	    <#list eleve.getAllGommettes() as e_lg>
	    	   <li> ${e_lg.toString()} </li>
	    </#list>
	</ul>
</ul>

</body>

</html>