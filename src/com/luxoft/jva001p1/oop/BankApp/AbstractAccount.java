package com.luxoft.jva001p1.oop.bankapp;

public abstract class AbstractAccount implements Account{
    private int id;
    protected double balance;

    public AbstractAccount() {
    }

    public AbstractAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void setBalance(double balance) {
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
