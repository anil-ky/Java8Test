package com.java8.test;

public class PaymentAPI {

    public static void main(String[] args) {
        PaymentAPI paymentAPI = new PaymentAPI();
        paymentAPI.validateCustomer("test");
    }

    public boolean deposit(String customerName, int amount) {
        validateCustomer(customerName);
        checkAccount(customerName);
        return true;
    }

    public boolean withdraw(String customerName, int amount) {
        validateCustomer(customerName);
        checkAccount(customerName);

        return true;
    }

    private void validateCustomer(String name) {
        System.out.println("verify");
    }

    private void checkAccount(String account) {

    }
}
