package com.kodilla.sudoku;

import java.util.Random;


public class SudokuSolvingAlgorithm {

    private final SudokuBoard sudokuBoard;

    public SudokuSolvingAlgorithm(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public int checkRows() throws SudokuUnsolvableException {

        int operationsCounterRows = 0;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                SudokuElement element = sudokuBoard.getSudokuBoard().get(row).getSudokuRow().get(col);
                if (element.getValue() == -1) {
                    for (SudokuElement theElement : sudokuBoard.getSudokuBoard().get(row).getSudokuRow()) {
                        if (theElement.getValue() != -1
                                && element.getValuesSet().contains(theElement.getValue())
                                && element.getValuesSet().size() > 1) {
                            element.getValuesSet().remove(theElement.getValue());
                            operationsCounterRows++;
                        } else if (theElement.getValue() != -1
                                && element.getValuesSet().contains(theElement.getValue())
                                && element.getValuesSet().size() == 1) {
                            throw new SudokuUnsolvableException();
                        }
                    }
                    if (element.getValuesSet().size() == 1) {
                        element.lastNumberInValuesSet();
                        operationsCounterRows++;
                    }
                } else {
                    for (SudokuElement theElement : sudokuBoard.getSudokuBoard().get(row).getSudokuRow()) {
                        if(theElement.getValue() == sudokuBoard.getSudokuBoard().get(row).getSudokuRow().get(col).getValue()
                        && theElement != sudokuBoard.getSudokuBoard().get(row).getSudokuRow().get(col)) {
                            throw new SudokuUnsolvableException();
                        }
                    }
                }
                if (element.getValue() == -1
                        && element.getValuesSet().size() == 0) {
                    throw new SudokuUnsolvableException();
                }
            }
        }
        return operationsCounterRows;
    }

    public int checkColumns() throws SudokuUnsolvableException {

        int operationsCounterColumn = 0;
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                SudokuElement element = sudokuBoard.getSudokuBoard().get(row).getSudokuRow().get(col);
                if (element.getValue() == -1) {
                    for (int rowFromTheSameColumn = 0; rowFromTheSameColumn < 9; rowFromTheSameColumn++) {
                        int valueToRemove = sudokuBoard.getSudokuBoard().get(rowFromTheSameColumn).getSudokuRow().get(col).getValue();
                        if (sudokuBoard.getSudokuBoard().get(rowFromTheSameColumn).getSudokuRow().get(col).getValue() != -1
                                && element.getValuesSet().contains(valueToRemove)
                                && element.getValuesSet().size() > 1) {
                            element.getValuesSet().remove(valueToRemove);
                            operationsCounterColumn++;
                        } else if (sudokuBoard.getSudokuBoard().get(rowFromTheSameColumn).getSudokuRow().get(col).getValue() != -1
                                && element.getValuesSet().contains(valueToRemove)
                                && element.getValuesSet().size() == 1) {
                            throw new SudokuUnsolvableException();
                        }
                    }
                    if (element.getValuesSet().size() == 1) {
                        element.lastNumberInValuesSet();
                        operationsCounterColumn++;
                    }
                } else {
                    for (int rowFromTheSameColumn = 0; rowFromTheSameColumn < 9; rowFromTheSameColumn++) {
                        if (element.getValue() == sudokuBoard.getSudokuBoard().get(rowFromTheSameColumn).getSudokuRow().get(col).getValue()
                        && element != sudokuBoard.getSudokuBoard().get(rowFromTheSameColumn).getSudokuRow().get(col)) {
                            throw new SudokuUnsolvableException();
                        }
                    }
                }
                if (element.getValue() == -1
                        && element.getValuesSet().size() == 0) {
                    throw new SudokuUnsolvableException();
                }
            }
        }
        return operationsCounterColumn;
    }

    public int checkBlocks() throws SudokuUnsolvableException {

        int operationsCounterBlocks = 0;
        for (int x = 0; x < 7; x += 3) {
            for (int y = 0; y < 7; y += 3) {
                int blocksOperations = checkBlock(x, y);
                operationsCounterBlocks += blocksOperations;
            }
        }
        return operationsCounterBlocks;
    }

    public int checkBlock(int startRow, int startCol) throws SudokuUnsolvableException {

        int operationsCounterBlock = 0;
        for (int col = startCol; col < startCol + 3; col++) {
            for (int row = startRow; row < startRow + 3; row++) {
                SudokuElement element = sudokuBoard.getSudokuBoard().get(row).getSudokuRow().get(col);
                if (element.getValue() == -1) {
                    for (int j = startCol; j < startCol + 3; j++) {
                        for (int i = startRow; i < startRow + 3; i++) {
                            int valueToRemove = sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getValue();
                            if (sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getValue() != -1
                                    && element.getValuesSet().contains(valueToRemove) && element.getValuesSet().size() > 1) {
                                element.getValuesSet().remove(valueToRemove);
                                operationsCounterBlock++;
                            } else if (sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getValue() != -1
                                    && element.getValuesSet().contains(valueToRemove) && element.getValuesSet().size() == 1) {
                                throw new SudokuUnsolvableException();
                            }
                        }
                        if (element.getValuesSet().size() == 1) {
                            element.lastNumberInValuesSet();
                            operationsCounterBlock++;
                        }
                    }
                } else {
                    for (int j = startCol; j < startCol + 3; j++) {
                        for (int i = startRow; i < startRow + 3; i++) {
                            if (sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getValue() == element.getValue()
                                    && sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j) != element) {
                                throw new SudokuUnsolvableException();
                            }
                        }
                    }
                }
                    if (element.getValue() == -1 && element.getValuesSet().size() == 0) {
                        throw new SudokuUnsolvableException();
                    }
                }
            }
            return operationsCounterBlock;
        }

        public void checkAllLoops () throws SudokuUnsolvableException {

            boolean areAllOperationsDone = false;
            while (!areAllOperationsDone) {
                int rowOperationsResult = checkRows();
                int columnOperationsResult = checkColumns();
                int blocksOperationsResult = checkBlocks();
                if (rowOperationsResult + columnOperationsResult + blocksOperationsResult == 0) {
                    areAllOperationsDone = true;
                }
            }
        }

        public GuessedValue guessingProcedure () throws SudokuUnsolvableException {

            Random random = new Random();
            boolean areRandomValuesGenerated = false;
            int randomRow = 0;
            int randomColumn = 0;
            int randomValue = 0;
            while (!areRandomValuesGenerated) {
                randomRow = random.nextInt(9);
                randomColumn = random.nextInt(9);
                Integer[] valuesSetArray = sudokuBoard.getSudokuBoard().get(randomRow).getSudokuRow().get(randomColumn)
                        .getValuesSet().toArray(new Integer[0]);
                if (sudokuBoard.getSudokuBoard().get(randomRow).getSudokuRow().get(randomColumn).getValue() == -1
                        && valuesSetArray.length > 0) {
                    randomValue = valuesSetArray[random.nextInt(valuesSetArray.length)];
                    areRandomValuesGenerated = true;
                } else if (sudokuBoard.getSudokuBoard().get(randomRow).getSudokuRow().get(randomColumn).getValue() == -1
                        && valuesSetArray.length == 0) {
                    throw new SudokuUnsolvableException();
                }
            }
            return new GuessedValue(randomRow, randomColumn, randomValue);
        }

        public long countNumberOfEmptyCells () {

            return sudokuBoard.getSudokuBoard().stream().flatMap(row -> row.getSudokuRow().stream())
                    .map(SudokuElement::getValue)
                    .filter(v -> v == -1)
                    .count();
        }
    }
