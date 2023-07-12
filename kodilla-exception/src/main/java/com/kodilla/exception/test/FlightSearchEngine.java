package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearchEngine {

    public void findFlight(Flight flight) throws RouteNotFoundException{

        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Barcelona", true);
        airports.put("Warsaw", true);
        airports.put("Pafos", true);
        airports.put("Larnaka", false);
        airports.put("Nikozja", false);

        if (airports.containsKey(flight.getDepartureAirport()) && airports.containsKey(flight.getArrivalAirport())) {
            System.out.println("Is there an option to fly from: " + flight.getDepartureAirport() + "?: "
                    + airports.get(flight.getDepartureAirport()));
            System.out.println("Is there an option to fly to: " + flight.getArrivalAirport() + "?: "
                            + airports.get(flight.getArrivalAirport()));
        } else {
            throw new RouteNotFoundException("Route not found!");
        }
    }
}
