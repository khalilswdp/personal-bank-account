package com.vitinifer.peronalbankaccount.repository;

import com.vitinifer.peronalbankaccount.model.Operation;

import java.util.ArrayList;
import java.util.List;

public class OperationRepository {
    private List<Operation> operations;

    // Constructor
    public OperationRepository(List<Operation> operations) {
        this.operations = operations;
    }

    // Singleton
    // I know this should use DI in order for the application to be scalable, but I'm not sure how to do it in Java
    private static OperationRepository instance;

    public static OperationRepository getInstance() {
        if (instance == null) {
            instance = new OperationRepository(new ArrayList<Operation>());
        }
        return instance;
    }

    // Getters
    public List<Operation> getOperations() {
        return operations;
    }

    // Setters
    public void addOperation(Operation operation) {
        this.operations.add(operation);
    }
}
