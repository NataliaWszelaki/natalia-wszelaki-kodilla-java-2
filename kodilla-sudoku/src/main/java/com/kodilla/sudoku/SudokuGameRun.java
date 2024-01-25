package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGameRun {
    public static void main(String[] args) throws CloneNotSupportedException, SudokuUnsolvableException {

        boolean gameFinished = false;
        while (!gameFinished) {

            Scanner scanner = new Scanner(System.in);
            SudokuGame theGame = new SudokuGame(scanner);
            gameFinished = theGame.resolveSudoku();
            scanner.close();
        }
    }
}