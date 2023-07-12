package com.kodilla.good.patterns.challenges;

public interface OrderProcessing {

    boolean paid();
    boolean confirmed();
    boolean packed(Customer customer, Order order);
    boolean sent();
}
