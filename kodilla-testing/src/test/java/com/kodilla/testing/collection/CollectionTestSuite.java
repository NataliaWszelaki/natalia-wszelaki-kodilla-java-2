package com.kodilla.testing.collection;
import com.kodilla.testing.collection.OddNumbersExterminator;

import org.junit.jupiter.api.*;
import java.util.*;
import java.lang.*;


public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName(value = "Checking whether the class behaves correctly when the list is empty")

    @Test
    void testOddNumbersExterminatorEmptyList(){

        //Given
        List<Integer> testNumbers = new ArrayList<>();

        OddNumbersExterminator exterminator = new OddNumbersExterminator();

        //When
        int result = exterminator.exterminate(testNumbers);
        System.out.println("Even numbers: " + result);

        //Then
        Assertions.assertEquals(0,result);
    }

    @DisplayName("Checking whether the class behaves correctly when the list contains even and odd numbers")

    @Test
    void testOddNumbersExterminatorNormalList(){

        //Given
        List<Integer> testNumbers = new ArrayList<Integer>();
        testNumbers.add(1);
        testNumbers.add(2);
        testNumbers.add(3);
        testNumbers.add(4);

        OddNumbersExterminator exterminator = new OddNumbersExterminator();

        //When
        int result = exterminator.exterminate(testNumbers);
        System.out.println("Even numbers: " + result);

        //Then
        Assertions.assertEquals(2,result);
    }
}

