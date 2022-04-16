package GUI;

import Chessgame.ChessGame;
import Chessgame.IGame;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    static JLabel PlayerInTurn;
    private IGame game;
    public Window(){
        super("ChessGame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game=new ChessGame();

        this.add(new ChessField(game.DrawChessBoard()),BorderLayout.SOUTH);
        initGUI_Elements();
        this.add(CreateButtons(),BorderLayout.EAST);
        this.add(PlayerInTurn,BorderLayout.WEST);
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

    void initGUI_Elements()
    {
        PlayerInTurn=new JLabel();
        PlayerInTurn.setText("Spieler an der Reihe: "+game.NextGamer());
    }
}
