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
    
    public GommetteAttribueeEntity getGommette(int index) {
	return this.listGommettes.get(index);
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

    public void setGommette(String src) {
	Connection connect = _Connector.getInstance();
	PreparedStatement statement;
	
	String[] srcSplit = src.split(";");
	
	for (String s: srcSplit) {
	    try {

		// Requête SQL
		
		statement =
		    connect.prepareStatement("SELECT * FROM gommettesAttribuees INNER JOIN eleves ON gommettesAttribuees.id = ?;");
		statement.setInt(1, Integer.parseInt(s));
		ResultSet resultSet = statement.executeQuery();
		resultSet.next();

		// Create GommetteAttribueeEntity
		
		GommetteAttribueeEntity entity = new GommetteAttribueeEntity();
		entity.setId(resultSet.getInt("id"));
		entity.setIdStudent(resultSet.getInt("id_student"));
		entity.setIdProf(resultSet.getInt("id_prof"));
		entity.setIdGommette(resultSet.getInt("id_gommette"));
		entity.setDate(resultSet.getString("date"));
		entity.setBehavior(resultSet.getString("behavior"));

		this.listGommettes.add(entity);
	    }
	    catch (Exception e) {
		System.out.println(e.toString());
		throw new RuntimeException("could not recup data professor");
	    }
	}
    }

    // list String

    public String strListGommette() {
	StringBuilder s = new StringBuilder();
	s.append("<br>");
	for (GommetteAttribueeEntity g: this.listGommettes) {
	    s.append(g.toString());
	    s.append("<br>");
	}
	return s.toString();
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
}
