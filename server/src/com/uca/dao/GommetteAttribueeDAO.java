package com.uca.dao;

import com.uca.entity.GommetteAttribueeEntity;

import java.sql.*;
import java.util.ArrayList;

public class GommetteAttribueeDAO extends _Generic<GommetteAttribueeEntity> {

    @Override
    public GommetteAttribueeEntity create(GommetteAttribueeEntity obj) {
	PreparedStatement statement;
	try {
	    statement =
		this.connect.prepareStatement("INSERT INTO gommettesAttribuees (id_student, id_prof, id_gommette, date, behavior) VALUES(?, ?, ?, ?, ?);");
	    statement.setInt(1, obj.getIdStudent());
	    statement.setInt(2, obj.getIdProf());
	    statement.setInt(3, obj.getIdGommette());
	    statement.setString(4, obj.getDate());
	    statement.setString(5, obj.getBehavior());
	    statement.executeUpdate();
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
        return obj;
    }

    @Override
    public void delete(GommetteAttribueeEntity obj) {
	PreparedStatement statement;
	try {
	    statement =
		this.connect.prepareStatement("DELETE FROM gommettesAttribuees WHERE id = ?");
	    statement.setInt(1, obj.getId());
	    statement.executeUpdate();
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}
