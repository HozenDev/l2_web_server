package com.uca.dao;

import com.uca.entity.GommetteAttribueeEntity;

import java.sql.*;
import java.util.ArrayList;

public class GommetteAttribueeDAO extends _Generic<GommetteAttribueeEntity> {

    public ArrayList<GommetteAttribueeEntity> getAllUsers() {
        ArrayList<GommetteAttribueeEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM gommettesAttribuees ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GommetteAttribueeEntity entity = new GommetteAttribueeEntity();

		entity.setId(resultSet.getInt("id"));
                entity.setIdStudent(resultSet.getInt("id_student"));
		entity.setIdProf(resultSet.getInt("id_prof"));
		entity.setIdGommette(resultSet.getInt("id_gommette"));
		entity.setDate(resultSet.getString("date"));
		entity.setBehavior(resultSet.getString("behavior"));		

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
