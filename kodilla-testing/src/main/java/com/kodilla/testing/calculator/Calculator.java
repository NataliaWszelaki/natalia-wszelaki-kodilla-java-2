package com.kodilla.testing.calculator;


public class Calculator {
    int a;
    int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int subtractBFromA() {
        return b - a;
    }

    public int addAToB() {
        return a + b;
    }
}
