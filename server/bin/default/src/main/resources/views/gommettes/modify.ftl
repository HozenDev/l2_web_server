<!DOCTYPE html>
<head>
  <link rel='stylesheet' href='/reset.css'>
  <link rel='stylesheet' href='/form.css'>
</head>
<body>
  <form method="post" action="/gommettes/modify/${gommette.getId()}">
    <ul>
      <li>
        <h2> Modification de la gommette </h2>
      </li>
      <li>
        <h3> Couleur </h3>
	<select name="color">
	  <option value="${gommette.getColor()}">${gommette.getColor()}</option>
	  <option value="rouge">rouge</option>
	  <option value="vert">vert</option>
	  <option value="blanc">blanc</option>
	</select>
      </li>
      <li>
        <h3> Description </h3>
	<input type="text" name="description" value="${gommette.getDescription()}"/>
      </li>
      <li>
	<input type="submit"/>
	<p> ${log} </p>
      </li>
    </ul>
  </form>
</body>
</html>
