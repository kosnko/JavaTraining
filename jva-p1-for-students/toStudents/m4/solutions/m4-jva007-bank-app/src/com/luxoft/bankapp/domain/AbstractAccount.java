package com.luxoft.bankapp.domain;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;

public abstract class AbstractAccount extends Indexed implements Account
{

    protected double balance;

    public AbstractAccount(int id, double balance)
    {
        this.balance = balance;
        setId(id);
    }

    @Override
    public void deposit(final double amount)
    {
        if (amount < 0)
        {
            throw new IllegalArgumentException("Cannot deposit a negative amount");
        }
        balance += amount;
    }

    @Override
    public void withdraw(final double amount) throws NotEnoughFundsException
    {
        if (amount < 0)
        {
            throw new IllegalArgumentException("Cannot withdraw a negative amount");
        }

        if (amount > maximumAmountToWithdraw())
        {
            throw new NotEnoughFundsException(getId(), balance, amount, "Requested amount exceeds the maximum amount to withdraw");
        }

        balance -= amount;
    }

    @Override
    public double getBalance()
    {
        return balance;
    }

}
