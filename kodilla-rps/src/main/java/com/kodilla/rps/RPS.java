package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RPS {
// rzeczy do porawienia
//Scanner scan = new Scanner(System.in);
//    constructor
    //przejrzeć i wywalić co niepotrzebne

    private String name;
    private int rounds;
    private String playerScore;
    private String cpuScore;
    private String playerChoice;



    public void insertNamePlease() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please insert your name:");
        String firstName = scan.next();
        name = firstName;
    }

    public void correctNumberChecker() {
        boolean correctNumber = false;
        while (!correctNumber) {
            Scanner scan2 = new Scanner(System.in);
            System.out.println("Please insert the number of won rounds we will play:");
            if (scan2.hasNextInt()) {
                rounds = Integer.parseInt(scan2.next());
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

    public String playTheGame() {
        int tryCounter = 1;
        int playerWin = 0;
        int cpuWin = 0;
        boolean end = false;
        while (!end) {
            System.out.println("Round " + tryCounter);
            System.out.println("Rock(1)-Paper(2)-Scissors(3)? Your move!");

            boolean correctChoice = false;
            while(!correctChoice) {
                Scanner play = new Scanner(System.in);
                String choice = play.next();
                if((choice.equals("1")||choice.equals("2")||choice.equals("3"))) {
                    playerChoice = choice;
                    correctChoice = true;
                } else {
                    System.out.println("Try again!");
                }
            }

            Random random = new Random();
            int randomNumber = random.nextInt(1, 4);
            String cpuChoice = String.valueOf(randomNumber);

            if (playerChoice.equals(cpuChoice)) {
                System.out.println("You chose: " + playerChoice + "  Computer chose: " + cpuChoice);
                System.out.println("It's a Tie!");
                System.out.println("Player: " + playerWin + "  Computer: " + cpuWin);
                System.out.println();
            } else if ((playerChoice.equals("1") && cpuChoice.equals("3")) || (playerChoice.equals("3") && cpuChoice.equals("2")) ||
                    (playerChoice.equals("2") && cpuChoice.equals("1"))) {
                playerWin++;
                System.out.println("You chose: " + playerChoice + "  Computer chose: " + cpuChoice);
                System.out.println("This round was won by the player!");
                System.out.println("Player: " + playerWin + "  Computer: " + cpuWin);
                System.out.println();
            } else {
                cpuWin++;
                System.out.println("You chose: " + playerChoice + "  Computer chose: " + cpuChoice);
                System.out.println("This round was won by the computer!");
                System.out.println("Player: " + playerWin + "  Computer: " + cpuWin);
                System.out.println();
            }
            tryCounter++;

            if (playerWin == rounds || cpuWin == rounds) {
                end = true;
            }

        }
        System.out.println("FINAL RESULTS!");
        System.out.println("Player: " + playerWin + "  Computer: " + cpuWin);
        String whoWin = (playerWin>cpuWin) ? "Congratulations! You win!" : "Sorry! Game over! Computer win!";
        System.out.println(whoWin);
        return whoWin;
    }

    public void whatIsNext() {
        System.out.println();
        System.out.println("If you want to quit press key \"x\".");
        System.out.println("If you want to start new game key \"n\".");
        boolean correctFinalDecision = false;
        while (!correctFinalDecision) {
            Scanner scan3 = new Scanner(System.in);
            String finalChoice = scan3.next();
            if (finalChoice.equals("x")) {
                System.out.println("Thank you and see you soon!");
                correctFinalDecision = true;
            } else if (finalChoice.equals("n")) {
                insertNamePlease();
                correctNumberChecker();
                playTheGame();
            } else {
                System.out.println("If you want to quit press key \"x\".");
                System.out.println("If you want to start new game key \"n\".");
            }
        }
    }
}