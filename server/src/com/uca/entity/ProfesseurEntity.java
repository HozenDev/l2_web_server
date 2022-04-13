package com.uca.entity;

import java.util.ArrayList;
import java.sql.*;

public class ProfesseurEntity {

    private int id;
    private String lastName;
    private String firstName;
    private String classe;
    private ArrayList<GommetteAttribueeEntity> listGommettes;

    public ProfesseurEntity() {
	this.listGommettes = new ArrayList<>();
    }

    // Getters //

    public int getId() {
	return this.id;
    }

    public String getLastName() {
	return this.lastName;
    }

    public String getFirstName() {
	return this.firstName;
    }

    public String getClasse() {
	return this.classe;
    }

    public GommetteAttribueeEntity getGommette(int index) {
	GommetteAttribueeEntity gA = new GommetteAttribueeEntity();
	try {
	    gA = this.listGommettes.get(index);
	}
	catch (Exception e) {
	    System.out.println("Index invalide");
	}
	return gA;
    }

    // Setters //

    public void setId(int id) {
	this.id = id;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public void setClasse(String classe) {
	this.classe = classe;
    }

    public void setGommette(String src) {
	String[] srcSplit = src.split(";");
	for (String s: srcSplit) {
            PreparedStatement preparedStatement =
		this.connect.prepareStatement("SELECT * FROM gommettesAttribuees INNER JOIN professeurs ON gommettesAttribuees.id == ?;");
	    prepareStatement.setInt(1, Integer.parseInt(s));
            ResultSet resultSet = preparedStatement.executeQuery();
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

    // list String

    public String strListGommette() {
	StringBuilder s = new StringBuilder();
	for (GommetteAttribueeEntity g: this.listGommettes) {
	    s.append(g.toString());
	    s.append(";");
	}
	return s.toString();
    }
}
