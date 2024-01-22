package com.kodilla.sudoku;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SudokuBoardTest {

    private SudokuBoard sudokuBoard;

    @Test
    void addNumberToBoardByUser() {

        //Given
        sudokuBoard = new SudokuBoard();
        GuessedValue guessedValue = new GuessedValue(0,0,1);
        GuessedValue guessedValue1 = new GuessedValue(8,7,9);

        //When
        sudokuBoard.addNumberToBoard(guessedValue);
        sudokuBoard.addNumberToBoard(guessedValue1);

        //Then
        assertEquals(guessedValue.getValue(), sudokuBoard.getSudokuBoard().get(0).getSudokuRow().get(0).getValue());
        assertEquals(guessedValue1.getValue(), sudokuBoard.getSudokuBoard().get(8).getSudokuRow().get(7).getValue());
        assertEquals(-1, sudokuBoard.getSudokuBoard().get(5).getSudokuRow().get(4).getValue());
    }

    @Test
    void deepCopy() throws CloneNotSupportedException {

        //Given
        sudokuBoard = new SudokuBoard();
        sudokuBoard.addNumberToBoard(new GuessedValue(0,0,1));
        sudokuBoard.addNumberToBoard(new GuessedValue(1,1,2));
        sudokuBoard.addNumberToBoard(new GuessedValue(2,2,3));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,3,4));
        sudokuBoard.addNumberToBoard(new GuessedValue(4,4,5));
        sudokuBoard.addNumberToBoard(new GuessedValue(5,5,6));
        sudokuBoard.addNumberToBoard(new GuessedValue(6,6,7));
        sudokuBoard.addNumberToBoard(new GuessedValue(7,7,8));
        sudokuBoard.addNumberToBoard(new GuessedValue(8,8,9));

        //When
        SudokuBoard deepClonedBoard = null;
        try {
            deepClonedBoard = sudokuBoard.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //Then
        sudokuBoard.drawBoard();
        deepClonedBoard.drawBoard();
        assertEquals(9, deepClonedBoard.getSudokuBoard().size());
        assertEquals(9, deepClonedBoard.getSudokuBoard().get(8).getSudokuRow().size());
        assertEquals(9, deepClonedBoard.getSudokuBoard().get(8).getSudokuRow().get(8).getValuesSet().size());

        assertEquals(6, deepClonedBoard.getSudokuBoard().get(5).getSudokuRow().get(5).getValue());
        assertEquals(-1, deepClonedBoard.getSudokuBoard().get(4).getSudokuRow().get(5).getValue());

    }
}