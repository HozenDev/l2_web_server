package com.uca.entity;

public class GommetteEntity {

    private String description;
    private String color;
    private int id;
    
    public GommetteEntity() {}

    // Setters //

    public void setId(int id) {
	this.id = id;
    }

    public void setColor(String color) {
	this.color = color;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    // Getters //

    public int getId() {
	return this.id;
    }

    public String getColor() {
	return this.color;
    }

    public String getDescription() {
	return this.description;
    }

    @Override
    public String toString() {
	return String.format("%s : %s", this.color, this.description);
    }
}
