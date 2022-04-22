<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">

<ul>
    <#list users as user>
        <li>
	    <p> ${user.getId()} - ${user.getFirstName()} ${user.getLastName()} </p>
	    	<ul>
		   <li>
			<p> Username : ${user.getUsername()} </p>
		   </li>
		   <li>
			<p> Password : ${user.getPassword()} </p>
		   </li>
		   <li>
			<p> Statut : ${user.getStatut()} </p>
		   </li>
		</ul>
	</li>
    </#list>
</ul>

</body>

</html>
