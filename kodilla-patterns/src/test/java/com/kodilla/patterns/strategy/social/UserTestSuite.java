package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {

        //Given
        User anna = new Millenials("Anna Nowak");
        User jan = new YGeneration("Jan Wredny");
        User bruno = new ZGeneration("Bruno Radosny");

        //When
        String annaShouldPublishAPostOn = anna.sharePost();
        System.out.println("Anna should publish a post on: " + annaShouldPublishAPostOn);
        String janShouldPublishAPostOn = jan.sharePost();
        System.out.println("Jan should publish a post on: " + janShouldPublishAPostOn);
        String brunoShouldPublishAPostOn = bruno.sharePost();
        System.out.println("Bruno should publish a post on: " + brunoShouldPublishAPostOn);

        //Then
        Assertions.assertEquals("Facebook", annaShouldPublishAPostOn);
        Assertions.assertEquals("Twitter", janShouldPublishAPostOn);
        Assertions.assertEquals("Snapchat", brunoShouldPublishAPostOn);
    }

    @Test
    void testIndividualSharingStrategy() {

        //Given
        User anna = new Millenials("Anna Nowak");

        //When
        String annaShouldPublishAPostOn = anna.sharePost();
        System.out.println("Anna should publish a post on: " + annaShouldPublishAPostOn);
        anna.setSocialPublisher(new SnapchatPublisher());
        annaShouldPublishAPostOn = anna.sharePost();
        System.out.println("Now Anna should publish a post on: " + annaShouldPublishAPostOn);

        //Then
        Assertions.assertEquals("Snapchat", annaShouldPublishAPostOn);
    }
}
