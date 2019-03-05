package com.luxoft.jva001p1.oop.BankApp;

import java.util.Arrays;

public class Client {
    private String name;
    private Gender gender;
    private Account[] accounts = new Account[0];

    public Client(String name) {
        this.name = name;
    }

    public Client(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Account[] getAccounts() {
        return Arrays.copyOf(accounts, accounts.length);
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account){
        accounts = Arrays.copyOf(accounts, accounts.length+1);
        accounts[accounts.length - 1] = account;
    }

    public void getClientGreeting(){
//        switch (gender){
//            case MALE:
//                System.out.println("Hello"+name);
//                break;
//            case FEMALE:
//                System.out.println("Hello Ms."+name);
//                break;
//        }
        System.out.println("Hello "+gender.toString()+" "+name);
    }
}
