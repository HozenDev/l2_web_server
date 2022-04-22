package com.uca.dao;

import com.uca.entity.EleveEntity;

import java.sql.*;
import java.util.ArrayList;

public class EleveDAO extends _Generic<EleveEntity> {

    public ArrayList<EleveEntity> getAllUsers() {
        ArrayList<EleveEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM eleves ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EleveEntity entity = new EleveEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setFirstName(resultSet.getString("firstname"));
                entity.setLastName(resultSet.getString("lastname"));

		entity.initGommette();
		
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public EleveEntity create(EleveEntity obj) {
	PreparedStatement statement;
	try {
	    statement =
		this.connect.prepareStatement("INSERT INTO eleves (lastname, firstname) VALUES(?, ?);");
	    statement.setString(1, obj.getLastName());
	    statement.setString(2, obj.getFirstName());
	    statement.executeUpdate();
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
        return obj;
    }

    @Override
    public void delete(EleveEntity obj) {
	PreparedStatement statement;
	try {
	    statement =
		this.connect.prepareStatement("DELETE FROM eleves WHERE id = ?");
	    statement.setInt(1, obj.getId());
	    statement.executeUpdate();
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public ArrayList<EleveEntity> getUserById(int id) {
	PreparedStatement statement;
	ArrayList<EleveEntity> entities = new ArrayList<>();
	try {
	    statement =
		this.connect.prepareStatement("SELECT * FROM eleves WHERE id = ?;");
	    statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
	    if (resultSet.next()) {
                EleveEntity entity = new EleveEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setFirstName(resultSet.getString("firstname"));
                entity.setLastName(resultSet.getString("lastname"));
		entity.initGommette();
		entities.add(entity);
	    }
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
        return entities;
    }
}
