package com.luxoft.jva001p1.demos;

public class Pen {
    private String colour;
    private int id;

    public Pen() {
        System.out.println("New pen has been created!");
    }

    public Pen(String colour, int id) {
        this.colour = colour;
        this.id = id;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
