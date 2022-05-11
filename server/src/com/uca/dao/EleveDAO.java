package com.uca.dao;

import com.uca.entity.EleveEntity;

import java.sql.*;
import java.util.ArrayList;

public class EleveDAO extends _Generic<EleveEntity> {

    public ArrayList<EleveEntity> getAllEleves() {
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

    public EleveEntity modify(EleveEntity obj) {
	PreparedStatement statement;
	try {
	    statement =
		this.connect.prepareStatement("UPDATE eleves SET lastname = ?, firstname = ? WHERE id = ?;");
	    statement.setString(1, obj.getLastName());
	    statement.setString(2, obj.getFirstName());
	    statement.setInt(3, obj.getId());
	    statement.executeUpdate();
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
	return obj;
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
		this.connect.prepareStatement("DELETE FROM gommettesAttribuees WHERE id_student = ?;");
	    statement.setInt(1, obj.getId());
	    statement.executeUpdate();

	    statement =
		this.connect.prepareStatement("DELETE FROM eleves WHERE id = ?");
	    statement.setInt(1, obj.getId());
	    statement.executeUpdate();
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public EleveEntity getEleveById(int id) {
	PreparedStatement statement;
	EleveEntity entity = new EleveEntity();
	try {
	    statement =
		this.connect.prepareStatement("SELECT * FROM eleves WHERE id = ?;");
	    statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
	    if (resultSet.next()) {
                entity.setId(resultSet.getInt("id"));
                entity.setFirstName(resultSet.getString("firstname"));
                entity.setLastName(resultSet.getString("lastname"));

		entity.initGommette();
	    }
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
        return entity;
    }
}
