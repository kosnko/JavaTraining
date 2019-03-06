package com.luxoft.jva001p1.oop.bankapp;

public abstract class AbstractAccount implements Account{
    private int id;
    private double balance;

    public double getBalance() {
        return balance;
    }
    public void deposite(double x){
        balance += x;
    }
    public void withdraw(double x){
        if (balance >= x){
            balance -= x;
        }
    }
}
