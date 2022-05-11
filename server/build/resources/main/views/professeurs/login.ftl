<#import "../macros/navheader.ftl" as nh>
<!DOCTYPE html>
<head>
<link rel='stylesheet' href='/reset.css'>
<link rel='stylesheet' href='/form.css'>
<link rel='stylesheet' href='/header.css'>
</head>
<body>
  <@nh.navheadbar userIsLog=(userLog)!true id="${userId}"/>
  <form method="POST" action="/login">
    <ul>
      <li>
        <h2> Connexion </h2>
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
