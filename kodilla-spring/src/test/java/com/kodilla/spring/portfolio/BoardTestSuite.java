package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {

        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When & Then
        String toDoListTask = "New task";
        String inProgressTask = "Check the progress";
        String doneListTask = "Completed task";
        board.getToDoList().taskAdd(0, toDoListTask);
        board.getInProgressList().taskAdd(0, inProgressTask);
        board.getDoneList().taskAdd(0, doneListTask);

        //Then
        Assertions.assertEquals(toDoListTask, board.getToDoList().getTasks().get(0));
        Assertions.assertEquals(inProgressTask, board.getInProgressList().getTasks().get(0));
        Assertions.assertEquals(doneListTask, board.getDoneList().getTasks().get(0));
    }
}
