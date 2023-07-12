package com.kodilla.good.patterns.challenges.flights;

import java.util.HashMap;
import java.util.Map;

public class FlightRouts {

    public Map<Flight, Boolean> createFlights() {

        Map<Flight, Boolean> flights = new HashMap<>();
        flights.put(new Flight("ABC123", "Paphos", "Athens", "Berlin"), true);
        flights.put(new Flight("QWE234", "Barcelona", "Paphos", "Amman"), true);
        flights.put(new Flight("ASD345", "Athens", "Berlin", "Barcelona"), false);
        flights.put(new Flight("ZXC456", "Berlin", "Paris", "Barcelona"), true);
        flights.put(new Flight("POI567", "Paris", "Rome", "Paphos"), true);
        flights.put(new Flight("LKJ678", "Amman", "Eilat", "Paphos"), false);
        flights.put(new Flight("MNB789", "Rome", "Athens", "Eilat"), true);
        flights.put(new Flight("CVB890", "Berlin", "Rome", "Athens"), true);
        flights.put(new Flight("FGH901", "Rome", "Berlin", "Oslo"), false);
        flights.put(new Flight("RTY012", "Oslo", "Warsaw", "Paphos"), true);
        return flights;
    }
}