package com.luxoft.jva001p1.oop.BankApp;

public class Account {
    private int id;
    private double balance;

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

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
