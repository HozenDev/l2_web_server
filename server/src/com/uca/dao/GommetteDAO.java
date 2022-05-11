package com.uca.dao;

import com.uca.entity.GommetteEntity;

import java.sql.*;
import java.util.ArrayList;

public class GommetteDAO extends _Generic<GommetteEntity> {

    public ArrayList<GommetteEntity> getAllGommettes() {
        ArrayList<GommetteEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM gommettes ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GommetteEntity entity = new GommetteEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setColor(resultSet.getString("color"));
                entity.setDescription(resultSet.getString("description"));

                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    public GommetteEntity getGommetteById(int id) {
        GommetteEntity entity = new GommetteEntity();
        try {
            PreparedStatement preparedStatement =
		this.connect.prepareStatement("SELECT * FROM gommettes WHERE id = ?;");
	    preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {                
                entity.setId(resultSet.getInt("id"));
                entity.setColor(resultSet.getString("color"));
                entity.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }

    public GommetteEntity modify(GommetteEntity obj) {
	PreparedStatement statement;
	try {
	    statement =
		this.connect.prepareStatement("UPDATE gommettes SET color = ?, description = ? WHERE id = ?");
	    statement.setString(1, obj.getColor());
	    statement.setString(2, obj.getDescription());
	    statement.setInt(3, obj.getId());
	    statement.executeUpdate();
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
        return obj;
    }

    @Override
    public GommetteEntity create(GommetteEntity obj) {
	PreparedStatement statement;
	try {
	    statement =
		this.connect.prepareStatement("INSERT INTO gommettes (color, description) VALUES(?, ?);");
	    statement.setString(1, obj.getColor());
	    statement.setString(2, obj.getDescription());
	    statement.executeUpdate();
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
        return obj;
    }

    @Override
    public void delete(GommetteEntity obj) {
	PreparedStatement statement;
	try {
	    statement =
		this.connect.prepareStatement("DELETE FROM gommettesAttribuees WHERE id_gommette = ?");
	    statement.setInt(1, obj.getId());
	    statement.executeUpdate();

	    statement =
		this.connect.prepareStatement("DELETE FROM gommettes WHERE id = ?");
	    statement.setInt(1, obj.getId());
	    statement.executeUpdate();
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}
