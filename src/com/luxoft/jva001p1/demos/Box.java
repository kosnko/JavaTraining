package com.luxoft.jva001p1.demos;

import java.util.Arrays;

public class Box {
    private String name;
    private Pen[] pens  = new Pen[2];

    public Box() {
    }

    public Box(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pen[] getPens() {
        return pens;
    }

    public void setPens(Pen[] pens) {

        this.pens = Arrays.copyOf(pens, pens.length);
    }
}
