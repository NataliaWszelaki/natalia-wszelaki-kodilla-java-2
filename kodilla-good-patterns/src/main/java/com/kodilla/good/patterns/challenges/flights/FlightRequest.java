package com.kodilla.good.patterns.challenges.flights;

import java.util.Objects;

public class FlightRequest {

    private String searchCity;

    public FlightRequest(String searchCity) {
        this.searchCity = searchCity;
    }

    public String getSearchCity() {

        return searchCity;
    }

    public void setSearchCity(String searchCity) {

        this.searchCity = searchCity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightRequest that)) return false;
        return Objects.equals(searchCity, that.searchCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchCity);
    }
}