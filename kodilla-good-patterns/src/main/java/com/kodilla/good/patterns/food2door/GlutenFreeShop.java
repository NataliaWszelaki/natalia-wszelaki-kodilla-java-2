package com.kodilla.good.patterns.food2door;

import java.util.Set;

public class GlutenFreeShop implements FoodProducer {

    private final String companyName;
    private final Set<ProductQuantity> productList;

    public GlutenFreeShop(final String companyName, final Set<ProductQuantity> productList) {
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

        double discount = getProductList().size() * 0.05;
        return true;
    }
}
