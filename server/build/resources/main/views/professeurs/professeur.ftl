<#import "../macros/navheader.ftl" as nh>

<!DOCTYPE html>
<head>
<link rel='stylesheet' href='/reset.css'>
<link rel='stylesheet' href='/ent.css'>
<link rel='stylesheet' href='/header.css'>
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
	 </li>
	 <li>
	   <a href="/eleves/create"> Créer un élève </a>
	 </li>
	 <li>
	   <a href="/gommettes/create"> Créer une gommette </a>
	 </li>
	 <li>
	   <a href="/eleves"> Attribuer une gommette </a>
	 </li>
	   <li>
	   <ul>
		<li id="list_of">
		<h3> Liste des gommettes attribuées par le professeur </h3>
		</li>
		<#list professeur.getAllGommettes() as g>
      	   	       <li>
		       <p class="g_btn ${g.getColor()}"> </p>
		       <p>
			 (${g.getColor()}) - ${g.getDate()} | à ${g.getEleveNames()}, pour motif: ${g.getBehavior()}
		       </p>
		       </li>
      	   	</#list>
     	</ul>
	</li>
	</ul>
	</div>
</body>

</html>
