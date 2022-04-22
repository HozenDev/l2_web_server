package com.uca.entity;

import com.uca.dao._Connector;
import java.sql.*;

public class UserEntity {
    private String firstName;
    private String lastName;
    private String password;
    private String username;
    private String statut;
    private int id;

    public UserEntity() {
        //Ignored !
    }

    public String getUsername() {
	return this.username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getStatut() {
	return this.statut;
    }

    public void setStatut(String statut) {
	this.statut = statut;
    }

    public String getPassword() {
	return this.password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static UserEntity getLogUser(String username, String password) {
	UserEntity entity = null;

	Connection connect = _Connector.getInstance();
	PreparedStatement statement;
	ResultSet resultSet;

	try {
	    statement =
		connect.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?;");
	    statement.setString(1, username);
	    statement.setString(2, password);
	    resultSet = statement.executeQuery();
	    if (resultSet.next()) {
		entity = new UserEntity();
		entity.setId(resultSet.getInt("id"));
                entity.setFirstName(resultSet.getString("firstname"));
                entity.setLastName(resultSet.getString("lastname"));
		entity.setUsername(resultSet.getString("username"));
		entity.setPassword(resultSet.getString("password"));
		entity.setStatut(resultSet.getString("statut"));
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
		connect.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?;");
	    statement.setString(1, username);
	    statement.setString(2, password);
	    resultSet = statement.executeQuery();
	    if (resultSet.next()) isvalid = true;
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
