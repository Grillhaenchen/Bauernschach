import javax.swing.*;

public interface IGame {

    JPanel GetGameBoard();
    void newGame();
    void Move();
    String GetWinner();
    String GameOver();
    String NextGamer();


}
