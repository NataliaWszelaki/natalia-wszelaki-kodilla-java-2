package com.kodilla.rps;

import java.util.Random;

public class CPUChoice {

    public static RPSEnum getChoice() {
        Random random = new Random();
        int randomNumber = random.nextInt(1, 4);
        String choice = String.valueOf(randomNumber);
        System.out.println(choice);
        RPSEnum enumChoice = null;
        switch (choice) {
            case "1" -> {
                System.out.println("Computer choice: Rock!");
                enumChoice = RPSEnum.ROCK;
            }
            case "2" -> {
                System.out.println("Computer choice: Paper!");
                enumChoice = RPSEnum.PAPER;
            }
            case "3" -> {
                System.out.println("Computer choice: Scissors!");
                enumChoice = RPSEnum.SCISSORS;
            }
        }
        return enumChoice;
    }
}
