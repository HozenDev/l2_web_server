package com.uca.dao;

import com.uca.entity.GommetteAttribueeEntity;

import java.sql.*;
import java.util.ArrayList;

public class GommetteAttribueeDAO extends _Generic<GommetteAttribueeEntity> {

    public ArrayList<GommetteAttribueeEntity> getAllUsers() {
        ArrayList<GommetteAttribueeEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM users ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GommetteAttribueeEntity entity = new GommetteAttribueeEntity();
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
    public GommetteAttribueeEntity create(GommetteAttribueeEntity obj) {
        //TODO !
        return null;
    }

    @Override
    public void delete(GommetteAttribueeEntity obj) {
        //TODO !
    }
}
