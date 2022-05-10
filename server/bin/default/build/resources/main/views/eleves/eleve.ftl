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
      	   <h1> ${eleve.getLastName()} ${eleve.getFirstName()} </h1>
	   </li>
	   <li>
	   <ul>
		<li id="list_of">
		<h3> Liste des gommettes attribuées par les professeurs </h3>
		</li>
		<#list eleve.getAllGommettes() as p_lg>
      	   	       <li> ${p_lg} </li>
      	   	</#list>
     	</ul>
	</li>
	</ul>
	</div>
</body>
</html>
