package GUI;

import Chessgame.ChessGame;
import Chessgame.IGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Window extends JFrame {

    static JLabel PlayerInTurn;
    private IGame game;
    private ChessField PlayField;



    public Window(){
        super("ChessGame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        game=new ChessGame();
        PlayField=new ChessField(game.DrawChessBoard(),game);
        this.add(PlayField,BorderLayout.SOUTH);
        initGUI_Elements();
        this.add(CreateButtons(),BorderLayout.EAST);
        this.add(PlayerInTurn,BorderLayout.WEST);
        this.pack();
        this.setVisible(true);

        PlayField.SetHeightAndWidth(PlayField.getHeight(),PlayField.getWidth());
        PlayField.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {

                PlayerInTurn.setText("Spieler an der Reihe: "+game.NextGamer());

            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {

                PlayerInTurn.setText("Spieler an der Reihe: "+game.NextGamer());

            }
        });
    }

    private JPanel CreateButtons()
    {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton NewGame=new JButton("New Game");
        buttonPanel.add(NewGame);
        return buttonPanel;
    }

    private void initGUI_Elements()
    {
        PlayerInTurn=new JLabel();
        PlayerInTurn.setText("Spieler an der Reihe: "+game.NextGamer());



    }

}
