package com.kodilla.good.patterns.food2door;

public class FoodOrderRequest {

    private Customer customer;
    private ExtraFoodShop extraFoodShop;

    public FoodOrderRequest(Customer customer, ExtraFoodShop extraFoodShop) {
        this.customer = customer;
        this.extraFoodShop = extraFoodShop;
    }

    public Customer getCustomer() {

        return customer;
    }

    public ExtraFoodShop getExtraFoodShop() {


        return extraFoodShop;
    }
}
