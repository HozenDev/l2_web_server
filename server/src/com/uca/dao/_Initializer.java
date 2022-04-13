package com.uca.dao;

import java.sql.*;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();

        try {
            PreparedStatement statement;

	    // remove all instance in sql base
	    statement = connection.prepareStatement("TRUNCATE TABLE users");
	    statement.executeUpdate();

	    statement = connection.prepareStatement("TRUNCATE TABLE professeurs");
	    statement.executeUpdate();

	    statement = connection.prepareStatement("TRUNCATE TABLE eleves");
	    statement.executeUpdate();
        
	    statement = connection.prepareStatement("TRUNCATE TABLE gommettes");
	    statement.executeUpdate();
	    
	    statement = connection.prepareStatement("TRUNCATE TABLE gommettesAttribuees");
	    statement.executeUpdate();	    
	    
            //Init articles table
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users (id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); ");

	    statement.executeUpdate();
	    // Personal tables
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS professeurs (id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); ");
	    statement.executeUpdate();
	    statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS eleves (id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); ");
	    statement.executeUpdate();
	    statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS gommettes (id int primary key auto_increment, color varchar(100), description varchar(100)); ");
	    statement.executeUpdate();
	    statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS gommettesAttribuees (id int primary key auto_increment, id_student varchar(100), id_prof varchar(100), id_gommette varchar(100), date varchar(100), behavior varchar(100)); ");
	    statement.executeUpdate();
	    
	    // Todo remove me !
            statement = connection.prepareStatement("INSERT INTO users(firstname, lastname) VALUES(?, ?);");
            statement.setString(1, "Theodore");
            statement.setString(2, "Muillerez");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO eleves(firstname, lastname) VALUES(?, ?);");
            statement.setString(1, "Enzo");
            statement.setString(2, "Durel");
            statement.executeUpdate();

	    statement = connection.prepareStatement("INSERT INTO gommettes(color, description) VALUES(?, ?);");
            statement.setString(1, "Rouge");
            statement.setString(2, "Bavardages");
            statement.executeUpdate();

	    statement = connection.prepareStatement("INSERT INTO gommettesAttribuees(id_student, id_prof, id_gommette, date, behavior) VALUES(?, ?, ?, ?, ?);");
            statement.setInt(1, 1);
            statement.setInt(2, 2);
	    statement.setInt(3, 4);
	    statement.setString(4, "10/31/12");
	    statement.setString(5, "parle avec son camarade");
            statement.executeUpdate();
	    
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}
