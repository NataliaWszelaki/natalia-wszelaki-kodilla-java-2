package com.kodilla.good.patterns.challenges;

public interface OrderRepository {

    boolean createOrder();
    boolean upDateStatus(Customer customer, Order Order);
}
