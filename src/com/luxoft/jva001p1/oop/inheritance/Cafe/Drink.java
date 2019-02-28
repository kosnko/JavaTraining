package com.luxoft.jva001p1.oop.inheritance.Cafe;

public class Drink {
    private String name;
    private double price;

    public Drink() {
    }

    public Drink(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
