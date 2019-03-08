package com.luxoft.jva001p1.oop.bankapp.exceptions;

import com.luxoft.jva001p1.oop.bankapp.Account;

public class NotEnoughFundsException extends BankException{
    private Account accont;

    public NotEnoughFundsException(Account accont) {
        this.accont = accont;
    }

    public Account getAccont() {
        return accont;
    }
}
