package com.luxoft.jva001p1.oop.inheritance.Machines;

public class Vehicle extends Machine {

    private String Number;

    public Vehicle() {
        setObjectName("Vehicle");
        setPurpose("Transport");
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
