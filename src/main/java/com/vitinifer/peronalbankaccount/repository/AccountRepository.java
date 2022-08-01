package com.vitinifer.peronalbankaccount.repository;

import com.vitinifer.peronalbankaccount.model.Account;
import com.vitinifer.peronalbankaccount.model.Operation;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private List<Account> accounts;

    // Constructor
    public AccountRepository(List<Account> accounts) {
        this.accounts = accounts;
    }

    // Singleton
    // I know this should use DI, but I'm not sure how to do it in Java
    private static AccountRepository instance;

    public static AccountRepository getInstance() {
        if (instance == null) {
            instance = new AccountRepository(new ArrayList<Account>());
        }
        return instance;
    }

    // Getters
    public List<Account> getAccounts() {
        return accounts;
    }

    // Setters
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public Account getAccount(String iban) {
        return accounts.stream()
                .filter(account -> account.getIban().equals(iban))
                .findFirst()
                .get();
    }
    public double getBalance(String iban) {
        return getAccount(iban)
                .getBalance();
    }

    public List<Operation> getOperations(String iban) {
        return getAccount(iban)
                .getOperations();
    }
}
