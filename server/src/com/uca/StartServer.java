package com.uca;

import com.uca.entity.*;
import com.uca.core.*;
import com.uca.dao._Initializer;
import com.uca.gui.*;

import static spark.Spark.*;
import spark.*;

public class StartServer {
    
    public static void main(String[] args) {
        //Configure Spark
        staticFiles.location("/static/");
        port(8081);

        _Initializer.Init();

	//** Personnales routes **//

	get("/", (req, res) -> {
		if (LoginCore.isUserLog(req)) {
		    res.redirect("/professeurs/"+req.cookie("user_id"));
		    return null;
		}
		res.redirect("/login");
		return null;
	    });
	
	get("/login", (req, res) -> {
		int id = 0;
		if (LoginCore.isUserLog(req)) {
		    id = Integer.parseInt(req.cookie("user_id"));
		}		
		return ProfesseurGUI.login("", LoginCore.isUserLog(req), id);
	    });
	
	post("/login", (req, res) -> {
		if (!ProfesseurEntity.validLogin(req.queryParams("username"),
						 req.queryParams("password"))) {
		    return ProfesseurGUI.login("Nom d'utilisateur et mot de passe incorrects.", false, 0);
		}
		ProfesseurEntity entity = ProfesseurEntity.getLogUser(req.queryParams("username"),
								      req.queryParams("password"));

		res.cookie("user_id", ""+entity.getId());
		req.session(true);
		req.session().attribute("user", entity);
		res.redirect("/professeurs/"+entity.getId());
		return null;
	    });

	get("/logout", (req, res) -> {
		if (LoginCore.isUserLog(req)) {
		    // remove cookies & sessions
		    res.removeCookie("user_id");
		    req.session().removeAttribute("user");
		}
		res.redirect("/login");
		return null;
	    });

	//* Eleve routes *//
	
        get("/eleves", (req, res) -> {
		int id = 0;
		if (LoginCore.isUserLog(req)) {
		    id = Integer.parseInt(req.cookie("user_id"));
		}
		return EleveGUI.getAllEleves(LoginCore.isUserLog(req),
					    id);
	    });

	get("/eleves/create", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		    return null;
		}
		return EleveGUI.create("");
	    });

	post("/eleves/create", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		    return null;
		}
		if (req.queryParams("lastname").equals("") ||
		    req.queryParams("firstname").equals("")) {
		    return EleveGUI.create("Les champs ne doivent pas être vides");
		}
		EleveEntity obj = new EleveEntity();
		obj.setLastName(req.queryParams("lastname"));
		obj.setFirstName(req.queryParams("firstname"));
		EleveCore.create(obj);
		return EleveGUI.create("L'élève a été créé.");
	    });

	get("/eleves/modify/:id", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		}
		int id = Integer.parseInt(req.params(":id"));
		if (!SqlCore.isValidTuple(id, "eleves")) {
		    res.redirect("/eleves");
		    return null;
		}
		return EleveGUI.modify(Integer.parseInt(req.params(":id")),
				       LoginCore.isUserLog(req),
				       "");
	    });

	post("/eleves/modify/:id", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		    return null;
		}
		int id = Integer.parseInt(req.params(":id"));
		if (!SqlCore.isValidTuple(id, "eleves")) {
		    res.redirect("/eleves");
		    return null;
		}
		if (req.queryParams("lastname").equals("") ||
		    req.queryParams("firstname").equals("")) {
		    return EleveGUI.modify(id,
					   LoginCore.isUserLog(req),
					   "Les champs ne doivent pas être vides");
		}
		EleveEntity obj = new EleveEntity();
		obj.setLastName(req.queryParams("lastname"));
		obj.setFirstName(req.queryParams("firstname"));
		obj.setId(id);
		EleveCore.modify(obj);
		return EleveGUI.modify(id,
				       LoginCore.isUserLog(req),
				       "L'élève a bien été modifié");
	    });

        get("/eleves/delete/:id", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		    return null;
		}
		EleveEntity obj = new EleveEntity();
		obj.setId(Integer.parseInt(req.params(":id")));
		EleveCore.delete(obj);
		res.redirect("/eleves");
		return null;
	    });

	get("/eleves/:id", (req, res) -> {
		int idS = Integer.parseInt(req.params(":id"));
		if (!SqlCore.isValidTuple(idS, "eleves")) {
		    res.redirect("/eleves");
		    return null;
		}
		return EleveGUI.getEleveById(Integer.parseInt(req.params(":id")),
					    LoginCore.isUserLog(req));
	    });

	//* Professeur routes *//	

        get("/professeurs", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		    return null;
		}
		return ProfesseurGUI.getAllProfesseurs();
	    });
	
	get("/professeurs/create", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		    return null;
		}
		return ProfesseurGUI.create("");
	    });

        post("/professeurs/create", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		    return null;
		}
		if (req.queryParams("lastname").equals("") ||
		    req.queryParams("firstname").equals("") ||
		    req.queryParams("username").equals("") ||
		    req.queryParams("password").equals("")) {
		    return ProfesseurGUI.create("Les champs ne doivent pas être vides");
		}
		ProfesseurEntity obj = new ProfesseurEntity();
		obj.setFirstName(req.queryParams("lastname"));
		obj.setLastName(req.queryParams("firstname"));
		obj.setUsername(req.queryParams("username"));
		obj.setPassword(req.queryParams("password"));
		ProfesseurCore.create(obj);
		return ProfesseurGUI.create("Le professeur a été créé.");
	    });

        get("/professeurs/delete/:id", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		    return null;
		}
		ProfesseurEntity obj = new ProfesseurEntity();
		obj.setId(Integer.parseInt(req.params(":id")));
		ProfesseurCore.delete(obj);
		res.redirect("/professeurs");
		return null;
	    });

	get("/professeurs/:id", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		    return null;
		}
		if (Integer.parseInt(req.params(":id")) != Integer.parseInt(req.cookie("user_id"))) {
		    halt(401, "<h2> 401 Unauthorized </h2>");
		}
		return ProfesseurGUI.getProfesseurById(Integer.parseInt(req.params(":id")), LoginCore.isUserLog(req));
	    });

	//* Gommettes routes *//
	
        get("/gommettes", (req, res) -> {
		int id = 0;
		if (LoginCore.isUserLog(req)) {
		    id = Integer.parseInt(req.cookie("user_id"));
		}
		return GommetteGUI.getAllGommettes(LoginCore.isUserLog(req),
						   id);
	    });

	get("/gommettes/create", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		    return null;
		}
		return GommetteGUI.create("");
	    });
	
        post("/gommettes/create", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		    return null;
		}
		GommetteEntity obj = new GommetteEntity();
		if (req.queryParams("color").equals("") ||
		    req.queryParams("description").equals("")) {
		    return GommetteGUI.create("Champs ne doivent pas être vides");
		}
		obj.setColor(req.queryParams("color"));
		obj.setDescription(req.queryParams("description"));
		GommetteCore.create(obj);
		return GommetteGUI.create("La gommette a été créée.");
	    });

	get("/gommettes/modify/:id", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		    return null;
		}
		int id = Integer.parseInt(req.params(":id"));
		if (!SqlCore.isValidTuple(id, "gommettes")) {
		    res.redirect("/gommettes");
		    return null;
		}
		return GommetteGUI.modify(Integer.parseInt(req.params(":id")),
					  LoginCore.isUserLog(req),
					  "");
	    });

	post("/gommettes/modify/:id", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		    return null;
		}
		int id = Integer.parseInt(req.params(":id"));
		if (!SqlCore.isValidTuple(id, "gommettes")) {
		    res.redirect("/gommettes");
		    return null;
		}
		if (req.queryParams("color").equals("") ||
		    req.queryParams("description").equals("")) {
		    return GommetteGUI.modify(Integer.parseInt(req.params(":id")),
					      LoginCore.isUserLog(req),
					      "Les champs ne doivent pas être vides");
		}
		GommetteEntity obj = new GommetteEntity();
		obj.setDescription(req.queryParams("description"));
		obj.setColor(req.queryParams("color"));
		obj.setId(id);
		GommetteCore.modify(obj);
		return GommetteGUI.modify(Integer.parseInt(req.params(":id")),
					  LoginCore.isUserLog(req),
					  "La gommette a été modifiée.");
	    });

        get("/gommettes/delete/:id", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		    return null;
		}
		GommetteEntity obj = new GommetteEntity();
		obj.setId(Integer.parseInt(req.params(":id")));
		GommetteCore.delete(obj);
		res.redirect("/gommettes");
		return null;
	    });	

	//* Gommettes Attribuees routes *//
	
	get("/gommettes/attribuees/create/:id", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		    return null;
		}
		int id = Integer.parseInt(req.params(":id"));
		if (!SqlCore.isValidTuple(id, "eleves")) {
		    res.redirect("/eleves");
		    return null;
		}
		return GommetteAttribueeGUI.create(id, "");
	    });

        post("/gommettes/attribuees/create/:id", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		    return null;
		}
		int idS = Integer.parseInt(req.params(":id"));
		if (!SqlCore.isValidTuple(idS, "eleves")) {
		    res.redirect("/eleves");
		    return null;
		}
		if (req.queryParams("date").equals("") ||
		    req.queryParams("behavior").equals("") ||
		    req.queryParams("id_gommette").equals("")) {
		    return GommetteAttribueeGUI.create(idS, "Les champs ne doivent pas être vides");
		}
		int idP = Integer.parseInt(req.cookie("user_id"));
		int idG = Integer.parseInt(req.queryParams("id_gommette"));
		if (!SqlCore.isValidTuple(idP, "professeurs")) {
		    return GommetteAttribueeGUI.create(idS, "ID du professeur invalide");
		}
		if (!SqlCore.isValidTuple(idG, "gommettes")) {
		    return GommetteAttribueeGUI.create(idS, "ID de la gommette invalide");
		}
		GommetteAttribueeEntity obj = new GommetteAttribueeEntity();
		obj.setIdStudent(idS);
		obj.setIdProf(idP);
		obj.setIdGommette(idG);
		obj.setDate(req.queryParams("date"));
		obj.setBehavior(req.queryParams("behavior"));
		GommetteAttribueeCore.create(obj);
		
		return GommetteAttribueeGUI.create(idS, "La gommette a été attribuée.");
	    });

	get("/gommettes/attribuees/delete/:id", (req, res) -> {
		if (!LoginCore.isUserLog(req)) {
		    res.redirect("/login");
		    return null;
		}
		GommetteAttribueeEntity obj = new GommetteAttribueeEntity();
		obj.setId(Integer.parseInt(req.params(":id")));
		GommetteAttribueeCore.delete(obj);
		res.redirect("/eleves");
		return null;
	    });
    }
}
