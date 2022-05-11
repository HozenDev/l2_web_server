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
		<#list eleve.getAllGommettes() as g>
      	   	  <li>
		    <p class="g_btn ${g.getColor()}"> </p>
		    <p>
		      (${g.getColor()}) - ${g.getDate()} | ${g.getProfNames()}: ${g.getBehavior()}
		    </p>
		  </li>
      	   	</#list>
     	</ul>
	</li>
	</ul>
	</div>
</body>
</html>
