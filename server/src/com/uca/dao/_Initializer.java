package com.uca.dao;

import java.sql.*;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();

        try {
            PreparedStatement statement;
	    
            //Init tables
            statement =
		connection.prepareStatement("CREATE TABLE IF NOT EXISTS professeurs (id int primary key auto_increment, firstname varchar(100), lastname varchar(100), username varchar(50), password varchar(50)); ");
	    statement.executeUpdate();
	    statement =
		connection.prepareStatement("CREATE TABLE IF NOT EXISTS eleves (id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); ");
	    statement.executeUpdate();
	    statement =
		connection.prepareStatement("CREATE TABLE IF NOT EXISTS gommettes (id int primary key auto_increment, color varchar(20), description varchar(100)); ");
	    statement.executeUpdate();
	    statement =
		connection.prepareStatement("CREATE TABLE IF NOT EXISTS gommettesAttribuees (id int primary key auto_increment, id_student int, id_prof int, id_gommette int, date varchar(20), behavior varchar(3000)); ");
	    statement.executeUpdate();

	    // statement = connection.prepareStatement("TRUNCATE TABLE professeurs");
	    // statement.executeUpdate();
	    
	    // statement = connection.prepareStatement("INSERT INTO professeurs VALUES (1, 'Framboisier', 'M.', 'mframboisier', '1234');");
	    // statement.executeUpdate();
	    // statement = connection.prepareStatement("INSERT INTO professeurs VALUES (2, 'Myrtille', 'Mme.', 'mmemyrtille', '1234');");
	    // statement.executeUpdate();
	    
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}
