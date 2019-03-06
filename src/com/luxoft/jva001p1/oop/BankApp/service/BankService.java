package com.luxoft.jva001p1.oop.bankapp.service;

import com.luxoft.jva001p1.oop.bankapp.domain.Bank;
import com.luxoft.jva001p1.oop.bankapp.Client;

public class BankService {

    public static void addClient(Bank bank, Client client){
        bank.addClient(client);
    }
}
