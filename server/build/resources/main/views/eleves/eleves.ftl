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
      <@nh.navheadbar userIsLog=(userLog)!true id="${userId}"/>
      <div class="info">
         <ul>
	    <li>
	        <h1> Liste des élèves </h1>
	    </li>
	    <#list eleves as eleve>
	    <li class="eleve">
	    	  <div class="eleve_head">
		  <h2> ${eleve.getLastName()} ${eleve.getFirstName()} </h2>
		  <#if (userLog)!false>
	    	  <a href="/gommettes/attribuees/create/${eleve.getId()}">
	    	        Ajouter une gommette
	      	  </a>
		  <a href="/eleves/modify/${eleve.getId()}"> Modifier </a>
		  <a href="/eleves/delete/${eleve.getId()}"> Supprimer </a>
		  </#if>
	    	  <a href="/eleves/${eleve.getId()}"> Profil </a>
		  </div>
	    	  <ul>
		    <#list eleve.getAllGommettes() as eleve_g>
	    	      <li>
			<p> ${eleve_g} </p>
			<#if (userLog)!false>
			<a href="/gommettes/attribuees/delete/${eleve_g.getId()}"> Supprimer </a>
			</#if>
		      </li>
	    	    </#list>
	         </ul>
	    </li>
	    </#list>
	 </ul>
      </div>
</body>
</html>
