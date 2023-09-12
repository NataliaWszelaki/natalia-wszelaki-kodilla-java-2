package com.kodilla.rps;

public class Game {

    int tryCounter = 1;
    int playerWin = 0;
    int cpuWin = 0;

    public void playTheGame(RPSStart rpsStart) {

        boolean end = false;
        while (!end) {
            System.out.println("Round " + tryCounter);
            RPSEnum player = PlayerChoice.getChoice();
            RPSEnum computer = CPUChoice.getChoice();
            if (player == computer) {
                System.out.println("It's a Tie!");
                System.out.println("Player: " + playerWin + "  Computer: " + cpuWin);
                System.out.println();
            } else if ((player == RPSEnum.ROCK && computer == RPSEnum.SCISSORS) ||
                    (player == RPSEnum.SCISSORS && computer == RPSEnum.PAPER) ||
                    (player == RPSEnum.PAPER && computer == RPSEnum.ROCK)) {
                playerWin++;
                System.out.println("This round was won by the player!");
                System.out.println("Player: " + playerWin + "  Computer: " + cpuWin);
                System.out.println();
            } else {
                cpuWin++;
                System.out.println("This round was won by the computer!");
                System.out.println("Player: " + playerWin + "  Computer: " + cpuWin);
                System.out.println();
            }
            tryCounter++;

            if (playerWin == rpsStart.getRounds() || cpuWin == rpsStart.getRounds()) {
                end = true;
            }
        }

        System.out.println("FINAL RESULTS!");
        System.out.println("Player: " + playerWin + "  Computer: " + cpuWin);
        String whoWin = (playerWin > cpuWin) ? "Congratulations! You win!" : "Sorry! Game over! Computer win!";
        System.out.println(whoWin);
    }
}
