package com.uca.entity;

import java.util.ArrayList;

public class ProfesseurEntity {

    private int id;
    private String lastname;
    private String firstname;
    private String classe;
    private ArrayList<GommetteAttribueeEntity> listGommettes;

    public ProfesseurEntity(String lastname, String firstname, int id) {
	this.lastname = lastname;
	this.firstname = firstname;
	this.id = id;
    }

    // Getters //

    public int getId() {
	return this.id;
    }

    public String getLastName() {
	return this.lastname;
    }

    public String getFirstName() {
	return this.firstname;
    }

    public String getClasse() {
	return this.classe;
    }

    public GommetteAttribueeEntity getGommette(int index) {
	GommetteAttribueeEntity gA = new GommetteAttribueeEntity();
	try {
	    gA = this.listGommettes.get(index);
	}
	catch (Exception e) {
	    System.out.println("Index invalide");
	}
	return gA;
    }

    // Setters //

    public void setId(int id) {
	this.id = id;
    }

    public void setLastName(String lastname) {
	this.lastname = lastname;
    }

    public void setFirstName(String firstname) {
	this.firstname = firstname;
    }

    public void setClasse(String classe) {
	this.classe = classe;
    }

    public void setGommette(GommetteAttribueeEntity src) {
	this.listGommettes.add(src);
    }
}
