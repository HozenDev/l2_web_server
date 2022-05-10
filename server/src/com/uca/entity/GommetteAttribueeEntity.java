package com.uca.entity;

import com.uca.dao._Connector;
import java.sql.*;

public class GommetteAttribueeEntity {
    private int id;
    private int idStudent;
    private int idGommette;
    private int idProf;
    private String date;
    private String behavior;

    public GommetteAttribueeEntity() {
	// Ignored
    }
    
    // Getters //

    public int getId() {
	return this.id;
    }

    public int getIdStudent() {
	return this.idStudent;
    }

    public int getIdProf() {
	return this.idProf;
    }

    public int getIdGommette() {
	return this.idGommette;
    }

    public String getDate() {
	return this.date;
    }

    public String getBehavior() {
	return this.behavior;
    }

    // Setters //

    public void setId(int id) {
	this.id = id;
    }

    public void setIdStudent(int id) {
	this.idStudent = id;
    }

    public void setIdProf(int id) {
	this.idProf = id;
    }

    public void setIdGommette(int id) {
	this.idGommette = id;
    }

    public void setDate(String date) {
	this.date = date;
    }

    public void setBehavior(String behavior) {
	this.behavior = behavior;
    }
    
    @Override
    public String toString() {

	Connection connect = _Connector.getInstance();
	PreparedStatement statement;
	ResultSet resultSet;
	
	String prof_lastname = "";
	String prof_firstname = "";
	String eleve_lastname = "";
	String eleve_firstname = "";
	String gommette_color = "";

	try {
	    statement =
		connect.prepareStatement("SELECT lastname, firstname FROM professeurs WHERE id = ?;");
	    statement.setInt(1, this.idProf);
	    resultSet = statement.executeQuery();
	    resultSet.next();
	    
	    prof_lastname = resultSet.getString("lastname");
	    prof_firstname = resultSet.getString("firstname");	    

	    statement =
		connect.prepareStatement("SELECT lastname, firstname FROM eleves WHERE id = ?;");
	    statement.setInt(1, this.idStudent);
	    resultSet = statement.executeQuery();
	    resultSet.next();
	    
	    eleve_lastname = resultSet.getString("lastname");
	    eleve_firstname = resultSet.getString("firstname");

	    statement =
		connect.prepareStatement("SELECT color FROM gommettes WHERE id = ?;");
	    statement.setInt(1, this.idGommette);
	    resultSet = statement.executeQuery();
	    resultSet.next();
	    
	    gommette_color = resultSet.getString("color");
	}
	catch (Exception e) {
	    System.out.println(e.toString());
	    throw new RuntimeException("SQL Error: could not recup gommettesAttribuees datas");
	}
	    
	return String.format("Le professeur %s %s a mis la gommette %s à l'élève %s %s, le %s pour motif : '%s'.", prof_lastname, prof_firstname, gommette_color, eleve_lastname, eleve_firstname, date, behavior);
    }    
}
