package com.luxoft.jva001p1.oop.bankapp;

import com.luxoft.jva001p1.oop.bankapp.exceptions.NotEnoughFundsException;

public class ChekingAccount extends AbstractAccount {

    private double overdraft;

    public ChekingAccount(int id, double balance, double overdraft) {
        super(id, balance);
        if(overdraft < 0){
            throw new IllegalArgumentException();
        }
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double x) throws NotEnoughFundsException {
        if( x < 0){
            throw new IllegalArgumentException();
        }
        if (balance + overdraft >= x){
            balance -= x;
        }else{
            throw new NotEnoughFundsException();
        }
    }

    public double maximumAmountToWithdraw(){
        return balance + overdraft;
    }
}
