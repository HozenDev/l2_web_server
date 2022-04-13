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

		entity.setGommette(resultSet.getString("listGommettes"));
		
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public EleveEntity create(EleveEntity obj) {
        //TODO !
        return null;
    }

    @Override
    public void delete(EleveEntity obj) {
        //TODO !
    }
}
