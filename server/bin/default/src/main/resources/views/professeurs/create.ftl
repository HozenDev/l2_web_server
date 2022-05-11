<html>
<head>
<link rel='stylesheet' href='/reset.css'>
<link rel='stylesheet' href='/form.css'>
</head>
<body>
  <form method="post" action="/professeurs/create">
    <ul>
      <li>
        <h2> Création d'un professeur </h2>
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
        <h3> Identifiant </h3>
	<input type="text" name="username"/>
      </li>
      <li>
        <h3> Mot de Passe </h3>
	<input type="text" name="password"/>
      </li>
      <li>
	<input type="submit"/>
	<p> ${log} </p>
      </li>
    </ul>
  </form>
</body>
</html>
