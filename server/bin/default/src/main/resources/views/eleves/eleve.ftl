<!DOCTYPE html>
<head>
<link rel='stylesheet' href='/reset.css'>
<link rel='stylesheet' href='/ent.css'>
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
