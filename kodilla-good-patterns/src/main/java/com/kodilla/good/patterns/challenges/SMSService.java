package com.kodilla.good.patterns.challenges;

public class SMSService implements InformationService {

    @Override
    public void informCustomer(Customer customer) {

        System.out.println("Your order is ready to shipment! Check your email for more details.");
    }
}
