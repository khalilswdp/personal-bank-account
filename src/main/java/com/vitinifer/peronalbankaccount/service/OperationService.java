package com.vitinifer.peronalbankaccount.service;

import com.vitinifer.peronalbankaccount.model.Operation;
import com.vitinifer.peronalbankaccount.repository.AccountRepository;
import com.vitinifer.peronalbankaccount.repository.OperationRepository;

import java.util.List;

public class OperationService {

    private OperationRepository operationRepository;
    private AccountRepository accountRepository;

    // Constructor
    public OperationService(OperationRepository operationRepository, AccountRepository accountRepository) {
        this.operationRepository = operationRepository;
        this.accountRepository = accountRepository;
    }

    // Singleton
    // Should use DI in order for the application to be scalable
    private static OperationService instance;

    public static OperationService getInstance() {
        if (instance == null) {
            instance = new OperationService(OperationRepository.getInstance(), AccountRepository.getInstance());
        }
        return instance;
    }

    // Add operation
    public void addOperation(Operation operation) {
        operationRepository.addOperation(operation);
    }

    // Get operations
    public List<Operation> getOperations() {
        return operationRepository.getOperations();
    }

    public List<Operation> getOperations(String iban) {
        return accountRepository.getAccount(iban).getOperations();
    }

}
