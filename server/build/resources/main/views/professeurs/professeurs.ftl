<!DOCTYPE html>
<head>
  <link rel='stylesheet' href='/reset.css'>
  <link rel='stylesheet' href='/ent.css'>
  <link rel='stylesheet' href='/header.css'>
</head>
<body>
      <div class="info">
         <ul>
	    <li>
	        <h1> Liste des professeurs </h1>
	    </li>
	    <#list professeurs as professeur>
	    <li class="list">
	    	  <div class="list_head">
		  <h2> ${professeur.getLastName()} ${professeur.getFirstName()} </h2>
		  </div>
	    	  <ul>
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
	    </#list>
	 </ul>
      </div>
</body>
</html>
