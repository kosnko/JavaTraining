package com.luxoft.jva001p1.oop.bankapp.domain;

import java.util.Arrays;

public class Bank {
    private Client[] clients = new Client[0];

    public Client[] getClients() {
        return Arrays.copyOf(clients, clients.length);
    }

    public void addClient(Client client){
        clients = Arrays.copyOf(clients, clients.length+1);
        clients[clients.length - 1] = client;

    }
}
