<#import "../macros/navheader.ftl" as nh>

<html>
<head>
  <style type="text/css">  
  <#include "../style/reset.css">
  <#include "../style/form.css">
  <#include "../style/header.css">
  </style>
</head>
<body>
  <@nh.navheadbar userIsLog=(userLog)!true id="${userId}"/>
  <form method="post" onsubmit="/users/login">
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
