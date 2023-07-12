package com.kodilla.good.patterns.food2door;

public class FoodProducerRepository implements ProducerRepository {
    @Override
    public boolean addProducerToSystem(FoodProducer foodProducer) {

        System.out.println("Food Producer has been added to the System: " + foodProducer.getCompanyName());
        return true;
    }
}
