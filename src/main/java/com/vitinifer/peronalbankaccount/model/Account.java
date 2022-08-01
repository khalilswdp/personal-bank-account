package com.vitinifer.peronalbankaccount.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String name;
    private String iban;
    private double balance;
    private List<Operation> operations;

    // Constructor
    public Account(String name, String iban, double balance) {
        this.name = name;
        this.iban = iban;
        this.balance = balance;
        this.operations = new ArrayList<Operation>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getIban() {
        return iban;
    }

    public double getBalance() {
        return balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    // Setters
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addOperation(Operation operation) {
        this.operations.add(operation);
    }

    // toString

    @Override
    public String toString() {
        return "Account [name=" + name + ", iban=" + iban + ", balance=" + balance + ", operations=" + operations + "]";
    }

    public static class AccountBuilder {
        private String name;
        private String iban;
        private double balance;

        public AccountBuilder(String name, String iban, double balance) {
            this.name = name;
            this.iban = iban;
            this.balance = balance;
        }

        public AccountBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AccountBuilder iban(String iban) {
            this.iban = iban;
            return this;
        }

        public AccountBuilder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public Account build() {
            return new Account(name, iban, balance);
        }
    }
}
