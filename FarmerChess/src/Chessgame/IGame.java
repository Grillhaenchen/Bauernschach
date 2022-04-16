package Chessgame;

import javax.swing.*;

public interface IGame {
    void newGame();
    String[][] Move();
    String GetWinner();
    String GameOver();
    String NextGamer();

    String[][] DrawChessBoard();


}
