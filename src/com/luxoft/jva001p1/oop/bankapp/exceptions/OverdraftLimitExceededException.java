package com.luxoft.jva001p1.oop.bankapp.exceptions;

import com.luxoft.jva001p1.oop.bankapp.Account;

public class OverdraftLimitExceededException extends NotEnoughFundsException {
    private double overdraft;

    public OverdraftLimitExceededException(Account accont, double overdraft) {
        super(accont);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }
}
