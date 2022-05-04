package com.uca;

import com.uca.entity.*;
import com.uca.dao._Initializer;
import com.uca.gui.*;

import static spark.Spark.*;

import spark.*;

public class StartServer {

    public static boolean isUserLog(Request request) {
	return (request.session().attribute("user") != null);
    }
    
    public static void main(String[] args) {
        //Configure Spark
        staticFiles.location("/static/");
        port(8081);

        _Initializer.Init();

	//** Personnales routes **//

	get("/login", (req, res) -> {
		return UserGUI.login("");
	    });
	
	post("/login", (req, res) -> {
		if (!ProfesseurEntity.validLogin(req.queryParams("username"),
						 req.queryParams("password"))) {
		    System.out.println(req.queryParams("username"));
		    System.out.println(req.queryParams("password"));
		    return ProfesseurGUI.login("Nom d'utilisateur et mot de passe incorrects.");
		}
		ProfesseurEntity entity = ProfesseurEntity.getLogUser(req.queryParams("username"),
								      req.queryParams("password"));

		res.cookie("logUser", ""+entity.getId());
		req.session(true);
		req.session().attribute("user", entity);
		res.redirect("/professeurs/"+entity.getId());
		return "Vous êtes connectés, redirection en cours...";
	    });

	//* Eleve routes *//
	
        get("/eleves", (req, res) -> {
		return EleveGUI.getAllUsers();
	    });

	get("/eleves/:id", (req, res) -> {
		return EleveGUI.getUserById(Integer.parseInt(req.params(":id")));
	    });

        post("/eleves/create", (req, res) -> {
		EleveEntity obj = new EleveEntity();
		obj.setFirstName(req.queryParams("lastname"));
		obj.setLastName(req.queryParams("firstname"));
		return EleveGUI.create(obj);
	    });

        get("/eleves/delete/:id", (req, res) -> {
		EleveEntity obj = new EleveEntity();
		obj.setId(Integer.parseInt(req.params(":id")));
		return EleveGUI.delete(obj);
	    });

	//* Professeur routes *//	

        get("/professeurs", (req, res) -> {
		return ProfesseurGUI.getAllUsers();
	    });

        post("/professeurs/create", (req, res) -> {
		ProfesseurEntity obj = new ProfesseurEntity();
		obj.setFirstName(req.queryParams("lastname"));
		obj.setLastName(req.queryParams("firstname"));
		obj.setUsername(req.queryParams("username"));
		obj.setPassword(req.queryParams("password"));
		return ProfesseurGUI.create(obj);
	    });

        get("/professeurs/delete/:id", (req, res) -> {
		ProfesseurEntity obj = new ProfesseurEntity();
		obj.setId(Integer.parseInt(req.params(":id")));
		return ProfesseurGUI.delete(obj);
	    });

	get("/professeurs/:id", (req, res) -> {
		if (!StartServer.isUserLog(req)) {
		    res.redirect("/login");
		}
		if (Integer.parseInt(req.params(":id")) != Integer.parseInt(req.cookie("logUser"))) {
		    halt(401, "<h2> 401 Unauthorized </h2>");
		}
		return ProfesseurGUI.getUserById(Integer.parseInt(req.params(":id")));
	    });

	//* Gommettes routes *//
	
        get("/gommettes", (req, res) -> {
		return GommetteGUI.getAllUsers();
	    });

        post("/gommettes/create", (req, res) -> {
		GommetteEntity obj = new GommetteEntity();
		obj.setColor(req.queryParams("color"));
		obj.setDescription(req.queryParams("description"));
		return GommetteGUI.create(obj);
	    });

        get("/gommettes/delete/:id", (req, res) -> {
		GommetteEntity obj = new GommetteEntity();
		obj.setId(Integer.parseInt(req.params(":id")));
		return GommetteGUI.delete(obj);
	    });	

	//* Gommettes Attribuees routes *//
	
        get("/gommettesAttribuees", (req, res) -> {
		return GommetteAttribueeGUI.getAllUsers();
	    });

        post("/gommettesAttribuees/create", (req, res) -> {
		GommetteAttribueeEntity obj = new GommetteAttribueeEntity();

		int idS = Integer.parseInt(req.queryParams("id_student"));
		int idP = Integer.parseInt(req.queryParams("id_prof"));
		int idG = Integer.parseInt(req.queryParams("id_gommette"));		

		if (!GommetteAttribueeEntity.isValidTuple(idS, "eleves")) {
		    return "<p> ID de l'élève invalide </p>";
		}
		if (!GommetteAttribueeEntity.isValidTuple(idP, "professeurs")) {
		    return "<p> ID du professeur invalide </p>";
		}
		if (!GommetteAttribueeEntity.isValidTuple(idG, "gommettes")) {
		    return "<p> ID de la gommette invalide </p>";
		}		

		obj.setIdStudent(idS);
		obj.setIdProf(idP);
		obj.setIdGommette(idG);
		obj.setDate(req.queryParams("date"));
		obj.setBehavior(req.queryParams("behavior"));
		return GommetteAttribueeGUI.create(obj);
	    });

        get("/gommettesAttribuees/delete/:id", (req, res) -> {
		GommetteAttribueeEntity obj = new GommetteAttribueeEntity();
		obj.setId(Integer.parseInt(req.params(":id")));
		return GommetteAttribueeGUI.delete(obj);
	    });	
    }
}
