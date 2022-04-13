package com.uca;

import com.uca.dao._Initializer;
import com.uca.gui.*;

import static spark.Spark.*;

public class StartServer {

    public static void main(String[] args) {
        //Configure Spark
        staticFiles.location("/static/");
        port(8081);

        _Initializer.Init();

        //Defining our routes
        get("/users", (req, res) -> {
            return UserGUI.getAllUsers();
        });

        //Defining our routes
        get("/eleves", (req, res) -> {
            return EleveGUI.getAllUsers();
        });

        get("/gommettes", (req, res) -> {
            return GommetteGUI.getAllUsers();
        });

        get("/professeurs", (req, res) -> {
            return ProfesseurGUI.getAllUsers();
        });

        get("/gommettesAttribuees", (req, res) -> {
            return GommetteAttribueeGUI.getAllUsers();
        });	
    }
}
