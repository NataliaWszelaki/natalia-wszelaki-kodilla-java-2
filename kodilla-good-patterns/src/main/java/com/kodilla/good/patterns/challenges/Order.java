package com.kodilla.good.patterns.challenges;

import java.util.List;

public class Order {
    private final String orderID;
    private List<Products> productsList;

    public Order(final String orderID, List<Products> productsList) {
        this.orderID = orderID;
        this.productsList = productsList;
    }

    public String getOrderID() {

        return orderID;
    }

    public List<Products> getProductsList() {

        return productsList;
    }

    public void addProduct(Products product) {

        productsList.add(product);
    }

    public void removeProduct(Products product) {

        productsList.remove(product);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", productsList=" + productsList +
                '}';
    }
}
