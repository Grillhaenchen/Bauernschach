package Chessgame;

import javax.swing.*;

public interface IGame {
    void newGame();
    String[][] Move(int[][] _FígureTurn);
    String[][] Move();
    String GetWinner();
    String GameOver();
    String NextGamer();

    boolean GetFirstTurn();

    String[][] DrawChessBoard();

}
