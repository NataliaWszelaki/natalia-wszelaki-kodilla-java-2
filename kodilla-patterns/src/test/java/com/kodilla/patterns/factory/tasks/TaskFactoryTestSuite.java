package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryDriving() {

        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task driving = taskFactory.doTheTask(TaskFactory.DRIVINGTASK);

        //Then
        Assertions.assertEquals("I would like to stay at home", driving.executeTask());
        Assertions.assertEquals("pick up a friend from the airport", driving.getTaskName());
        Assertions.assertTrue(driving.isTaskExecuted());
    }

    @Test
    void testFactoryShopping() {

        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task shopping = taskFactory.doTheTask(TaskFactory.SHOPPINGTASK);

        //Then
        Assertions.assertEquals("I need to buy some veggies", shopping.executeTask());
        Assertions.assertEquals("veggies", shopping.getTaskName());
        Assertions.assertTrue(shopping.isTaskExecuted());
    }

    @Test
    void testFactoryPainting() {

        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task painting = taskFactory.doTheTask(TaskFactory.PAINTINGTASK);

        //Then
        Assertions.assertEquals("I don't like white things", painting.executeTask());
        Assertions.assertEquals("last task", painting.getTaskName());
        Assertions.assertFalse(painting.isTaskExecuted());
    }
}
