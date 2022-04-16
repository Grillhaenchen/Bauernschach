package Chessgame;

import javax.swing.*;

public interface IGame {
    void newGame();
    void Move();
    String GetWinner();
    String GameOver();
    String NextGamer();


}
