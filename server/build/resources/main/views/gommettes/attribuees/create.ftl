<!DOCTYPE html>
<head>
<link rel='stylesheet' href='/reset.css'>
<link rel='stylesheet' href='/form.css'>
</head>
<body>
  <form id="form_ga" method="POST" action="/gommettes/attribuees/create/${id_student}">
    <ul>
      <li>
        <h2> Attribution d'une gommette </h2>
      </li>
      <li>
	<h3> Couleur </h3>
	<select name="id_gommette">
	  <option value=""> -- Choisir une couleur -- </option>
	  <#list gommettes as gommette>
	    <option value=${gommette.getId()}> ${gommette.getColor()} - ${gommette.getDescription()}</option>
	  </#list>
	</select>
      </li>
      <li>
        <h3> Date d'attribution </h3>
	<input type="date" name="date" min="2022-04-05"/>
	<!--<input type="text" name="date"/>-->
      </li>
      <li>
        <h3> Description de son comportement </h3>
	<textarea form="form_ga" name="behavior" rows="10" cols="60" maxlength="10000"></textarea>
      </li>
      <li>
	<input type="submit"/>
	<p> ${log} </p>
      </li>
    </ul>
  </form>
</body>
</html>
