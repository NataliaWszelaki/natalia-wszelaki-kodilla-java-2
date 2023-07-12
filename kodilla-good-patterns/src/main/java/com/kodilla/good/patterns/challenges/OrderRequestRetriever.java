package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.List;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {

        Customer customer = new Customer("John ", "Kowalski ", "Nowa Iwiczna, ul. Kolorowa 4 ");
        Products products = new Products("Mąka", "Pszenna", 5.2,6);
        Order order = new Order("ABC123", List.of(products));
        return new OrderRequest(customer, order);
    }
}
