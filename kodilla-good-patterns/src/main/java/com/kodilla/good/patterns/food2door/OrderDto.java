package com.kodilla.good.patterns.food2door;

public class OrderDto {

    private final Customer customer;
    private final FoodProducer foodProducer;
    private final boolean isCompleted;

    public OrderDto(Customer customer, FoodProducer foodProducer, boolean isCompleted) {
        this.customer = customer;
        this.foodProducer = foodProducer;
        this.isCompleted = isCompleted;
    }

    public Customer getCustomer() {

        return customer;
    }

    public FoodProducer getFoodProducer() {

        return foodProducer;
    }

    public boolean isCompleted() {

        return isCompleted;
    }


}
