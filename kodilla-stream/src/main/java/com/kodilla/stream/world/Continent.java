package com.kodilla.stream.world;

import java.util.*;

public final class Continent {

    private final String continentName;
    private final List<Country> countries = new ArrayList<>();

    public Continent(final String continentName) {
        this.continentName = continentName;
    }

    public String getContinentName() {
        return continentName;
    }

    public List<Country> getCountries() {
        return countries;
    }
    public void addCountry(Country country) {
        countries.add(country);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Continent continent)) return false;
        return Objects.equals(continentName, continent.continentName) && Objects.equals(countries, continent.countries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(continentName, countries);
    }

    @Override
    public String toString() {
        return "Continent{" +
                "continentName='" + continentName + '\'' +
                ", countries=" + countries +
                '}';
    }
}