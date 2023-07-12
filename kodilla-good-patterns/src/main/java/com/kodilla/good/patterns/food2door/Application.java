package com.kodilla.good.patterns.food2door;

import java.util.Set;

public class Application {

    public static void main(String[] args) {

        FoodOrderRequestRetriever foodOrderRequestRetriever = new FoodOrderRequestRetriever();
        FoodOrderRequest foodOrderRequest = foodOrderRequestRetriever.retrieve();

        FoodOrderProcessor foodOrderProcessor = new FoodOrderProcessor(new FoodProducerRepository(), new CustomerOrderProcess());
        foodOrderProcessor.execute(foodOrderRequest);

    }
}
