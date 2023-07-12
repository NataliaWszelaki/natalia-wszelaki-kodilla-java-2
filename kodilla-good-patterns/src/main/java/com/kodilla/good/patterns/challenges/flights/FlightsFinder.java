package com.kodilla.good.patterns.challenges.flights;

import java.util.List;
import java.util.Map;

public class FlightsFinder {

    public void flightsFinderRunner(FlightRouts flightRouts, final FlightRequest flightRequest) {

        System.out.println("Below you will find search results for the city: " + flightRequest.getSearchCity());
        System.out.println("From the city: " + flightRequest.getSearchCity());
        this.flightRoutsFinderFromTheCity(flightRouts, flightRequest);
        System.out.println("To the city: " + flightRequest.getSearchCity());
        this.flightRoutsFinderToTheCity(flightRouts, flightRequest);
        System.out.println("Through the city: " + flightRequest.getSearchCity());
        this.flightRoutsFinderThroughTheCity(flightRouts, flightRequest);
    }
    public void flightRoutsFinderFromTheCity(FlightRouts flightRouts, final FlightRequest flightRequest) {

        List<Flight> searchResultFromTheCity = flightRouts.createFlights().entrySet().stream()
                .filter(e -> e.getValue().equals(true))
                .map(Map.Entry::getKey)
                .filter(e -> e.getDepartureCity().equals(flightRequest.getSearchCity()))
                .toList();
        for (Flight result:searchResultFromTheCity) {
            System.out.println(result.toString());
        }
    }

    public void flightRoutsFinderToTheCity(FlightRouts flightRouts, final FlightRequest flightRequest) {

        List<Flight> searchResultToTheCity = flightRouts.createFlights().entrySet().stream()
                .filter(e -> e.getValue().equals(true))
                .map(Map.Entry::getKey)
                .filter(e -> e.getArrivalCity().equals(flightRequest.getSearchCity()))
                .toList();
        for (Flight result:searchResultToTheCity) {
            System.out.println(result.toString());
        }
    }

    public void flightRoutsFinderThroughTheCity(FlightRouts flightRouts, final FlightRequest flightRequest) {

        List<Flight> searchResultThroughTheCity = flightRouts.createFlights().entrySet().stream()
                .filter(e -> e.getValue().equals(true))
                .map(Map.Entry::getKey)
                .filter(e -> e.getConnectingFlightsCity().equals(flightRequest.getSearchCity()))
                .toList();
        for (Flight result:searchResultThroughTheCity) {
            System.out.println(result.toString());
        }
    }
}
