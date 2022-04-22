package com.uca.entity;

import com.uca.dao._Connector;
import java.sql.*;
import java.util.ArrayList;

public class EleveEntity {

    private ArrayList<GommetteAttribueeEntity> listGommettes;
    private int id;
    private String lastName;
    private String firstName;
    
    public EleveEntity() {
	this.listGommettes = new ArrayList<>();
    }

    // Getters //

    public ArrayList<GommetteAttribueeEntity> getAllGommettes() {
	return this.listGommettes;
    }

    public int getId() {
	return this.id;
    }

    public String getLastName() {
	return this.lastName;
    }

    public String getFirstName() {
	return this.firstName;
    }

    // Setters //

    public void initGommette() {
	Connection connect = _Connector.getInstance();
	PreparedStatement statement;
	
	try {
	    statement =
		connect.prepareStatement("SELECT * FROM gommettesAttribuees WHERE id_student = ?;");
	    statement.setInt(1, this.id);   
	    ResultSet resultSet = statement.executeQuery();	

	    while (resultSet.next()) {
		GommetteAttribueeEntity entity = new GommetteAttribueeEntity();
		entity.setId(resultSet.getInt("id"));
		entity.setIdStudent(resultSet.getInt("id_student"));
		entity.setIdProf(resultSet.getInt("id_prof"));
		entity.setIdGommette(resultSet.getInt("id_gommette"));
		entity.setDate(resultSet.getString("date"));
		entity.setBehavior(resultSet.getString("behavior"));

		this.listGommettes.add(entity);
	    }
	}
	catch (Exception e) {
	    System.out.println(e.toString());
	    throw new RuntimeException("could not recup data student");
	}
    }    

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public void setId(int id) {
	this.id = id;
    }

    @Override
    public String toString() {
	return String.format("%s %s", this.lastName, this.firstName);
    }
}
