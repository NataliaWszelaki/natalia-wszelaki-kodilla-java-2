package com.kodilla.testing.collection;

import java.util.*;
import java.lang.*;

public class OddNumbersExterminator {

    List<Integer> evenNumbers = new ArrayList<>();

    public int exterminate(List<Integer> numbers) {
        int number = 0;
        for (int n = 0; n < numbers.size(); n++) {
            number = numbers.get(n);

            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        return evenNumbers.size();
    }
}
