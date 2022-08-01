package com.vitinifer.peronalbankaccount.model;

public class Operation {
    private String type;
    private double amount;
    private double balance;

    // Constructor
    public Operation(String type, double amount, double balance) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }

    // Getters
    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    // Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // toString
    @Override
    public String toString() {
        return "Operation{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }

    // Builder
    public static class OperationBuilder {
        private String type;
        private double amount;
        private double balance;

        public OperationBuilder(String type, double amount, double balance) {
            this.type = type;
            this.amount = amount;
            this.balance = balance;
        }

        public OperationBuilder type(String type) {
            this.type = type;
            return this;
        }

        public OperationBuilder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public OperationBuilder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public Operation build() {
            return new Operation(type, amount, balance);
        }
    }

}
