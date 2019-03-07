package com.luxoft.jva001p1.oop.bankapp;

import com.luxoft.jva001p1.oop.bankapp.exceptions.NotEnoughFundsException;

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
        if( x < 0){
            throw new IllegalArgumentException();
        }
        balance += x;
    }
    public void withdraw(double x){
        if( x < 0){
            throw new IllegalArgumentException();
        }
        if (balance >= x){
            balance -= x;
        }else{
            throw new NotEnoughFundsException();
        }
    }




}
