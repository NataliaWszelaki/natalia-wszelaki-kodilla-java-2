package com.kodilla.exception.test;

public class FlightSearchEngineRunner {
    public static void main(String[] args) {

        Flight flight = new Flight("Warsaw", "Larnaka");
        Flight flight1 = new Flight("Berlin", "Larnaka");

        FlightSearchEngine flightSearchEngine = new FlightSearchEngine();

        System.out.println(flight.toString());
        try {
            flightSearchEngine.findFlight(flight);
        }
        catch (RouteNotFoundException e) {
            System.out.println("Search for a different route!");
        }
        finally {
            System.out.println("Travelling is a big thing!");
        }

        System.out.println();

        System.out.println(flight1.toString());
        try {
            flightSearchEngine.findFlight(flight1);
        }
        catch (RouteNotFoundException e) {
            System.out.println("Search for a different route!");
        }
        finally {
            System.out.println("Travelling is a big thing!");
        }
    }
}
