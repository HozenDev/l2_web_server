<html>
<head>
  <style type="text/css">  
  <#include "../style/reset.css">
  <#include "../style/form.css">
  </style>
</head>
<body>
  <form method="post" action="/eleves/create">
    <ul>
      <li>
        <h2> Création d'un élève </h2>
      </li>
      <li>
        <h3> Nom </h3>
	<input type="text" name="lastname"/>
      </li>
      <li>
        <h3> Prénom </h3>
	<input type="text" name="firstname"/>
      </li>
      <li>
	<input type="submit" value="Créer"/>
	<p> ${log} </p>
      </li>
    </ul>
  </form>
</body>
</html>
