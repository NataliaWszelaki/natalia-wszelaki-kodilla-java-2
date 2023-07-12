package com.kodilla.good.patterns.food2door;

import java.util.Set;

public interface FoodProducer {

    boolean process(Customer customer, Set<ProductQuantity>productList);
    String getCompanyName();
    Set<ProductQuantity> getProductList();
}
