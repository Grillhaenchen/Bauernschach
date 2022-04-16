package GUI;

import Chessgame.ChessGame;
import Chessgame.IGame;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {



    public Window(){
        super("ChessGame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        IGame game=new ChessGame();

        this.add(new ChessField(game.DrawChessBoard()),BorderLayout.SOUTH);

        this.add(CreateButtons());

        this.pack();
        this.setVisible(true);
    }

    private JPanel CreateButtons()
    {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton NewGame=new JButton("New Game");
        buttonPanel.add(NewGame);
        //this.add(buttonPanel,BorderLayout.SOUTH);
        return buttonPanel;
    }
}
