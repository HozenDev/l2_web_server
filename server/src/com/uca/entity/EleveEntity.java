package com.uca.entity;

import java.util.ArrayList;

public class EleveEntity {

    private ArrayList<GommetteAttribueeEntity> listGommettes;
    private int id;
    private String lastName;
    private String firstName;
    
    public EleveEntity() {
	this.listGommettes = new ArrayList<>();
    }

    public String strListGomettes() {
        this.listGommettes.strListGomettes();
    }
    // Getters //
    
    public GommetteAttribueeEntity getGommette(int index) {
	return this.listGommettes.get(index);
    }

    public int getId() {
	return this.id;
    }

    public String getLastName() {
	return this.lastName;
    }

    public String getFirstName() {
	return this.firstName;
    }

    // Setters //

    public void setGommette(GommetteAttribueeEntity src) {
	this.listGommettes.add(src);
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public void setId(int id) {
	this.id = id;
    }
}
