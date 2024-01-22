package com.kodilla.sudoku;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


class SudokuGameTest {

    @Test
    void shouldRecoverBoard() throws CloneNotSupportedException {

        //Given
        SudokuGame sudokuGame = new SudokuGame(new Scanner(System.in));
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
        SudokuGame sudokuGame = new SudokuGame(new Scanner(System.in));
        Deque<Backtrack> backtrack = new ArrayDeque<>();

        //When
        boolean result = sudokuGame.recoverBoard(backtrack);

        //Then
        assertFalse(result);
    }
}
