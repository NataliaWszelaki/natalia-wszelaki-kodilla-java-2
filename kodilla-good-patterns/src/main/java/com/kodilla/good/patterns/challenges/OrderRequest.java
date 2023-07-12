package com.kodilla.good.patterns.challenges;

public class OrderRequest {

    private final Customer customer;
    private final Order order;

    public OrderRequest(Customer customer, Order order) {
        this.customer = customer;
        this.order = order;
    }

    public Customer getCustomer() {

        return customer;
    }

    public Order getOrder() {

        return order;
    }
}
