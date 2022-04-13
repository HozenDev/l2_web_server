package com.uca.entity;

import java.util.ArrayList;

public class ProfesseurEntity {

    private int id;
    private String lastName;
    private String firstName;
    private String classe;
    private ArrayList<GommetteAttribueeEntity> listGommettes;

    public ProfesseurEntity() {
	this.listGommettes = new ArrayList<>();
    }

    // Getters //

    public int getId() {
	return this.id;
    }

    public String getLastName() {
	return this.lastName;
    }

    public String getFirstName() {
	return this.firstName;
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

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public void setClasse(String classe) {
	this.classe = classe;
    }

    public void setGommette(GommetteAttribueeEntity src) {
	this.listGommettes.add(src);
    }
}
