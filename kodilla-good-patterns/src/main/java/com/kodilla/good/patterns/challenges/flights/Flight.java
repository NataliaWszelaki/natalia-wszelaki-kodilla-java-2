package com.kodilla.good.patterns.challenges.flights;

import java.util.Objects;

public class Flight {

    private String flightNumber;
    private String departureCity;
    private String ConnectingFlightsCity;
    private String arrivalCity;

    public Flight(String flightNumber, String departureCity, String connectingFlightsCity, String arrivalCity) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        ConnectingFlightsCity = connectingFlightsCity;
        this.arrivalCity = arrivalCity;
    }

    public String getFlightNumber() {

        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {

        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {

        return departureCity;
    }

    public void setDepartureCity(String departureCity) {

        this.departureCity = departureCity;
    }

    public String getConnectingFlightsCity() {

        return ConnectingFlightsCity;
    }

    public void setConnectingFlightsCity(String connectingFlightsCity) {

        ConnectingFlightsCity = connectingFlightsCity;
    }

    public String getArrivalCity() {

        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Flight flight)) return false;
        return Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(departureCity, flight.departureCity) && Objects.equals(ConnectingFlightsCity, flight.ConnectingFlightsCity) && Objects.equals(arrivalCity, flight.arrivalCity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(flightNumber, departureCity, ConnectingFlightsCity, arrivalCity);
    }

    @Override
    public String toString() {

        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", ConnectingFlightsCity='" + ConnectingFlightsCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                '}';
    }
}
