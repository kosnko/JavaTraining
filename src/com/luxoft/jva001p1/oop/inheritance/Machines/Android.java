package com.luxoft.jva001p1.oop.inheritance.Machines;

public class Android extends Machine { //robot that looks like a human being

    private String name = null;

    public Android() {
        setObjectName("Android");
        setPurpose("People substitution");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
