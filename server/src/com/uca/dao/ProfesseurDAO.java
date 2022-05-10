package com.uca.dao;

import com.uca.entity.ProfesseurEntity;

import java.sql.*;
import java.util.ArrayList;

public class ProfesseurDAO extends _Generic<ProfesseurEntity> {

    public ArrayList<ProfesseurEntity> getAllUsers() {
        ArrayList<ProfesseurEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM professeurs ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ProfesseurEntity entity = new ProfesseurEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setFirstName(resultSet.getString("firstname"));
                entity.setLastName(resultSet.getString("lastname"));
		entity.setUsername(resultSet.getString("username"));
		entity.setPassword(resultSet.getString("password"));
		
		entity.initGommette(); // compute the list of gommetteAttribuee
		
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    public ProfesseurEntity getUserById(int id) {
	PreparedStatement statement;
	ProfesseurEntity entity = new ProfesseurEntity();
	try {
	    statement =
		this.connect.prepareStatement("SELECT * FROM professeurs WHERE id = ?;");
	    statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
	    if (resultSet.next()) {
                entity.setId(resultSet.getInt("id"));
                entity.setFirstName(resultSet.getString("firstname"));
                entity.setLastName(resultSet.getString("lastname"));
		entity.setUsername(resultSet.getString("username"));
		entity.setPassword(resultSet.getString("password"));
		
		entity.initGommette(); // compute the list of gommetteAttribuee
	    }
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
        return entity;
    }

    @Override
    public ProfesseurEntity create(ProfesseurEntity obj) {
	PreparedStatement statement;
	try {
	    statement =
		this.connect.prepareStatement("INSERT INTO professeurs (lastname, firstname, username, password) VALUES(?, ?, ?, ?);");
	    statement.setString(1, obj.getLastName());
	    statement.setString(2, obj.getFirstName());
	    statement.setString(3, obj.getUsername());
	    statement.setString(4, obj.getPassword());
	    
	    statement.executeUpdate();
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
        return obj;
    }

    @Override
    public void delete(ProfesseurEntity obj) {
	PreparedStatement statement;
	try {
	    statement =
		this.connect.prepareStatement("DELETE FROM professeurs WHERE id = ?");
	    statement.setInt(1, obj.getId());
	    statement.executeUpdate();
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}
