<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">

<ul>
    <#list eleves as eleve>   
    	<li> ID:${eleve.getId()} | ${eleve.getLastName()} ${eleve.getFirstName()} </li>
	<ul>
	    <#list eleve.getAllGommettes() as e_lg>
	    	   <li> ${e_lg.toString()} </li>
	    </#list>
	</ul>
    </#list>
</ul>

</body>

</html>