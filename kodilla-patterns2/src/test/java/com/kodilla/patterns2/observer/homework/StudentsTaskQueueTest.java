package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentsTaskQueueTest {

    @Test
    void addTask() {

        //Given
        Mentor janKowalski = new Mentor("Jan Kowalski");
        Mentor danielWhite = new Mentor("Daniel White");
        StudentsTaskQueue johnSmithTaskQueue = new JohnSmithTaskQueue();
        StudentsTaskQueue joannaDarcTaskQueue = new JoannaDArcTaskQueue();
        String task = "Task 24.1 Facade";
        String task2 = "Task 24.2 decorator";
        String task3 = "Task 24.3 AOP";
        johnSmithTaskQueue.registerMentor(janKowalski);
        joannaDarcTaskQueue.registerMentor(danielWhite);

        //When
        johnSmithTaskQueue.addTask(task);
        johnSmithTaskQueue.addTask(task2);
        johnSmithTaskQueue.addTask(task3);
        joannaDarcTaskQueue.addTask(task);
        joannaDarcTaskQueue.addTask(task2);

        //Then
        assertEquals(3, janKowalski.getUpdateCount());
        assertEquals(2, danielWhite.getUpdateCount());
    }

    @Test
    void registerMentor() {

        //Given
        Mentor janKowalski = new Mentor("Jan Kowalski");
        StudentsTaskQueue joannaDarcTaskQueue = new JoannaDArcTaskQueue();

        //When
        joannaDarcTaskQueue.registerMentor(janKowalski);

        //Then
        assertEquals(1, joannaDarcTaskQueue.getMentorObserverList().size());
    }

    @Test
    void notifyMentor() {

        //Given
        Mentor danielWhite = new Mentor("Daniel White");
        StudentsTaskQueue johnSmithTaskQueue = new JohnSmithTaskQueue();
        johnSmithTaskQueue.registerMentor(danielWhite);

        //When
        johnSmithTaskQueue.notifyMentor();

        //Then
        assertEquals(1, danielWhite.getUpdateCount());
    }

    @Test
    void removeMentor() {

        //Given
        Mentor janKowalski = new Mentor("Jan Kowalski");
        StudentsTaskQueue joannaDarcTaskQueue = new JoannaDArcTaskQueue();
        joannaDarcTaskQueue.registerMentor(janKowalski);

        //When
        joannaDarcTaskQueue.removeMentor(janKowalski);

        //Then
        assertEquals(0, joannaDarcTaskQueue.getMentorObserverList().size());
    }
}