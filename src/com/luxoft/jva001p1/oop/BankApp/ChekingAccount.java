package com.luxoft.jva001p1.oop.bankapp;

public class ChekingAccount extends AbstractAccount {

    private double overdraft;
    private double overdraftBalance;

    public ChekingAccount(int id, double balance, double overdraft) {
        super(id, balance);
        this.overdraft = overdraft;
        overdraftBalance = overdraft;
    }

    @Override
    public void withdraw(double x){
        if (balance >= x){
            balance -= x;
        }else{
            double residual = x - balance;
            balance = 0;
            if(residual <= overdraftBalance){
                overdraftBalance -= residual;
            }
        }

    }
}
