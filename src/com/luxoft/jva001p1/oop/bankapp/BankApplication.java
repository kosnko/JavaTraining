package com.luxoft.jva001p1.oop.bankapp;

//import com.luxoft.jva001p1.oop.bankapp.domain.Account;
import com.luxoft.jva001p1.oop.bankapp.domain.Gender;
import com.luxoft.jva001p1.oop.bankapp.exceptions.BankException;
import com.luxoft.jva001p1.oop.bankapp.service.BankService;

public class BankApplication {

    public static void main(String[] args) {
        try {
            Bank bank = new Bank();
//        for (int i = 0; i < 7 ; i++) {
//            bank.addClient(new Client("client_"+i));
//            bank.getClients()[i].addAccount(new Account(i,i*200));
//            if(i%2 !=0){
//                bank.getClients()[i].setGender(Gender.MALE);
//            }else{
//                bank.getClients()[i].setGender(Gender.FEMALE);
//            }
//        }
//        modifyBank(bank);
//        printBalance(bank);

            Client client = new Client("client_NEW", Gender.MALE);
            BankService.addClient(bank, client);
            //printBalance(bank);

            Account account = new ChekingAccount(1, 200, 100);
            client.addAccount(account);
            Account accountSaving = new SavingAccount();
            client.addAccount(accountSaving);
            ((SavingAccount) accountSaving).setBalance(10);

//        printBalance(bank);
//
//        BankService.printMaximumAmountToWithdraw(bank);
        }catch (BankException e){

        }
    }

    public static void modifyBank(Bank bank){
        for (int i = 0; i < 4 ; i++) {
            bank.getClients()[i].getAccounts()[0].deposite(20);
        }
        for (int i = 4; i < bank.getClients().length ; i++) {
            bank.getClients()[i].getAccounts()[0].withdraw(30);
        }
    }

    public static void printBalance(Bank bank){
        for (Client c :bank.getClients()) {
            System.out.println(c.getName());
            c.getClientGreeting();
            for (Account account :c.getAccounts() ) {
                System.out.println(" ... "+account.getBalance());
            }
        }
    }
}
