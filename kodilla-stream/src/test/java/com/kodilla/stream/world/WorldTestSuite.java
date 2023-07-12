package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity(){
        //Given
        World world = new World();
        Continent europe = new Continent("Europe");
        Continent asia = new Continent("Asia");
        Continent africa = new Continent("Africa");

        Country poland = new Country("Poland", new BigDecimal("36000000"));
        Country cyprus = new Country("Cyprus", new BigDecimal("1000000"));
        Country france = new Country("France", new BigDecimal("66000000"));

        Country china = new Country("China", new BigDecimal("1360000000"));
        Country mongolia = new Country("Mongolia", new BigDecimal("56000000"));
        Country india = new Country("India", new BigDecimal("1560000000"));

        Country egypt = new Country("Egypt", new BigDecimal("100000000"));
        Country rpa = new Country("RPA", new BigDecimal("46000000"));
        Country kongo = new Country("Kongo", new BigDecimal("26000000"));

        europe.addCountry(poland);
        europe.addCountry(cyprus);
        europe.addCountry(france);

        asia.addCountry(china);
        asia.addCountry(mongolia);
        asia.addCountry(india);

        africa.addCountry(egypt);
        africa.addCountry(rpa);
        africa.addCountry(kongo);

        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);

        //When
        BigDecimal peopleQty = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPeopleQuantity = new BigDecimal("3251000000");
        Assertions.assertEquals(expectedPeopleQuantity, peopleQty);
    }

}
