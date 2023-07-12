package com.kodilla.good.patterns.challenges;

public class Customer {

    private final String name;
    private final String surname;
    private final String address;

    public Customer(final String name, final String surname, final String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public String getName() {

        return name;
    }

    public String getSurname() {

        return surname;
    }

    public String getAddress() {

        return address;
    }
}
