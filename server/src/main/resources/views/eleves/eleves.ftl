<#import "../macros/navheader.ftl" as nh>
<!DOCTYPE html>
<head>
<link rel='stylesheet' href='/reset.css'>
<link rel='stylesheet' href='/ent.css'>
<link rel='stylesheet' href='/header.css'>
</head>
<body>
      <@nh.navheadbar userIsLog=(userLog)!true id="${userId}"/>
      <div class="info">
         <ul>
	    <li>
	        <h1> Liste des élèves </h1>
	    </li>
	    <#list eleves as eleve>
	    <li class="list">
	    	  <div class="list_head">
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
		    <#list eleve.getAllGommettes() as g>
	    	      <li>
		        <p class="g_btn ${g.getColor()}"> </p>
			<p>
			  (${g.getColor()}) - ${g.getDate()} | ${g.getProfNames()}: ${g.getBehavior()}
			</p>
			<#if (userLog)!false>
			<a href="/gommettes/attribuees/delete/${g.getId()}"> Supprimer </a>
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
