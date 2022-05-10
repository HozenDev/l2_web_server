<!DOCTYPE html>
<head>
  <style type="text/css">  
  <#include "../style/reset.css">
  <#include "../style/form.css">
  </style>
</head>
<body>
  <form method="post" onsubmit="/eleves/modify/${eleve.getId()}">
    <ul>
      <li>
        <h2> Modification d'un élève </h2>
      </li>
      <li>
        <h3> Nom </h3>
	<input type="text" name="lastname" value="${eleve.getLastName()}"/>
      </li>
      <li>
        <h3> Prénom </h3>
	<input type="text" name="firstname" value="${eleve.getFirstName()}"/>
      </li>
      <li>
	<input type="submit" value="Modifier"/>
	<p> ${log} </p>
      </li>
    </ul>
  </form>
</body>
</html>