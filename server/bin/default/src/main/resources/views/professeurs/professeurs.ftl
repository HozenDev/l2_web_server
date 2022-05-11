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
		    <#list professeur.getAllGommettes() as gom>
	    	      <li>
			<p> ${gom} </p>
		      </li>
	    	    </#list>
	         </ul>
	    </li>
	    </#list>
	 </ul>
      </div>
</body>
</html>
