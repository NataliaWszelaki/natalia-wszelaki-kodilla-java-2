package com.kodilla.good.patterns.challenges.flights;

import java.util.HashMap;
import java.util.Map;

public class FlightRequestRetriever {

    public FlightRequest retrieve() {

        Map<Flight, Boolean> flights = new HashMap<>();
        FlightRequest flightRequest = new FlightRequest("Paphos");
        return new FlightRequest("Paphos");
    }
}
