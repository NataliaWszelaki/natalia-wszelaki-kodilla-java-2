package com.kodilla.good.patterns.food2door;

public class CustomerOrderProcess implements OrderProcess {

    public boolean orderProcessing(final Customer customer, final FoodProducer foodProducer) {
        System.out.println("The order was completed for: " + customer.toString()
                + " by: " + foodProducer.getCompanyName());

        return true;
    }
}
