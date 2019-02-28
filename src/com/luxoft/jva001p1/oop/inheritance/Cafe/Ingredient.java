package com.luxoft.jva001p1.oop.inheritance.Cafe;

public class Ingredient {
    private String name;
    private double price; //  1 cup

    public Ingredient(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
