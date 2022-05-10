<!DOCTYPE html>
<head>
  <style type="text/css">  
  <#include "../style/reset.css">
  <#include "../style/form.css">
  </style>
</head>
<body>
  <form method="post" onsubmit="/gommettes/modify/${gommette.getId()}">
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