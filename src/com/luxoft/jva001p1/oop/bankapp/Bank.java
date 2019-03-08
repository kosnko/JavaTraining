package com.luxoft.jva001p1.oop.bankapp;

import com.luxoft.jva001p1.oop.bankapp.Client;
import com.luxoft.jva001p1.oop.bankapp.exceptions.ClientExistsException;

import java.util.Arrays;

public class Bank {
    private Client[] clients = new Client[0];
    ClientRegistrationListener[] listeners;
    int printedClients;
    int emailedClients;
    int debuggedClients;

    public Bank() {
        class DebugListener implements ClientRegistrationListener{
            @Override
            public void onClientAdded(Client c) {
                debuggedClients++;
                System.out.println("DEBUG - Client:"+c.getName()+", time: "+System.currentTimeMillis());
            }
        }
        listeners = new ClientRegistrationListener[]{new PrintClientListener(),new EmailNotificationListener(),new DebugListener()};
    }

    public Client[] getClients() {
        return Arrays.copyOf(clients, clients.length);
    }

    public void addClient(Client client) throws ClientExistsException{
        for (Client client1 : clients) {
            if(client1.getName().equals(client.getName())){
                throw new ClientExistsException();
            }
        }
        clients = Arrays.copyOf(clients, clients.length+1);
        clients[clients.length - 1] = client;
        for (ClientRegistrationListener listener : listeners) {
            listener.onClientAdded(client);
        }
    }

    class PrintClientListener implements ClientRegistrationListener{
        public void onClientAdded(Client c){
            printedClients++;
            System.out.println(c.getName());
        }
    }

    class EmailNotificationListener implements ClientRegistrationListener{
        public void onClientAdded(Client c){
            emailedClients++;
            System.out.println("Notification email for client "+c.getName()+" to be sent.");
        }
    }
}
