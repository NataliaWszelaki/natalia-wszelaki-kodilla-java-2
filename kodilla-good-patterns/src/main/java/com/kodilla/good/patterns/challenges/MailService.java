package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService {
    @Override
    public void informCustomer(Customer customer) {

        System.out.println("Your order is ready to shipment! Below you can find more details:...");
    }
}
