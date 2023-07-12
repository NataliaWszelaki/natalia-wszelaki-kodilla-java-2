package com.kodilla.good.patterns.challenges;

import java.util.Objects;

public class Products {

    private final String productName;
    private final String productDescription;
    private final double productPrice;
    private final int quantity;

    public Products(final String productName, final String productDescription, final double productPrice,
                    final int quantity) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public String getProductName() {

        return productName;
    }

    public String getProductDescription() {

        return productDescription;
    }

    public double getProductPrice() {

        return productPrice;
    }

    public int getQuantity() {

        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products products)) return false;
        return Double.compare(products.productPrice, productPrice) == 0 && quantity == products.quantity && Objects.equals(productName, products.productName) && Objects.equals(productDescription, products.productDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productDescription, productPrice, quantity);
    }

    @Override
    public String toString() {
        return "Products{" +
                "productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", quantity=" + quantity +
                '}';
    }
}