package com.luxoft.jva001p1.oop.bankapp.service;

import com.luxoft.jva001p1.oop.bankapp.Account;
import com.luxoft.jva001p1.oop.bankapp.Bank;
import com.luxoft.jva001p1.oop.bankapp.Client;
import com.luxoft.jva001p1.oop.bankapp.exceptions.ClientExistsException;

public class BankService {

    public static void addClient(Bank bank, Client client) throws ClientExistsException {
        bank.addClient(client);
    }
    public static void printMaximumAmountToWithdraw(Bank bank){
        for (Client client : bank.getClients()) {
            System.out.println("client: "+client.getName());
            for (Account account : client.getAccounts()) {
                System.out.println("--- MaximumAmountToWithdraw: "+account.maximumAmountToWithdraw());
            }
        }
    }
}
