package com.luxoft.jva001p1.oop.inheritance.Machines;

public class Computer extends Machine {

    private String Password = null;

    public Computer() {
        setObjectName("Computer");
        setPurpose("Calculations");
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
