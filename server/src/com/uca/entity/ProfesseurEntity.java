package com.uca.entity;

import com.uca.dao._Connector;
import java.util.ArrayList;
import java.sql.*;

public class ProfesseurEntity {

    private int id;
    private String lastName;
    private String firstName;
    private String password;
    private String username;
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

    public ArrayList<GommetteAttribueeEntity> getAllGommettes() {
	return this.listGommettes;
    }

    // Setters //

    public String getPassword() {
	return this.password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
    
    public String getUsername() {
	return this.username;
    }

    public void setUsername(String username) {
	this.username = username;
    }
    
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

    public void initGommette() {
	Connection connect = _Connector.getInstance();
	PreparedStatement statement;

	try {
	    statement =
		connect.prepareStatement("SELECT * FROM gommettesAttribuees WHERE id_prof = ?;");
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
	    throw new RuntimeException("could not recup data professor");
	}
    }

        public static ProfesseurEntity getLogUser(String username, String password) {
	ProfesseurEntity entity = null;

	Connection connect = _Connector.getInstance();
	PreparedStatement statement;
	ResultSet resultSet;

	try {
	    statement =
		connect.prepareStatement("SELECT * FROM professeurs WHERE username = ? AND password = ?;");
	    statement.setString(1, username);
	    statement.setString(2, password);
	    resultSet = statement.executeQuery();
	    if (resultSet.next()) {
		entity = new ProfesseurEntity();
		entity.setId(resultSet.getInt("id"));
                entity.setFirstName(resultSet.getString("firstname"));
                entity.setLastName(resultSet.getString("lastname"));
		entity.setUsername(resultSet.getString("username"));
		entity.setPassword(resultSet.getString("password"));
       
		entity.initGommette();
	    }
	}
	catch (Exception e) {
	    System.out.println(e.toString());
	    throw new RuntimeException("SQL Error: PWD and UN incorrects");
	}
	return entity;
    }
     
    public static boolean validLogin(String username, String password) {
	boolean isvalid = false;

	Connection connect = _Connector.getInstance();
	PreparedStatement statement;
	ResultSet resultSet;

	try {
	    statement =
		connect.prepareStatement("SELECT * FROM professeurs WHERE username = ? AND password = ?;");
	    statement.setString(1, username);
	    statement.setString(2, password);
	    resultSet = statement.executeQuery();
	    if (resultSet.next()) {
		isvalid = true;
	    }
	    else {
		System.out.println("NOn trouvé");
	    }
	}
	catch (Exception e) {
	    System.out.println(e.toString());
	    throw new RuntimeException("SQL Error: PWD and UN incorrects");
	}
	return isvalid;
    }

    @Override
    public String toString() {
	return String.format("%s %s", this.lastName, this.firstName);
    }
}
