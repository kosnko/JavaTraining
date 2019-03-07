package com.luxoft.jva001p1.oop.bankapp.domain;

public enum Gender {
    MALE(true), FEMALE(false);
    private boolean isMale;

    Gender(boolean isMale) {
        this.isMale = isMale;
    }

    @Override
    public String toString() {
        return isMale?"Mr.":"Ms.";
    }
}
