package com.uca.dao;

import com.uca.entity.UserEntity;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO extends _Generic<UserEntity> {

    public ArrayList<UserEntity> getAllUsers() {
        ArrayList<UserEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM users ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserEntity entity = new UserEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setFirstName(resultSet.getString("firstname"));
                entity.setLastName(resultSet.getString("lastname"));
		entity.setUsername(resultSet.getString("username"));
		entity.setPassword(resultSet.getString("password"));
		entity.setStatut(resultSet.getString("statut"));
		
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    public ArrayList<UserEntity> getUserById(int id) {
	PreparedStatement statement;
	ArrayList<UserEntity> entities = new ArrayList<>();
	try {
	    statement =
		this.connect.prepareStatement("SELECT * FROM users WHERE id = ?;");
	    statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
	    if (resultSet.next()) {
                UserEntity entity = new UserEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setFirstName(resultSet.getString("firstname"));
                entity.setLastName(resultSet.getString("lastname"));
		entity.setUsername(resultSet.getString("username"));
		entity.setPassword(resultSet.getString("password"));
		entity.setStatut(resultSet.getString("statut"));

		entities.add(entity);
	    }
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
        return entities;
    }

    @Override
    public UserEntity create(UserEntity obj) {
	PreparedStatement statement;
	try {
	    statement =
		this.connect.prepareStatement("INSERT INTO users (lastname, firstname, statut, password, username) VALUES(?, ?, ?, ?, ?);");
	    statement.setString(1, obj.getLastName());
	    statement.setString(2, obj.getFirstName());
	    statement.setString(3, obj.getStatut());
	    statement.setString(4, obj.getPassword());
	    statement.setString(5, obj.getUsername());
	    statement.executeUpdate();
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
        return obj;
    }

    @Override
    public void delete(UserEntity obj) {
	PreparedStatement statement;
	try {
	    statement =
		this.connect.prepareStatement("DELETE FROM users WHERE id = ?");
	    statement.setInt(1, obj.getId());
	    statement.executeUpdate();
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}
