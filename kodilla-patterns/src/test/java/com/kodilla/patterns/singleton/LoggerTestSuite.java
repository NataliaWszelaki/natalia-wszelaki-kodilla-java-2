package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void createLog() {
        logger = Logger.INSTANCE;
        logger.log("WARNING! This is message 5!");
    }

    @AfterAll
            public static void closeLogs() {
        System.out.println("Last log added.");
    }

    @Test
    void testGetLastLog() {
        //Given
        //When
        String lastLogTest = logger.getLastLog();
        System.out.println("Last log: " + lastLogTest);
        //Then
        assertEquals("WARNING! This is message 5!", lastLogTest);
    }
}
