package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    private final InformationService informationService;
    private  final OrderRepository orderRepository;
    private final OrderProcessing orderProcessing;

    public ProductOrderService(final InformationService informationService,
                               final OrderRepository orderRepository,
                               final OrderProcessing orderProcessing) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
        this.orderProcessing = orderProcessing;
    }

    public OrderDto process(OrderRequest orderRequest) {

        boolean isReadyToShip = orderProcessing.packed(orderRequest.getCustomer(), orderRequest.getOrder());
        if(isReadyToShip) {
            informationService.informCustomer(orderRequest.getCustomer());
            orderRepository.upDateStatus(orderRequest.getCustomer(), orderRequest.getOrder());
            return new OrderDto(orderRequest.getCustomer(), orderRequest.getOrder(), true);
        } else {
            return new OrderDto(orderRequest.getCustomer(), orderRequest.getOrder(), false);
        }
    }
}
