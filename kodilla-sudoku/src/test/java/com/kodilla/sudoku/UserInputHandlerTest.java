package com.kodilla.sudoku;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


class UserInputHandlerTest {

    @Test
    void nextSteps() {

        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        String simulatedInput = "q";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner scanner = new Scanner(inputStream);
        UserInputHandler userInputHandler = new UserInputHandler(sudokuBoard, scanner);

        //When
        boolean answer = userInputHandler.nextSteps();

        //Then
        assertTrue(answer);
    }
}