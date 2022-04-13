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
	    
	    // remove all tables
	    statement = connection.prepareStatement("DROP TABLE gommettesAttribuees");
	    statement.executeUpdate();	    
	    statement = connection.prepareStatement("DROP TABLE eleves");
	    statement.executeUpdate();	    
	    statement = connection.prepareStatement("DROP TABLE gommettes");
	    statement.executeUpdate();
	    statement = connection.prepareStatement("DROP TABLE users");
	    statement.executeUpdate();	    
	    statement = connection.prepareStatement("DROP TABLE professeurs");
	    statement.executeUpdate();
	    
            //Init articles table
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users (id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); ");

	    statement.executeUpdate();
	    // Personal tables
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS professeurs (id int primary key auto_increment, firstname varchar(100), lastname varchar(100), listGommettes varchar(100)); ");
	    statement.executeUpdate();
	    statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS eleves (id int primary key auto_increment, firstname varchar(100), lastname varchar(100), listGommettes varchar(100)); ");
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

            statement = connection.prepareStatement("INSERT INTO eleves(firstname, lastname, listGommettes) VALUES(?, ?, ?);");
            statement.setString(1, "Enzo");
            statement.setString(2, "Durel");
	    statement.setString(3, "1");
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

	    statement = connection.prepareStatement("INSERT INTO gommettesAttribuees(id_student, id_prof, id_gommette, date, behavior) VALUES(?, ?, ?, ?, ?);");
            statement.setInt(1, 2);
            statement.setInt(2, 6);
	    statement.setInt(3, 3);
	    statement.setString(4, "1/12");
	    statement.setString(5, "fait le poirier avec la voisine");
            statement.executeUpdate();

	    statement = connection.prepareStatement("INSERT INTO gommettesAttribuees(id_student, id_prof, id_gommette, date, behavior) VALUES(?, ?, ?, ?, ?);");
            statement.setInt(1, 1);
            statement.setInt(2, 45);
	    statement.setInt(3, 3);
	    statement.setString(4, "1/12");
	    statement.setString(5, "il est mort");
            statement.executeUpdate();    
	    
            statement = connection.prepareStatement("INSERT INTO professeurs(firstname, lastname, listGommettes) VALUES(?, ?, ?);");
	    statement.setString(1, "C");
	    statement.setString(2, "Bastien");
	    statement.setString(3, "1;2;3");
            statement.executeUpdate();
	    
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}
