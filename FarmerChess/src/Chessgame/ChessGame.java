package Chessgame;

import Infrastructure.BlackFarmer;
import Infrastructure.WhiteFarmer;

import java.util.ArrayList;

public class ChessGame implements IGame {
    ArrayList<WhiteFarmer> WhiteFarmers = new ArrayList<WhiteFarmer>();
    ArrayList<BlackFarmer> BlackFramers = new ArrayList<BlackFarmer>();

    public ChessGame() {
        initLists();
        DrawChessBoard();
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

    private void initLists() {

        //init Farmers
        for (int i = 0; i < 8; i++) {
            WhiteFarmers.add(new WhiteFarmer(i, 0));
            BlackFramers.add(new BlackFarmer(i, 7));
        }
    }

    private void DrawChessBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (WhiteFarmers.get(j).getPosition().getX() == j && WhiteFarmers.get(j).getPosition().getY() == i) {
                    System.out.print(" W ");
                }
                else if (BlackFramers.get(j).getPosition().getX() == j && BlackFramers.get(j).getPosition().getY() == i) {
                    System.out.print(" B ");
                }
                else {
                    System.out.print(" # ");
                }
            }
            System.out.println();
        }
    }

}
