package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserInputHandler {

    public final static String INVALID_INPUT = "Invalid input! Try again!";
    public final static String INSERT_MESSAGE = """
            Provide 3 numbers in the range from 1 to 9, separated by commas.\s
            These numbers respectively represent: column, row, and value.
            Type SUDOKU to solve Sudoku.""";
    public final static String OCCUPIED_CELL = "Invalid input. The selected cell is already occupied. Try again!";
    public final static String NEXT_STEP_MESSAGE = "If you want to quit press key - q.\n" +
            "If you want to start new game key - n.";

    protected String answer;

    public void start(SudokuBoard sudokuBoard, Scanner scanner) {

        System.out.println("Welcome to Sudoku!");
        System.out.println();
        System.out.println("Please insert your name:");
        String name = scanner.next();
        System.out.println("Hi, " + name + "!");
        System.out.println("This time you can play only standard Sudoku Game - board 9 x 9.");
        System.out.println();
        System.out.println(sudokuBoard);
    }

    public String getInput(SudokuBoard sudokuBoard, Scanner scanner) {

        System.out.println(INSERT_MESSAGE);
        answer = scanner.next().toUpperCase();
        String result;
        if(answer.equals("SUDOKU")) {
            System.out.println("Application is solving Sudoku! Please wait!");
            result = "SUDOKU";
        } else if (checkTheInput(sudokuBoard)) {
            result = "Correct values";
        } else {
            result = "Wrong value";
        }
        return result;
    }

    public boolean checkTheInput(SudokuBoard sudokuBoard) {

        boolean correctValues = false;
        List<String> numberChecker = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            numberChecker.add(i + "");
        }
        String[] guessedValuesArray = answer.split(",");
        if (guessedValuesArray.length != 3) {
            System.out.println(INVALID_INPUT);
        } else if (!(numberChecker.contains(guessedValuesArray[0]) && numberChecker.contains(guessedValuesArray[1])
                && numberChecker.contains(guessedValuesArray[2]))) {
            System.out.println(INVALID_INPUT);
        } else if (sudokuBoard.getSudokuBoard().get(Integer.parseInt(guessedValuesArray[1]) - 1).getSudokuRow()
                .get(Integer.parseInt(guessedValuesArray[0]) - 1).getValue() != -1) {
            System.out.println(OCCUPIED_CELL);
        } else {
            correctValues = true;
        }
        return correctValues;
    }

    public GuessedValue retrieveValues() {

        String[] guessedValuesArray = answer.split(",");
        int column = Integer.parseInt(guessedValuesArray[0]) - 1;
        int row = Integer.parseInt(guessedValuesArray[1]) - 1;
        int value = Integer.parseInt(guessedValuesArray[2]);
        return new GuessedValue(row, column, value);
    }

    public boolean nextSteps(Scanner scanner) {

        boolean isTheGameOver = false;

        boolean isFinalAnswerCorrect = false;
        while(!isFinalAnswerCorrect) {
            System.out.println(NEXT_STEP_MESSAGE);
            String finalAnswer = scanner.next().toLowerCase();
            if (finalAnswer.equals("q")) {
                System.out.println("Thank you! See you soon!");
                isTheGameOver = true;
                isFinalAnswerCorrect = true;
            } else if (finalAnswer.equals("n")) {
                System.out.println("Have fun!" + "\n");
                isFinalAnswerCorrect = true;
            } else {
                System.out.println(INVALID_INPUT);
            }
        }
        return isTheGameOver;
    }
}


