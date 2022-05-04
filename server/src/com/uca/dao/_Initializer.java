package com.uca.dao;

import java.sql.*;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();

        try {
            PreparedStatement statement;


		 //Ceer si n'existe pas !
        statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users (id int primary key auto_increment, statut varchar(100), username varchar(100), password varchar(100), firstname varchar(100), lastname varchar(100)); ");
	    statement.executeUpdate();
        statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS professeurs (id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); ");
	    statement.executeUpdate();
	    statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS eleves (id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); ");
	    statement.executeUpdate();
	    statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS gommettes (id int primary key auto_increment, color varchar(100), description varchar(100)); ");
	    statement.executeUpdate();
	    statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS gommettesAttribuees (id int primary key auto_increment, id_student int, id_prof int, id_gommette int, date varchar(100), behavior varchar(100)); ");
	    statement.executeUpdate();

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
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users (id int primary key auto_increment, statut varchar(100), username varchar(100), password varchar(100), firstname varchar(100), lastname varchar(100)); ");
	    statement.executeUpdate();
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS professeurs (id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); ");
	    statement.executeUpdate();
	    statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS eleves (id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); ");
	    statement.executeUpdate();
	    statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS gommettes (id int primary key auto_increment, color varchar(100), description varchar(100)); ");
	    statement.executeUpdate();
	    statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS gommettesAttribuees (id int primary key auto_increment, id_student int, id_prof int, id_gommette int, date varchar(100), behavior varchar(100)); ");
	    statement.executeUpdate();

        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}
