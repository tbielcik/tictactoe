package com.ibm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TicTacToeTest {
    @Test
    public void gameBoardCreation() {
        TicTacToe ticTacToe = new TicTacToe();

        assert isBoardEmpty(ticTacToe);
        assert ticTacToe.getCurrentPlayerMark() == 'x';

    }

    @Test
    public void winScenario2Vertical() {
        TicTacToe ticTacToe = new TicTacToe();

        // x player
        ticTacToe.placeMark(0,0);
        ticTacToe.placeMark(1,0);
        ticTacToe.placeMark(2,0);

        // o player
        ticTacToe.changePlayer();
        ticTacToe.placeMark(1,1);
        ticTacToe.placeMark(2,2);

        ticTacToe.printBoard();

        assert ticTacToe.checkForWin();
        assert ticTacToe.getWonPlayerMark() == 'x';
    }

    @Test
    public void winScenario3Horizontal() {
        TicTacToe ticTacToe = new TicTacToe();

        // x player
        ticTacToe.placeMark(0,0);
        ticTacToe.placeMark(0,2);
        ticTacToe.placeMark(2,0);

        // o player
        ticTacToe.changePlayer();
        ticTacToe.placeMark(1,0);
        ticTacToe.placeMark(1,1);
        ticTacToe.placeMark(1,2);

        ticTacToe.printBoard();

        assert ticTacToe.checkForWin();
        assert ticTacToe.getWonPlayerMark() == 'o';
    }

    @Test
    public void winScenario4Diagonal() {
        TicTacToe ticTacToe = new TicTacToe();

        // x player
        ticTacToe.placeMark(0,0);
        ticTacToe.placeMark(1,1);
        ticTacToe.placeMark(2,2);

        // o player
        ticTacToe.changePlayer();
        ticTacToe.placeMark(1,0);
        ticTacToe.placeMark(2,0);

        ticTacToe.printBoard();

        assert ticTacToe.checkForWin();
        assert ticTacToe.getWonPlayerMark() == 'x';
    }

    @Test
    public void winScenario5Draw() {
        TicTacToe ticTacToe = new TicTacToe();

        // x player
        ticTacToe.placeMark(0,0);
        ticTacToe.placeMark(0,2);
        ticTacToe.placeMark(1,2);
        ticTacToe.placeMark(2,0);
        ticTacToe.placeMark(2,1);

        // o player
        ticTacToe.changePlayer();
        ticTacToe.placeMark(0,1);
        ticTacToe.placeMark(1,0);
        ticTacToe.placeMark(1,1);
        ticTacToe.placeMark(2,2);

        ticTacToe.printBoard();

        assert !ticTacToe.checkForWin();
        assert ticTacToe.getWonPlayerMark() == '-';
        assert ticTacToe.isBoardFull();
    }

    private boolean isBoardEmpty(TicTacToe ticTacToe) {
        char[][] board = ticTacToe.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
