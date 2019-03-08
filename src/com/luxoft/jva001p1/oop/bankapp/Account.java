package com.luxoft.jva001p1.oop.bankapp;

import com.luxoft.jva001p1.oop.bankapp.exceptions.NotEnoughFundsException;

public interface Account {
    public void deposite(double x);
    void withdraw(double x) throws NotEnoughFundsException;
    double getBalance();
    double maximumAmountToWithdraw();
}