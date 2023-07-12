package com.kodilla.good.patterns.food2door;

public class FoodOrderProcessor {

    private final ProducerRepository producerRepository;
    private final OrderProcess orderProcess;

    public FoodOrderProcessor(final ProducerRepository producerRepository, final OrderProcess orderProcess) {
         this.producerRepository = producerRepository;
         this.orderProcess = orderProcess;
    }

    public OrderDto execute(final FoodOrderRequest foodOrderRequest){

        producerRepository.addProducerToSystem(foodOrderRequest.getExtraFoodShop());
        boolean isCompleted = foodOrderRequest.getExtraFoodShop().process(foodOrderRequest.getCustomer(),
                foodOrderRequest.getExtraFoodShop().getProductList());
        if(isCompleted) {
            orderProcess.orderProcessing(foodOrderRequest.getCustomer(),
                    foodOrderRequest.getExtraFoodShop());
            return new OrderDto(foodOrderRequest.getCustomer(), foodOrderRequest.getExtraFoodShop(), true);
        } else {
            return new OrderDto(foodOrderRequest.getCustomer(), foodOrderRequest.getExtraFoodShop(), false);
        }
    }
}
