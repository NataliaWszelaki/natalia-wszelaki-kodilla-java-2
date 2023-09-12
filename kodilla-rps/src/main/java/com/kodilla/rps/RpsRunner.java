package com.kodilla.rps;

public class RpsRunner {

    public static void main(String[] args) {

        RPSStart rpsStart = new RPSStart();
        Game game = new Game();
        NextSteps nextSteps = new NextSteps();
        rpsStart.run();
        game.playTheGame(rpsStart);
        nextSteps.whatIsNext();

    }
}

