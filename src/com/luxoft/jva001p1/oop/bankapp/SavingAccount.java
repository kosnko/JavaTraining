package com.luxoft.jva001p1.oop.bankapp;

public class SavingAccount extends AbstractAccount {
    public SavingAccount() {
    }

    public SavingAccount(int id, double balance) {
        super(id, balance);
    }

    public double maximumAmountToWithdraw(){
        return balance;
    }

}
