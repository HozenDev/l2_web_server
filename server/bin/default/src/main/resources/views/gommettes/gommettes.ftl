<!DOCTYPE html>
<head>
  <style type="text/css">  
  <#include "../style/reset.css">
  <#include "../style/ent.css">
  </style>
</head>
<body>
      <div class="info">
         <ul>
	    <li>
	        <h1> Liste des gommettes </h1>
	    </li>
	    <#if (userLog)!false>	
	    <li>
	    	<a href="/gommettes/create">
	    	    Créer une gommette
	      	</a>
	    </li>
	    </#if>
	    <#list gommettes as gommette>
	    <li class="gommette">
	       <h2>${gommette.getColor()}: ${gommette.getDescription()}</h2>
	       <#if (userLog)!false>
	       <a href="/gommettes/modify/${gommette.getId()}"> Modifier la gommette </a>
	       </#if>
	    </li>
	    </#list>
	 </ul>
      </div>
</body>
</html>
