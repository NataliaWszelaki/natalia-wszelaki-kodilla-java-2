package com.kodilla.rps;

import java.util.Scanner;

public class RPSStart {

    private String name;
    private int rounds;

    public int getRounds() {
        return rounds;
    }

    public void run() {
        insertNamePlease();
        howManyRounds();
        printInstruction();
    }

    public void insertNamePlease() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please insert your name:");
        name = scan.next();
    }

    public void howManyRounds() {
        boolean correctNumber = false;
        while (!correctNumber) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please insert the number of won rounds we will play:");
            if (scan.hasNextInt()) {
                rounds = Integer.parseInt(scan.next());
                correctNumber = true;
            } else {
                System.out.println("This is not a number");
            }
        }
    }

    public void printInstruction() {
        System.out.println();
        System.out.println("Below you can find the instructions of the game: \"Rock-Paper-Scissors\":");
        System.out.println("Key \"1\" – play \"rock\",");
        System.out.println("Key \"2\" – play \"paper\",");
        System.out.println("Key \"3\" – play \"scissors\",");
        System.out.println("Key \"x\" – ending the game,");
        System.out.println("Key \"n\" – starting the game again.");
        System.out.println();
        System.out.println(name + "! Let's start the game!");
        System.out.println();
    }
}