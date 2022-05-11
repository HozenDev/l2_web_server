<html>
<head>
  <link rel='stylesheet' href='/reset.css'>
  <link rel='stylesheet' href='/form.css'>
</head>
<body>
  <form method="POST" action="/eleves/create">
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
