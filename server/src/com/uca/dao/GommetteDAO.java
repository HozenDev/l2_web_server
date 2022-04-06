package com.uca.dao;

import com.uca.entity.GommetteEntity;

import java.sql.*;
import java.util.ArrayList;

public class GommetteDAO extends _Generic<GommetteEntity> {

    public ArrayList<GommetteEntity> getAllUsers() {
        ArrayList<GommetteEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM users ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GommetteEntity entity = new GommetteEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setFirstName(resultSet.getString("firstname"));
                entity.setLastName(resultSet.getString("lastname"));

                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public GommetteEntity create(GommetteEntity obj) {
        //TODO !
        return null;
    }

    @Override
    public void delete(GommetteEntity obj) {
        //TODO !
    }
}
