import Infrasructure.BlackFarmer;
import Infrasructure.WhiteFarmer;

import javax.swing.*;
import java.util.ArrayList;


public class ChessGame implements IGame{

    ArrayList<WhiteFarmer> WhiteFarmers;
    ArrayList<BlackFarmer> BlackFarmers;

    public ChessGame() {
        Setup();
    }

    private void Setup() {
        WhiteFarmers=new ArrayList<WhiteFarmer>();
        BlackFarmers=new ArrayList<BlackFarmer>();

        for (int i = 0; i <= 8; i++) {
            WhiteFarmers.add(new WhiteFarmer());
            BlackFarmers.add(new BlackFarmer());
        }
    }

    public JPanel GetGameBoard() {
        ChessBoard board= new ChessBoard();
       return board.CreateChessBoard();
    }

    public void newGame() {

    }

    public void Move() {

    }

    public String GetWinner() {
        return null;
    }

    public String GameOver() {
        return null;
    }

    public String NextGamer() {
        return null;
    }
}
