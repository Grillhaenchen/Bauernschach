import Infrasructure.Cell;
import Infrasructure.CellColor;

import javax.swing.*;
import java.awt.*;

public class Main {


    public static void main(String[] args) {
        JFrame win=new JFrame("ChessGame");
        win.setLayout(new BorderLayout());
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setPreferredSize(new Dimension(400,300));

        IGame game =new ChessGame();

        win.add(game.GetGameBoard());

        win.pack();
        win.setVisible(true);
    }
}