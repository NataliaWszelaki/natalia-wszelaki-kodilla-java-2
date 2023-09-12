package com.kodilla.rps;

import java.util.Scanner;

public class PlayerChoice {

    public static RPSEnum getChoice() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Rock(1)-Paper(2)-Scissors(3)? Your move!");
            String choice = scan.next();
            switch (choice) {
                case "1" -> {
                    System.out.println("Your choice: Rock!");
                    return RPSEnum.ROCK;
                }
                case "2" -> {
                    System.out.println("Your choice: Paper!");
                    return RPSEnum.PAPER;
                }
                case "3" -> {
                    System.out.println("Your choice: Scissors!");
                    return RPSEnum.SCISSORS;
                }
                default -> System.out.println("Try again!");
            }
        }
    }
}
