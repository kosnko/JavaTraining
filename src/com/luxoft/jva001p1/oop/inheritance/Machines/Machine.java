package com.luxoft.jva001p1.oop.inheritance.Machines;

public class Machine {
    private String objectName;
    private String purpose;

    public Machine() {
        objectName = "Machine";
        purpose = "service";
    }

    public String getObjectName() {
        return objectName;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return objectName;
    }
}
