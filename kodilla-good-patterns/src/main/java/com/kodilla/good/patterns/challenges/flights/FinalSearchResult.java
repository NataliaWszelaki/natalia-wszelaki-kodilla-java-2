package com.kodilla.good.patterns.challenges.flights;

public class FinalSearchResult {

    public static void main(String[] args) {

        FlightRequestRetriever flightRequestRetriever = new FlightRequestRetriever();
        FlightRequest flightRequest = flightRequestRetriever.retrieve();
        FlightRouts flightRouts = new FlightRouts();

        FlightsFinder flightsFinder = new FlightsFinder();
        flightsFinder.flightsFinderRunner(flightRouts, flightRequest);
    }
}
