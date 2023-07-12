package com.kodilla.good.patterns.food2door;

import java.util.Set;

public class HealthyShop implements FoodProducer {

    private final String companyName;
    private final Set<ProductQuantity> productList;

    public HealthyShop(final String companyName, final Set<ProductQuantity> productList) {
        this.companyName = companyName;
        this.productList = productList;
    }

    public String getCompanyName() {

        return companyName;
    }

    @Override
    public Set<ProductQuantity> getProductList() {

        return productList;
    }

    @Override
    public boolean process(Customer customer, Set<ProductQuantity> productList) {

        double discount = customer.getName().length() * 0.01;
        return true;
    }
}
