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

        ChessBoard chessBorad =new ChessBoard();

        win.add(chessBorad.CreateChessBoard());

        win.pack();
        win.setVisible(true);
    }
}