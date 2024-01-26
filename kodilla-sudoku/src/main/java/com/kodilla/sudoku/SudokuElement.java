package com.kodilla.sudoku;

import java.util.*;


public class SudokuElement {
    public static final int EMPTY = -1;
    private int value;
    private Set<Integer> valuesSet = new HashSet<>();

    public SudokuElement(int value) {
        this.value = value;
        for (int i = 1; i < 10; i++) {
            valuesSet.add(i);
        }
    }

    public SudokuElement(int value, Set<Integer> valuesSet) {
        this.value = value;
        this.valuesSet = valuesSet;
    }

    public int getValue() {

        return value;
    }

    public void setValue(int value) {

        this.value = value;
    }

    public Set<Integer> getValuesSet() {

        return valuesSet;
    }

    public void lastNumberInValuesSet() {

        setValue(valuesSet.iterator().next());
            valuesSet.clear();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof SudokuElement that)) return false;
        return value == that.value && Objects.equals(valuesSet, that.valuesSet);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value, valuesSet);
    }
}
