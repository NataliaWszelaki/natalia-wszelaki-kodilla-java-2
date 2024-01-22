package com.kodilla.sudoku;

import java.util.Objects;


public class Backtrack {

    private final SudokuBoard sudokuBoard;
    private final GuessedValue guessedValue;

    public Backtrack(SudokuBoard sudokuBoard, GuessedValue guessedValue) {
        this.sudokuBoard = sudokuBoard;
        this.guessedValue = guessedValue;
    }

    public SudokuBoard getSudokuBoard() {

        return sudokuBoard;
    }

    public GuessedValue getGuessedValue() {

        return guessedValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Backtrack backtrack)) return false;
        return Objects.equals(sudokuBoard, backtrack.sudokuBoard) && Objects.equals(guessedValue, backtrack.guessedValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sudokuBoard, guessedValue);
    }
}
