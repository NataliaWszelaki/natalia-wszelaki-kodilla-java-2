package com.kodilla.good.patterns.food2door;

public class ProductQuantity {

    private final Product product;
    private final int quantity;

    public ProductQuantity(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {

        return product;
    }

    public int getQuantity() {

        return quantity;
    }
}
