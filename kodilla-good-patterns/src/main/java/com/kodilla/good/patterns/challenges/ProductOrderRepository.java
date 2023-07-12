package com.kodilla.good.patterns.challenges;

public class ProductOrderRepository implements OrderRepository {
    @Override
    public boolean createOrder() {

        return false;
    }

    @Override
    public boolean upDateStatus(Customer customer, Order order) {

        return false;
    }
}
