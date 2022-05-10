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
	        <h1> Liste des gommettes </h1>
	    </li>
	    <#list gommettes as gommette>
	    <li class="gommette">
	       <h3>${gommette.getColor()}: ${gommette.getDescription()}</h3>
	       <#if (userLog)!false>
		 <a href="/gommettes/modify/${gommette.getId()}"> Modifier </a>
		 <a href="/gommettes/delete/${gommette.getId()}"> Supprimer </a>
	       </#if>
	    </li>
	    </#list>
	 </ul>
      </div>
</body>
</html>
