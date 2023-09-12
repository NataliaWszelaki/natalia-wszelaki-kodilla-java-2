package com.kodilla.rps;

import java.util.Scanner;

public class NextSteps {
    RPSStart rpsStart = new RPSStart();
    Game game = new Game();
    Scanner scan = new Scanner(System.in);

    public void whatIsNext () {
        System.out.println();
        System.out.println("If you want to quit press key \"x\".");
        System.out.println("If you want to start new game key \"n\".");
        boolean correctFinalDecision = false;
        while (!correctFinalDecision) {
            String finalChoice = scan.next();
            if (finalChoice.equals("x")) {
                System.out.println("Thank you and see you soon!");
                correctFinalDecision = true;
            } else if (finalChoice.equals("n")) {
                rpsStart.run();
                game.playTheGame(rpsStart);
                whatIsNext();
            } else {
                System.out.println("If you want to quit press key \"x\".");
                System.out.println("If you want to start new game key \"n\".");
            }
        }
    }
}
