package com.vitinifer.peronalbankaccount.service;

import com.vitinifer.peronalbankaccount.model.Account;
import com.vitinifer.peronalbankaccount.model.Operation;
import com.vitinifer.peronalbankaccount.repository.AccountRepository;
import com.vitinifer.peronalbankaccount.repository.OperationRepository;

import java.util.List;

public class AccountService {
    private AccountRepository accountRepository;
    private OperationRepository operationRepository;

    private OperationService operationService;

    // Constructor
    public AccountService(AccountRepository accountRepository, OperationRepository operationRepository) {
        this.accountRepository = accountRepository;
        this.operationRepository = operationRepository;
    }

    // Singleton
    // Should use DI in order for the application to be scalable
    private static AccountService instance;

    public static AccountService getInstance() {
        if (instance == null) {
            instance = new AccountService(AccountRepository.getInstance(), OperationRepository.getInstance());
        }
        return instance;
    }


    // Getters
    public Account getAccount(String iban) {
        return accountRepository.getAccount(iban);
    }

    public void addAccount(Account account) {
        accountRepository.addAccount(account);
    }

    public void addOperation(Operation operation) {
        operationRepository.addOperation(operation);
    }

    public List<Operation> getOperations(String iban) {
        return operationService.getOperations(iban);
    }

    public double getBalance(String iban) {
        return accountRepository.getBalance(iban);
    }



}
