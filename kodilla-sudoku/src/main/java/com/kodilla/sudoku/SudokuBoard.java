package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

import static com.kodilla.sudoku.SudokuElement.EMPTY;


public class SudokuBoard extends Prototype<SudokuBoard> {

    public static final String LINE = "   - - - - - - - - - ";
    public static final String LINE3 = "   - - -+- - -+- - - ";
    private List<SudokuRow> sudokuBoard = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            sudokuBoard.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getSudokuBoard() {

        return sudokuBoard;
    }

    public void addNumberToBoard(GuessedValue guessedValue) {

        sudokuBoard.get(guessedValue.getRow()).getSudokuRow().get(guessedValue.getColumn())
                .setValue(guessedValue.getValue());
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {

        SudokuBoard clonedBoard = super.clone();
        clonedBoard.sudokuBoard = new ArrayList<>();
        for (SudokuRow theRow : sudokuBoard) {
            SudokuRow clonedRow = new SudokuRow();
            for (int x = 0; x < 9; x++) {
                clonedRow.getSudokuRow().set(x, new SudokuElement(theRow.getSudokuRow().get(x).getValue(), theRow.getSudokuRow().get(x).getValuesSet()));
            }
            clonedBoard.getSudokuBoard().add(clonedRow);
        }
        return clonedBoard;
    }

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder();
        board.append("   1 2 3 4 5 6 7 8 9 \n");
        board.append(LINE3);

        for (int k = 0; k < 9; k++) {
            board.append("\n").append(k + 1).append(" |");
            for (int j = 0; j < 9; j++) {

                if (sudokuBoard.get(k).getSudokuRow().get(j).getValue() == EMPTY) {
                    board.append(" |");
                } else {
                    board.append(sudokuBoard.get(k).getSudokuRow().get(j).getValue()).append("|");
                }
            }
            if (k % 3 == 2) {
                board.append("\n").append(LINE3);
            } else {
                board.append("\n").append(LINE);
            }
        }
        return board.toString();
    }
}
