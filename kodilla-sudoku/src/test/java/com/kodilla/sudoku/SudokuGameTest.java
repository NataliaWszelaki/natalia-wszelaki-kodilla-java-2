package com.kodilla.sudoku;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SudokuGameTest {

    @Mock
    UserInputHandler userInputHandlerMock;

    @Test
    void shouldRecoverBoard() throws CloneNotSupportedException {

        //Given
        SudokuGame sudokuGame = new SudokuGame(new Scanner(in));
        Deque<Backtrack> backtrack = new ArrayDeque<>();
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 2, 1));
        backtrack.offerFirst(new Backtrack(sudokuBoard.deepCopy(), new GuessedValue(0, 0, 9)));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 2, 1));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 3, 1));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 4, 1));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 5, 1));
        backtrack.offerFirst(new Backtrack(sudokuBoard.deepCopy(), new GuessedValue(8, 8, 8)));

        //When
        sudokuGame.recoverBoard(backtrack);

        //Then
        assertEquals(1, backtrack.size());
        assertEquals(9, backtrack.getLast().getGuessedValue().getValue());
        assertEquals(-1, backtrack.getLast().getSudokuBoard().getSudokuBoard().get(0).getSudokuRow().get(0).getValue());
        assertEquals(1, backtrack.getLast().getSudokuBoard().getSudokuBoard().get(0).getSudokuRow().get(2).getValue());
        assertEquals(-1, backtrack.getLast().getSudokuBoard().getSudokuBoard().get(0).getSudokuRow().get(5).getValue());
    }

    @Test
    void recoverBoardEmptyBacktrack() {

        //Given
        SudokuGame sudokuGame = new SudokuGame(new Scanner(in));
        Deque<Backtrack> backtrack = new ArrayDeque<>();

        //When
        boolean result = sudokuGame.recoverBoard(backtrack);

        //Then
        assertFalse(result);
    }

    @Test
    void completingSudokuBoardByUser() {

        //Given
        String simulatedInput = "SUDOKU";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        SudokuGame sudokuGame = new SudokuGame(new Scanner(inputStream));
        SudokuBoard sudokuBoard = new SudokuBoard();
        UserInputHandler userInputHandler = new UserInputHandler();

        //When
        sudokuGame.completingSudokuBoardByUser(userInputHandler, sudokuBoard);

        //Then
        System.out.println(sudokuBoard);
    }


    @Test
    void testCompletingSudokuBoardByUser() {

        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        String[] inputs = {"1,2,3", "2,3,4", "SUDOKU"};
        SudokuGame sudokuGame = new SudokuGame(new Scanner(in));

        //When
        when(userInputHandlerMock.getInput(eq(sudokuBoard), any(Scanner.class)))
                .thenReturn("Correct values")
                .thenReturn("Correct values")
                .thenReturn("SUDOKU");
        when(userInputHandlerMock.retrieveValues())
                .thenReturn(new GuessedValue(1, 2, 3))
                .thenReturn(new GuessedValue(2, 3, 4));

        for (String input : inputs) {
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            sudokuGame.completingSudokuBoardByUser(userInputHandlerMock, sudokuBoard);
        }

        //Then
        verify(userInputHandlerMock, times(5)).getInput(eq(sudokuBoard), any(Scanner.class));
        verify(userInputHandlerMock, times(2)).retrieveValues();
    }

    @Test
    void testCompletingBoardByAppSudokuBoardShouldBeSolved() throws SudokuUnsolvableException, CloneNotSupportedException {

        //Given
        SudokuGame sudokuGame = new SudokuGame(new Scanner(in));
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 0, 5));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 1, 3));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 2, 1));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 3, 6));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 4, 7));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 5, 2));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 6, 9));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 7, 4));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 8, 8));
        sudokuBoard.addNumberToBoard(new GuessedValue(1, 0, 6));
        sudokuBoard.addNumberToBoard(new GuessedValue(1, 5, 1));
        sudokuBoard.addNumberToBoard(new GuessedValue(1, 6, 2));
        sudokuBoard.addNumberToBoard(new GuessedValue(2, 2, 7));
        sudokuBoard.addNumberToBoard(new GuessedValue(2, 3, 5));
        sudokuBoard.addNumberToBoard(new GuessedValue(2, 4, 4));
        sudokuBoard.addNumberToBoard(new GuessedValue(2, 5, 9));
        sudokuBoard.addNumberToBoard(new GuessedValue(2, 7, 3));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 1, 5));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 2, 3));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 4, 8));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 6, 1));
        sudokuBoard.addNumberToBoard(new GuessedValue(4, 1, 1));
        sudokuBoard.addNumberToBoard(new GuessedValue(4, 8, 4));
        sudokuBoard.addNumberToBoard(new GuessedValue(5, 2, 6));
        sudokuBoard.addNumberToBoard(new GuessedValue(5, 7, 2));
        sudokuBoard.addNumberToBoard(new GuessedValue(6, 2, 5));
        sudokuBoard.addNumberToBoard(new GuessedValue(6, 6, 4));
        sudokuBoard.addNumberToBoard(new GuessedValue(6, 8, 2));
        sudokuBoard.addNumberToBoard(new GuessedValue(7, 0, 9));
        sudokuBoard.addNumberToBoard(new GuessedValue(7, 4, 1));
        sudokuBoard.addNumberToBoard(new GuessedValue(7, 5, 5));
        sudokuBoard.addNumberToBoard(new GuessedValue(7, 6, 3));
        sudokuBoard.addNumberToBoard(new GuessedValue(8, 1, 7));
        sudokuBoard.addNumberToBoard(new GuessedValue(8, 4, 2));
        sudokuBoard.addNumberToBoard(new GuessedValue(8, 6, 5));
        sudokuBoard.addNumberToBoard(new GuessedValue(8, 8, 6));
        SudokuSolvingAlgorithm sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);

        //When
        sudokuGame.completingBoardByApp(sudokuBoard, sudokuSolvingAlgorithm);
        int totalSumOfNumbers = sudokuBoard.getSudokuBoard().stream()
                .flatMap(row -> row.getSudokuRow().stream())
                .mapToInt(SudokuElement::getValue)
                .sum();
                
        //Then
        assertEquals(405, totalSumOfNumbers);
    }

    @Test
    void testCompletingBoardByAppExceptionShouldBeThrown() throws SudokuUnsolvableException, CloneNotSupportedException {

        //Given
        SudokuGame sudokuGame = new SudokuGame(new Scanner(in));
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 0, 5));
        sudokuBoard.addNumberToBoard(new GuessedValue(1, 0, 5));
        SudokuSolvingAlgorithm sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);

        //When
        sudokuGame.completingBoardByApp(sudokuBoard, sudokuSolvingAlgorithm);

        //Then
        System.out.println(sudokuBoard);
    }

    @Test
    void testCompletingBoardByAppSudokuBoardShouldBeSolved2() throws SudokuUnsolvableException, CloneNotSupportedException {

        //Given
        SudokuGame sudokuGame = new SudokuGame(new Scanner(in));
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 1, 2));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 3, 5));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 5, 1));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 7, 9));
        sudokuBoard.addNumberToBoard(new GuessedValue(1, 0, 8));
        sudokuBoard.addNumberToBoard(new GuessedValue(1, 3, 2));
        sudokuBoard.addNumberToBoard(new GuessedValue(1, 5, 3));
        sudokuBoard.addNumberToBoard(new GuessedValue(1, 8, 6));
        sudokuBoard.addNumberToBoard(new GuessedValue(2, 1, 3));
        sudokuBoard.addNumberToBoard(new GuessedValue(2, 4, 6));
        sudokuBoard.addNumberToBoard(new GuessedValue(2, 7, 7));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 2, 1));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 6, 6));
        sudokuBoard.addNumberToBoard(new GuessedValue(4, 0, 5));
        sudokuBoard.addNumberToBoard(new GuessedValue(4, 1, 4));
        sudokuBoard.addNumberToBoard(new GuessedValue(4, 2, 3));
        sudokuBoard.addNumberToBoard(new GuessedValue(4, 7, 1));
        sudokuBoard.addNumberToBoard(new GuessedValue(4, 8, 9));
        sudokuBoard.addNumberToBoard(new GuessedValue(5, 2, 2));
        sudokuBoard.addNumberToBoard(new GuessedValue(5, 6, 7));
        sudokuBoard.addNumberToBoard(new GuessedValue(6, 1, 9));
        sudokuBoard.addNumberToBoard(new GuessedValue(6, 4, 3));
        sudokuBoard.addNumberToBoard(new GuessedValue(6, 7, 8));
        sudokuBoard.addNumberToBoard(new GuessedValue(7, 0, 2));
        sudokuBoard.addNumberToBoard(new GuessedValue(7, 3, 8));
        sudokuBoard.addNumberToBoard(new GuessedValue(7, 5, 4));
        sudokuBoard.addNumberToBoard(new GuessedValue(7, 8, 7));
        sudokuBoard.addNumberToBoard(new GuessedValue(8, 1, 1));
        sudokuBoard.addNumberToBoard(new GuessedValue(8, 3, 9));
        sudokuBoard.addNumberToBoard(new GuessedValue(8, 5, 7));
        sudokuBoard.addNumberToBoard(new GuessedValue(8, 7, 6));
        sudokuBoard.addNumberToBoard(new GuessedValue(8, 8, 2));
        SudokuSolvingAlgorithm sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);

        //When
        sudokuGame.completingBoardByApp(sudokuBoard, sudokuSolvingAlgorithm);
        sudokuGame.completingBoardByApp(sudokuBoard, sudokuSolvingAlgorithm);
        int totalSumOfNumbers = sudokuBoard.getSudokuBoard().stream()
                .flatMap(row -> row.getSudokuRow().stream())
                .mapToInt(SudokuElement::getValue)
                .sum();

        //Then
        assertEquals(405, totalSumOfNumbers);
    }
}