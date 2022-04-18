package Chessgame;

import Infrastructure.Position;

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



    int GetIndexFromBlackFarmer(Position _oldPosition);
    int GetIndexFromWhiteFarmer(Position _oldPosition);
    boolean PlayerCanKillOther(Position _newPosition);
}
