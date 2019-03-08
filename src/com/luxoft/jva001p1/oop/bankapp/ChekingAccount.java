package com.luxoft.jva001p1.oop.bankapp;

import com.luxoft.jva001p1.oop.bankapp.exceptions.NotEnoughFundsException;
import com.luxoft.jva001p1.oop.bankapp.exceptions.OverdraftLimitExceededException;

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
    public void withdraw(double x) throws OverdraftLimitExceededException {
        try{
            super.withdraw(x);
        }catch (NotEnoughFundsException e){
            throw new OverdraftLimitExceededException(this, overdraft);
        }
    }

    public double maximumAmountToWithdraw(){
        return balance + overdraft;
    }
}
