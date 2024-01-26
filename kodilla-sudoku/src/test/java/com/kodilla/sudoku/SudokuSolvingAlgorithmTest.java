package com.kodilla.sudoku;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SudokuSolvingAlgorithmTest {

    private SudokuSolvingAlgorithm sudokuSolvingAlgorithm;
    private SudokuBoard sudokuBoard;

    @Test
    void checkRows() throws SudokuUnsolvableException {

        //Given
        sudokuBoard = new SudokuBoard();
        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(3,0,1));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,2,2));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,5,3));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,7,4));

        //When
        sudokuSolvingAlgorithm.checkRows();

        //Then
        assertEquals(1, sudokuBoard.getSudokuBoard().get(3).getSudokuRow().get(0).getValue());
        assertEquals(-1, sudokuBoard.getSudokuBoard().get(3).getSudokuRow().get(1).getValue());
        assertEquals(5, sudokuBoard.getSudokuBoard().get(3).getSudokuRow().get(1).getValuesSet().size());
    }

    @Test
    void checkRowsShouldAddLastNumberInTheRow() throws SudokuUnsolvableException {

        //Given
        sudokuBoard = new SudokuBoard();
        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(3,0,1));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,1,2));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,2,3));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,3,4));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,4,5));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,5,6));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,6,7));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,7,8));

        //When
        sudokuSolvingAlgorithm.checkRows();

        //Then
        assertEquals(9, sudokuBoard.getSudokuBoard().get(3).getSudokuRow().get(8).getValue());
        assertEquals(0, sudokuBoard.getSudokuBoard().get(3).getSudokuRow().get(8).getValuesSet().size());
    }

    @Test
    void checkRowsShouldThrowExceptionDuplicatedNumber() {

        //Given
        sudokuBoard = new SudokuBoard();
        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 0, 1));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 1, 2));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 2, 3));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 3, 4));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 4, 5));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 5, 6));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 6, 7));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 7, 8));
        Set<Integer> testValuesSet = new HashSet<>();
        testValuesSet.add(1);
        sudokuBoard.getSudokuBoard().get(3).getSudokuRow().set(8, new SudokuElement(SudokuElement.EMPTY, testValuesSet));

        //When&Then
        assertThrows(SudokuUnsolvableException.class, () ->sudokuSolvingAlgorithm.checkRows());
    }

    @Test
    void checkRowsShouldThrowExceptionEmptyCellEmptyValuesSet() {

        //Given
        sudokuBoard = new SudokuBoard();
        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 0, 1));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 1, 2));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 2, 3));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 3, 4));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 4, 5));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 5, 6));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 6, 7));
        sudokuBoard.addNumberToBoard(new GuessedValue(3, 7, 8));
        Set<Integer> testValuesSet = new HashSet<>();
        sudokuBoard.getSudokuBoard().get(3).getSudokuRow().set(8, new SudokuElement(SudokuElement.EMPTY, testValuesSet));

        //When&Then
        assertThrows(SudokuUnsolvableException.class, () ->sudokuSolvingAlgorithm.checkRows());
    }

    @Test
    void checkRowsShouldThrowExceptionTheSameNumbersInTheRow() {

        //Given
        sudokuBoard = new SudokuBoard();

        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 0, 5));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 1, 5));

        //When&Then
        assertThrows(SudokuUnsolvableException.class, () ->sudokuSolvingAlgorithm.checkRows());
    }

    @Test
    void checkColumns() throws SudokuUnsolvableException {

        //Given
        sudokuBoard = new SudokuBoard();
        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(0,3,1));
        sudokuBoard.addNumberToBoard(new GuessedValue(2,3,2));
        sudokuBoard.addNumberToBoard(new GuessedValue(5,3,3));
        sudokuBoard.addNumberToBoard(new GuessedValue(7,3,4));

        //When
        sudokuSolvingAlgorithm.checkColumns();

        //Then
        assertEquals(1, sudokuBoard.getSudokuBoard().get(0).getSudokuRow().get(3).getValue());
        assertEquals(-1, sudokuBoard.getSudokuBoard().get(1).getSudokuRow().get(3).getValue());
        assertEquals(5, sudokuBoard.getSudokuBoard().get(1).getSudokuRow().get(3).getValuesSet().size());
    }

    @Test
    void checkColumnsShouldAddLastNumberInTheColumn() throws SudokuUnsolvableException {

        //Given
        sudokuBoard = new SudokuBoard();
        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(0,3,1));
        sudokuBoard.addNumberToBoard(new GuessedValue(1,3,2));
        sudokuBoard.addNumberToBoard(new GuessedValue(2,3,3));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,3,4));
        sudokuBoard.addNumberToBoard(new GuessedValue(4,3,5));
        sudokuBoard.addNumberToBoard(new GuessedValue(5,3,6));
        sudokuBoard.addNumberToBoard(new GuessedValue(6,3,7));
        sudokuBoard.addNumberToBoard(new GuessedValue(7,3,8));

        //When
        sudokuSolvingAlgorithm.checkColumns();

        //Then
        assertEquals(9, sudokuBoard.getSudokuBoard().get(8).getSudokuRow().get(3).getValue());
        assertEquals(0, sudokuBoard.getSudokuBoard().get(8).getSudokuRow().get(3).getValuesSet().size());
    }

    @Test
    void checkColumnsShouldThrowExceptionDuplicatedNumber() {

        //Given
        sudokuBoard = new SudokuBoard();
        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(0,3,1));
        sudokuBoard.addNumberToBoard(new GuessedValue(1,3,2));
        sudokuBoard.addNumberToBoard(new GuessedValue(2,3,3));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,3,4));
        sudokuBoard.addNumberToBoard(new GuessedValue(4,3,5));
        sudokuBoard.addNumberToBoard(new GuessedValue(5,3,6));
        sudokuBoard.addNumberToBoard(new GuessedValue(6,3,7));
        sudokuBoard.addNumberToBoard(new GuessedValue(7,3,8));
        Set<Integer> testValuesSet = new HashSet<>();
        testValuesSet.add(8);
        sudokuBoard.getSudokuBoard().get(8).getSudokuRow().set(3, new SudokuElement(SudokuElement.EMPTY, testValuesSet));

        //When&Then
        assertThrows(SudokuUnsolvableException.class, () ->sudokuSolvingAlgorithm.checkColumns());
    }

    @Test
    void checkColumnsShouldThrowExceptionEmptyCellEmptyNumber() {

        //Given
        sudokuBoard = new SudokuBoard();
        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(0,3,1));
        sudokuBoard.addNumberToBoard(new GuessedValue(1,3,2));
        sudokuBoard.addNumberToBoard(new GuessedValue(2,3,3));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,3,4));
        sudokuBoard.addNumberToBoard(new GuessedValue(4,3,5));
        sudokuBoard.addNumberToBoard(new GuessedValue(5,3,6));
        sudokuBoard.addNumberToBoard(new GuessedValue(6,3,7));
        sudokuBoard.addNumberToBoard(new GuessedValue(7,3,8));
        Set<Integer> testValuesSet = new HashSet<>();
        sudokuBoard.getSudokuBoard().get(8).getSudokuRow().set(3, new SudokuElement(SudokuElement.EMPTY, testValuesSet));

        //When&Then
        assertThrows(SudokuUnsolvableException.class, () ->sudokuSolvingAlgorithm.checkColumns());
    }

    @Test
    void checkColumnShouldThrowExceptionTheSameNumbersInTheColumn() {

        //Given
        sudokuBoard = new SudokuBoard();

        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(1, 1, 5));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 1, 5));

        //When&Then
        assertThrows(SudokuUnsolvableException.class, () ->sudokuSolvingAlgorithm.checkColumns());
    }

    @Test
    void checkBlock() throws SudokuUnsolvableException {

        //Given
        sudokuBoard = new SudokuBoard();
        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(0,0,1));
        sudokuBoard.addNumberToBoard(new GuessedValue(0,1,2));
        sudokuBoard.addNumberToBoard(new GuessedValue(1,0,3));
        sudokuBoard.addNumberToBoard(new GuessedValue(2,2,4));
        int row = 0;
        int column = 0;

        //When
        sudokuSolvingAlgorithm.checkBlock(row, column);

        //Then
        assertEquals(1, sudokuBoard.getSudokuBoard().get(0).getSudokuRow().get(0).getValue());
        assertEquals(-1, sudokuBoard.getSudokuBoard().get(1).getSudokuRow().get(2).getValue());
        assertEquals(5, sudokuBoard.getSudokuBoard().get(1).getSudokuRow().get(2).getValuesSet().size());
    }

    @Test
    void checkBlockShouldAddLastNumberInTheBlock() throws SudokuUnsolvableException {

        //Given
        sudokuBoard = new SudokuBoard();
        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(0,0,1));
        sudokuBoard.addNumberToBoard(new GuessedValue(0,1,2));
        sudokuBoard.addNumberToBoard(new GuessedValue(0,2,3));
        sudokuBoard.addNumberToBoard(new GuessedValue(1,0,4));
        sudokuBoard.addNumberToBoard(new GuessedValue(1,1,5));
        sudokuBoard.addNumberToBoard(new GuessedValue(1,2,6));
        sudokuBoard.addNumberToBoard(new GuessedValue(2,0,7));
        sudokuBoard.addNumberToBoard(new GuessedValue(2,1,8));
        int row = 0;
        int column = 0;

        //When
        sudokuSolvingAlgorithm.checkBlock(row, column);

        //Then
        assertEquals(9, sudokuBoard.getSudokuBoard().get(2).getSudokuRow().get(2).getValue());
        assertEquals(0, sudokuBoard.getSudokuBoard().get(2).getSudokuRow().get(2).getValuesSet().size());
    }

    @Test
    void checkBlockThrowExceptionDuplicatedNumber() {

        //Given
        sudokuBoard = new SudokuBoard();
        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(0,0,1));
        sudokuBoard.addNumberToBoard(new GuessedValue(0,1,2));
        sudokuBoard.addNumberToBoard(new GuessedValue(0,2,3));
        sudokuBoard.addNumberToBoard(new GuessedValue(1,0,4));
        sudokuBoard.addNumberToBoard(new GuessedValue(1,1,5));
        sudokuBoard.addNumberToBoard(new GuessedValue(1,2,6));
        sudokuBoard.addNumberToBoard(new GuessedValue(2,0,7));
        sudokuBoard.addNumberToBoard(new GuessedValue(2,1,8));
        Set<Integer> testValuesSet = new HashSet<>();
        testValuesSet.add(7);
        sudokuBoard.getSudokuBoard().get(2).getSudokuRow().set(2, new SudokuElement(SudokuElement.EMPTY, testValuesSet));
        int row = 0;
        int column = 0;

        //When&Then
        assertThrows(SudokuUnsolvableException.class, () ->sudokuSolvingAlgorithm.checkBlock(row, column));
    }

    @Test
    void checkBlockThrowExceptionEmptyCellEmptyValuesSet() {

        //Given
        sudokuBoard = new SudokuBoard();
        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(0,0,1));
        sudokuBoard.addNumberToBoard(new GuessedValue(0,1,2));
        sudokuBoard.addNumberToBoard(new GuessedValue(0,2,3));
        sudokuBoard.addNumberToBoard(new GuessedValue(1,0,4));
        sudokuBoard.addNumberToBoard(new GuessedValue(1,1,5));
        sudokuBoard.addNumberToBoard(new GuessedValue(1,2,6));
        sudokuBoard.addNumberToBoard(new GuessedValue(2,0,7));
        sudokuBoard.addNumberToBoard(new GuessedValue(2,1,8));
        Set<Integer> testValuesSet = new HashSet<>();
        sudokuBoard.getSudokuBoard().get(2).getSudokuRow().set(2, new SudokuElement(SudokuElement.EMPTY, testValuesSet));
        int row = 0;
        int column = 0;

        //When&Then
        assertThrows(SudokuUnsolvableException.class, () ->sudokuSolvingAlgorithm.checkBlock(row, column));
    }

    @Test
    void checkBlockShouldThrowExceptionTheSameNumbersInTheBlock() {

        //Given
        sudokuBoard = new SudokuBoard();

        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 0, 5));
        sudokuBoard.addNumberToBoard(new GuessedValue(0, 1, 5));

        //When&Then
        assertThrows(SudokuUnsolvableException.class, () ->sudokuSolvingAlgorithm.checkBlock(0,0));
    }

    @Test
    void checkAllLoopsShouldThrowException() {

        //Given
        sudokuBoard = new SudokuBoard();

        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(1, 0, 5));
        sudokuBoard.addNumberToBoard(new GuessedValue(1, 1, 5));

        //When&Then
        assertThrows(SudokuUnsolvableException.class, () ->sudokuSolvingAlgorithm.checkAllLoops());
    }

    @Test
    void guessingProcedure() throws SudokuUnsolvableException {

        //Given
        sudokuBoard = new SudokuBoard();
        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(3,5,1));
        sudokuBoard.addNumberToBoard(new GuessedValue(8,1,2));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,7,3));
        sudokuBoard.addNumberToBoard(new GuessedValue(4,3,4));
        sudokuBoard.addNumberToBoard(new GuessedValue(2,4,5));
        sudokuBoard.addNumberToBoard(new GuessedValue(1,5,6));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,6,7));
        sudokuBoard.addNumberToBoard(new GuessedValue(0,7,8));
        sudokuBoard.addNumberToBoard(new GuessedValue(4,5,1));
        sudokuBoard.addNumberToBoard(new GuessedValue(7,1,2));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,0,3));
        sudokuBoard.addNumberToBoard(new GuessedValue(7,3,4));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,4,5));
        sudokuBoard.addNumberToBoard(new GuessedValue(1,8,6));
        sudokuBoard.addNumberToBoard(new GuessedValue(3,8,7));
        sudokuBoard.addNumberToBoard(new GuessedValue(0,2,8));

        //When
        GuessedValue guessedValue = sudokuSolvingAlgorithm.guessingProcedure();

        //Then
        System.out.println(guessedValue);
    }

    @Test
    void shouldCountNumberOfEmptyCells() {

        //Given
        sudokuBoard = new SudokuBoard();
        sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        sudokuBoard.addNumberToBoard(new GuessedValue(0,3,1));
        sudokuBoard.addNumberToBoard(new GuessedValue(2,2,2));
        sudokuBoard.addNumberToBoard(new GuessedValue(5,8,3));
        sudokuBoard.addNumberToBoard(new GuessedValue(7,1,4));

        //When
        long emptyCells = sudokuSolvingAlgorithm.countNumberOfEmptyCells();

        //Then
        assertEquals(77L, emptyCells);
    }
}