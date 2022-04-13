package com.uca.entity;

public class GommetteAttribueeEntity {
    private int id;
    private int idStudent;
    private int idGommette;
    private int idProf;
    private String date;
    private String behavior;

    public GommetteAttribueeEntity() {
	// Ignored
    }
    
    // Getters //

    public int getId() {
	return this.id;
    }

    public int getIdStudent() {
	return this.idStudent;
    }

    public int getIdProf() {
	return this.idProf;
    }

    public int getIdGommette() {
	return this.idGommette;
    }

    public String getDate() {
	return this.date;
    }

    public String getBehavior() {
	return this.behavior;
    }

    // Setters //

    public void setId(int id) {
	this.id = id;
    }

    public void setIdStudent(int id) {
	this.idStudent = id;
    }

    public void setIdProf(int id) {
	this.idProf = id;
    }

    public void setIdGommette(int id) {
	this.idGommette = id;
    }

    public void setDate(String date) {
	this.date = date;
    }

    public void setBehavior(String behavior) {
	this.behavior = behavior;
    }
}
