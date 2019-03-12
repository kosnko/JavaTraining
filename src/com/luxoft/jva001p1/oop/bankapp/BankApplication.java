package com.luxoft.jva001p1.oop.bankapp;

//import com.luxoft.jva001p1.oop.bankapp.domain.Account;
import com.luxoft.jva001p1.oop.bankapp.domain.Gender;
import com.luxoft.jva001p1.oop.bankapp.exceptions.BankException;
import com.luxoft.jva001p1.oop.bankapp.exceptions.*;
import com.luxoft.jva001p1.oop.bankapp.service.BankService;

public class BankApplication {

    public static void main(String[] args){
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

        for (int i = 0; i < 7 ; i++) {
            bank.addClient(new Client("client_"+i));
            bank.getClients().get(i).addAccount(new SavingAccount(i,i*200));
            if(i%2 !=0){
                bank.getClients().get(i).setGender(Gender.MALE);
            }else{
                bank.getClients().get(i).setGender(Gender.FEMALE);
            }
        }

            Account newAccount = new AbstractAccount(1,1) {
                @Override
                public double maximumAmountToWithdraw() {

                    return balance;
                }
            };
            System.out.println("newAccount.getBalance() - "+newAccount.getBalance());
        //modifyBank(bank);
        //printBalance(bank);

            bank.addClient(new Client("client_0"));

        Client client = new Client("client_NEW", Gender.MALE);
        BankService.addClient(bank, client);
        //printBalance(bank);

        Account accountCheking = new ChekingAccount(1, 200, 100);
        client.addAccount(accountCheking);
        Account accountSaving = new SavingAccount();
        client.addAccount(accountSaving);
        ((SavingAccount) accountSaving).setBalance(10);

//        printBalance(bank);
//        BankService.printMaximumAmountToWithdraw(bank);
            //accountSaving.withdraw(20);
        accountCheking.withdraw(301);




        }catch (BankException e){
//            if(e instanceof ClientExistsException){
//                throw (ClientExistsException) e;
//            }
            System.out.println(e.getClass().getSimpleName());
            if(e instanceof NotEnoughFundsException){
                System.out.println("Balance: "+((NotEnoughFundsException)e).getAccont().getBalance());
                System.out.println("Maximum amount of money that can be given: "
                        +((NotEnoughFundsException)e).getAccont().maximumAmountToWithdraw());
                if(e instanceof OverdraftLimitExceededException){
                    System.out.println("Overdraft: "+((OverdraftLimitExceededException)e).getOverdraft());
                }
            }

        }
    }

    public static void modifyBank(Bank bank)throws NotEnoughFundsException {
        for (int i = 0; i < 4 ; i++) {
            bank.getClients().get(i).getAccounts()[0].deposite(20);
        }
        for (int i = 4; i < bank.getClients().size() ; i++) {
            bank.getClients().get(i).getAccounts()[0].withdraw(30);
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
