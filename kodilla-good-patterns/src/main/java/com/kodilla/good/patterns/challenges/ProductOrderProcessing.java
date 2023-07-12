package com.kodilla.good.patterns.challenges;

public class ProductOrderProcessing implements  OrderProcessing {
    @Override
    public boolean paid() {

        return false;
    }

    @Override
    public boolean confirmed() {

        return false;
    }

    @Override
    public boolean packed(final Customer customer, final Order order) {

        System.out.println("Order is ready to ship. Order to: " + customer.getName() + customer.getSurname()
                + customer.getAddress() + "Order:" + order.toString());
        return true;
    }

    @Override
    public boolean sent() {

        return false;
    }
}
