package com.kodilla.good.patterns.food2door;

import java.util.Set;

public class ExtraFoodShop implements FoodProducer {

    private final String companyName;
    private final Set<ProductQuantity> productList;

    public ExtraFoodShop(final String companyName, final Set<ProductQuantity> productList) {
        this.companyName = companyName;
        this.productList = productList;
    }

    public String getCompanyName() {

        return companyName;
    }

    public Set<ProductQuantity> getProductList() {

        return productList;
    }

    @Override
    public boolean process(Customer customer, Set<ProductQuantity> productList) {

        System.out.println("Dear Customer " + customer.getName() + "! We will call you and help you to complete an order.");
        return true;
    }
}
