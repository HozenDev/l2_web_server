package com.uca.core;

import java.sql.*;
import com.uca.dao._Connector;

public class SqlCore {

    public static boolean isValidTuple(int id, String table_name) {
	boolean isvalid = false;
	Connection connect = _Connector.getInstance();
	PreparedStatement statement;
	ResultSet resultSet;
	try {
	    statement = connect.prepareStatement("SELECT * FROM " + table_name + " WHERE id = ?;");
	    statement.setInt(1, id);
	    resultSet = statement.executeQuery();
	    if (resultSet.next())
		isvalid = true;
	} catch (Exception e) {
	    System.out.println(e.toString());
	    throw new RuntimeException("SQL Error: Invalide ID Student");
	}
	return isvalid;
    }
}
