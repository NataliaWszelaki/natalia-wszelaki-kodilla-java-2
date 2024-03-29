package com.kodilla.sudoku;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class SudokuGame {

    private final Scanner scanner;
    private final Deque<Backtrack> backtrack;

    public SudokuGame(final Scanner scanner) {
        this.scanner = scanner;
        this.backtrack = new ArrayDeque<>();
    }

    public boolean resolveSudoku() throws CloneNotSupportedException, SudokuUnsolvableException {

        boolean isResolved = false;
        while (!isResolved) {
            SudokuBoard sudokuBoard = new SudokuBoard();
            UserInputHandler userInputHandler = new UserInputHandler();
            SudokuSolvingAlgorithm sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);

            userInputHandler.start(sudokuBoard, scanner);
            completingSudokuBoardByUser(userInputHandler, sudokuBoard);

            if (sudokuSolvingAlgorithm.countNumberOfEmptyCells() == 81) {
                System.out.println("Empty board! This Sudoku cannot be solved!");
            } else {
                completingBoardByApp(sudokuBoard, sudokuSolvingAlgorithm);
            }
            boolean nextSteps = userInputHandler.nextSteps(scanner);
            if (nextSteps) {
                isResolved = true;
            } else {
                backtrack.clear();
            }
        }
        return isResolved;
    }

    public void completingSudokuBoardByUser(UserInputHandler userInputHandler, SudokuBoard sudokuBoard) {

        boolean isCompletedSudokuBoardByUser = false;
        while (!isCompletedSudokuBoardByUser) {
            String result = userInputHandler.getInput(sudokuBoard, scanner);
            switch (result) {
                case "SUDOKU":
                    isCompletedSudokuBoardByUser = true;
                    break;
                case "Wrong value":
                    break;
                case "Correct values":
                    GuessedValue guessedValue = userInputHandler.retrieveValues();
                    sudokuBoard.addNumberToBoard(guessedValue);
                    System.out.println(sudokuBoard);
            }
        }
    }

    public void completingBoardByApp(SudokuBoard sudokuBoard, SudokuSolvingAlgorithm sudokuSolvingAlgorithm)
            throws SudokuUnsolvableException, CloneNotSupportedException {

        boolean isFinished = false;
        while (!isFinished) {
            try {
                sudokuSolvingAlgorithm.checkAllLoops();
            } catch (SudokuUnsolvableException e) {
                boolean recoverBoardResult = recoverBoard(backtrack);
                if (!recoverBoardResult) {
                    break;
                }
            }
            if (sudokuSolvingAlgorithm.countNumberOfEmptyCells() == 0) {
                System.out.println("Sudoku has been solved!");
                System.out.println(sudokuBoard);
                isFinished = true;
            } else {
                GuessedValue guessedValue = sudokuSolvingAlgorithm.guessingProcedure();
                backtrack.offerFirst(new Backtrack(sudokuBoard.deepCopy(), guessedValue));
                sudokuBoard.addNumberToBoard(guessedValue);
            }
        }
    }

    public boolean recoverBoard(Deque<Backtrack> backtrack) {

        boolean result = false;
        boolean end = false;
        while (!end) {
            if (backtrack.size() == 0) {
                System.out.println("This Sudoku cannot be solved!");
            } else {
                Backtrack recoveredBacktrack = backtrack.pollFirst();
                SudokuBoard sudokuBoard = recoveredBacktrack.getSudokuBoard();
                GuessedValue guessedValue = recoveredBacktrack.getGuessedValue();
                SudokuElement element = sudokuBoard.getSudokuBoard().get(guessedValue.getRow()).getSudokuRow().get(guessedValue.getColumn());
                if (element.getValuesSet().size() > 1) {
                    element.setValue(SudokuElement.EMPTY);
                    element.getValuesSet().remove(guessedValue.getValue());
                    result = true;
                } else {
                    System.out.println("This Sudoku cannot be solved!");
                }
            }
            end = true;
        }
        return result;
    }
}



