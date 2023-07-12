package com.kodilla.good.patterns.challenges;

public class OrderDto {

    private final Customer customer;
    private final Order order;
    private final boolean isReadyToShip;

    public OrderDto(final Customer customer, final Order order, final boolean isReadyToShip) {
        this.customer = customer;
        this.order = order;
        this.isReadyToShip = isReadyToShip;
    }

    public Customer getCustomer() {

        return customer;
    }

    public boolean isReadyToShip() {

        return isReadyToShip;
    }

    public Order getOrder() {

        return order;
    }
}
