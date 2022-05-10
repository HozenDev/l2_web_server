<#import "../macros/navheader.ftl" as nh>

<!DOCTYPE html>
<head>
  <style type="text/css">  
  <#include "../style/reset.css">
  <#include "../style/ent.css">
  <#include "../style/header.css">
  </style>
</head>
<body>
     <@nh.navheadbar userIsLog=(userLog)!true id="${professeur.getId()}"/>
     <div class="info">
         <ul>
	 <li>
      	   <h1> ${professeur.getLastName()} ${professeur.getFirstName()} </h1>
	   </li>
	   <li>
      	   <h2> Nom d'utilisateur : ${professeur.getUsername()} </h2>
	   <h2> Mot de Passe : ${professeur.getPassword()} </h2>
	   </li>
	 <li>
	   <a href="/eleves"> Attribuer une gommette </a>
	 </li>
	   <li>
	   <ul>
		<li id="list_of">
		<h3> Liste des gommettes attribuées par le professeur </h3>
		</li>
		<#list professeur.getAllGommettes() as p_lg>
      	   	       <li> ${p_lg} </li>
      	   	</#list>
     	</ul>
	</li>
	</ul>
	</div>
</body>

</html>
