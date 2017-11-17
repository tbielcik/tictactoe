package com.ibm;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TicTacToeRunner {

    public static void main(String[] args) throws InterruptedException {
        TicTacToe game = new TicTacToe();
        Random r = new Random();
        do {
            while (true) {
                if (game.placeMark(getRandomNumber(r), getRandomNumber(r))) {
                    break;
                }
            }
            game.printBoard();
            game.changePlayer();

            TimeUnit.SECONDS.sleep(2);
        } while (!game.checkForWin() && !game.isBoardFull());
    }

    static int getRandomNumber(Random random) {
        return random.nextInt(3);
    }
}
