package com.kodilla.good.patterns.food2door;

import java.util.Set;

public class FoodOrderRequestRetriever {

    public FoodOrderRequest retrieve() {

        Customer customer = new Customer("Emilie", "Perk");
        ProductQuantity productQuantity = new ProductQuantity(new Product("Apples",2.3), 100);
        ExtraFoodShop extraFoodShop = new ExtraFoodShop("Extra Food Shop Ltd.", Set.of(productQuantity));
        return new FoodOrderRequest(customer, extraFoodShop);
    }
}
