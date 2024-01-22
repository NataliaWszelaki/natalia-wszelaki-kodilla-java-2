package com.kodilla.sudoku;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class SudokuGame {

    private SudokuBoard sudokuBoard;
    private final Scanner scanner;
    private final UserInputHandler userInputHandler;
    private final SudokuSolvingAlgorithm sudokuSolvingAlgorithm;
    private final Deque<Backtrack> backtrack;

    public SudokuGame(Scanner scanner) {
        this.scanner = scanner;
        this.sudokuBoard = new SudokuBoard();
        this.userInputHandler = new UserInputHandler(sudokuBoard, scanner);
        this.sudokuSolvingAlgorithm = new SudokuSolvingAlgorithm(sudokuBoard);
        this.backtrack = new ArrayDeque<>();
    }

    public boolean resolveSudoku() throws CloneNotSupportedException, SudokuUnsolvableException {

        boolean isResolved = false;
        while (!isResolved) {
            userInputHandler.start();
            sudokuBoard = completingSudokuBoardByUser();
            boolean isFinished = false;
            while (!isFinished) {
                try {
                    sudokuSolvingAlgorithm.checkAllLoops();
                } catch (SudokuUnsolvableException e) {
                    if (!recoverBoard(backtrack)) {
                        isFinished = true;
                    }
                    if (sudokuSolvingAlgorithm.countNumberOfEmptyCells() == 0) {
                        System.out.println("Solved sudoku!");
                        sudokuBoard.drawBoard();
                        isFinished = true;
                    }
                    GuessedValue guessedValue = sudokuSolvingAlgorithm.guessingProcedure();
                    backtrack.offerFirst(new Backtrack(sudokuBoard.deepCopy(), guessedValue));
                    sudokuBoard.addNumberToBoard(guessedValue);
                }
            }
            if (userInputHandler.nextSteps()) {
                isResolved = true;
            } else {
                backtrack.clear();
            }
        }
        return isResolved;
    }

    public SudokuBoard completingSudokuBoardByUser() {

        boolean isCompletedSudokuBoardByUser = false;
        while (!isCompletedSudokuBoardByUser) {
            String result = userInputHandler.getInput();
            switch (result) {
                case "SUDOKU":
                    isCompletedSudokuBoardByUser = true;
                    break;
                case "Wrong value":
                    break;
                case "Correct values":
                    GuessedValue guessedValue = userInputHandler.retrieveValues();
                    sudokuBoard.addNumberToBoard(guessedValue);
                    sudokuBoard.drawBoard();
            }
        }
        return sudokuBoard;
    }

    public boolean recoverBoard(Deque<Backtrack> backtrack) {

        boolean result = false;
        boolean end = false;
        while (!end) {
            if (backtrack.size() == 0) {
                System.out.println("This Sudoku cannot be solved!");
                result = false;
                end = true;
            } else {
                Backtrack recoveredBacktrack = backtrack.pollFirst();
                SudokuBoard sudokuBoard = recoveredBacktrack.getSudokuBoard();
                GuessedValue guessedValue = recoveredBacktrack.getGuessedValue();
                SudokuElement element = sudokuBoard.getSudokuBoard().get(guessedValue.getRow()).getSudokuRow().get(guessedValue.getColumn());
                if (element.getValuesSet().size() > 1) {
                    element.setValue(SudokuElement.EMPTY);
                    element.getValuesSet().remove(guessedValue.getValue());
                    result = true;
                    end = true;
                }
            }
        }
        return result;
    }
}



