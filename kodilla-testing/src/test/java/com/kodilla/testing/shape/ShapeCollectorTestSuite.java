package com.kodilla.testing.shape;

import com.kodilla.testing.shape.*;
import org.junit.jupiter.api.*;


@DisplayName("TDD - Shape Collector")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Adding and removing tests")
    class AddAndRemoveTests {
        @Test
        void testAdd() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector(new Circle());

            //When
            shapeCollector.addFigure(new Circle());

            //Then
            Assertions.assertEquals(1, shapeCollector.getFigureQuantity());
        }

        @Test
        void testRemoveFigureExisting() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector(new Circle());
            shapeCollector.addFigure(new Circle());

            //When
            boolean result = shapeCollector.removeFigure(new Circle());

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getFigureQuantity());
        }
    }
    @Nested
    @DisplayName("Getting and showing tests")
    class GetAndShowTests {
        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector(new Circle());
            shapeCollector.addFigure(new Circle());

            //When
            Shape result = shapeCollector.getFigure(0);
            Shape expectedResult = shapeCollector.getShape();

            //Then
            Assertions.assertEquals(expectedResult, result);

        }

        @Test
        void testShowFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector(new Circle());
            shapeCollector.addFigure(new Circle());
            shapeCollector.addFigure(new Square());
            shapeCollector.addFigure(new Triangle());

            //When
            boolean result = shapeCollector.showFigures();

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(3, shapeCollector.getFigureQuantity());
        }
    }
}
