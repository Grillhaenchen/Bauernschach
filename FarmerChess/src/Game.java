import Infrasructure.BlackFarmer;
import Infrasructure.Cell;
import Infrasructure.WhiteFarmer;

import java.util.ArrayList;
import java.util.Collection;


public class Game implements IGame{

    ArrayList<WhiteFarmer> WhiteFarmers;
    ArrayList<BlackFarmer> BlackFarmers;
    ArrayList<Cell>Cessfield;
    public Game() {
        Setup();
    }

    private void Setup() {
        Cessfield=new ArrayList<Cell>();
        WhiteFarmers=new ArrayList<WhiteFarmer>();
        BlackFarmers=new ArrayList<BlackFarmer>();

        for (int i = 0; i <= 8; i++) {
            WhiteFarmers.add(new WhiteFarmer());
            BlackFarmers.add(new BlackFarmer());
        }



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
