package com.uca.dao;

import com.uca.entity.ProfesseurEntity;

import java.sql.*;
import java.util.ArrayList;

public class ProfesseurDAO extends _Generic<ProfesseurEntity> {

    public ArrayList<ProfesseurEntity> getAllUsers() {
        ArrayList<ProfesseurEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM users ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ProfesseurEntity entity = new ProfesseurEntity();
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
    public ProfesseurEntity create(ProfesseurEntity obj) {
        //TODO !
        return null;
    }

    @Override
    public void delete(ProfesseurEntity obj) {
        //TODO !
    }
}
