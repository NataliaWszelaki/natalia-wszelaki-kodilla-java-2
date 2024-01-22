package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

import static com.kodilla.sudoku.SudokuElement.EMPTY;


public class SudokuBoard extends Prototype<SudokuBoard> {

    public static String LINE = "   - - - - - - - - - ";
    public static String LINE3 = "   - - -+- - -+- - - ";
    private List<SudokuRow> sudokuBoard = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            sudokuBoard.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getSudokuBoard() {

        return sudokuBoard;
    }

    public void drawBoard() {

        String[] numbersArray = new String[]{"   1 ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 "};
        for (int i = 0; i < 9; i++) {
            System.out.print(numbersArray[i]);
        }
        System.out.println();
        System.out.println(LINE3);
        for (int k = 0; k < 9; k++) {
            System.out.print(k + 1 + " |");
            for (int j = 0; j < 9; j++) {
                String element;
                if (sudokuBoard.get(k).getSudokuRow().get(j).getValue() == EMPTY) {
                    element = " ";
                } else {
                    element = Integer.toString(sudokuBoard.get(k).getSudokuRow().get(j).getValue());
                }
                System.out.print(element + "|");
            }
            if (k % 3 == 2) {
                System.out.println("\n" + LINE3);
            } else {
                System.out.println("\n" + LINE);
            }
        }
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
}
