package GUI;

import Chessgame.ChessGame;
import Chessgame.IGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame{

    static JLabel PlayerInTurn;
    private IGame game;
    private ChessField PlayField;

    private int HeightOfFrame=0;

    private int WidthOfFrame=0;

    public Window(){
        super("ChessGame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        game=new ChessGame();
        PlayField=new ChessField(game.DrawChessBoard());
        this.add(PlayField,BorderLayout.SOUTH);
        initGUI_Elements();
        initMouseActions();
        this.add(CreateButtons(),BorderLayout.EAST);
        this.add(PlayerInTurn,BorderLayout.WEST);
        this.pack();
        this.setVisible(true);

        this.HeightOfFrame=this.getHeight();
        this.WidthOfFrame=this.getWidth();
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

    private void initGUI_Elements()
    {
        PlayerInTurn=new JLabel();
        PlayerInTurn.setText("Spieler an der Reihe: "+game.NextGamer());
    }

    private void initMouseActions(){
        this.addMouseListener(new MouseAdapter() {
            @Override //I override only one method for presentation
            public void mousePressed(MouseEvent e) {



                System.out.println(e.getX() + "," + e.getY());

                int[][]paylerturn=CalcPlayerturn(e.getX(),e.getY(),PlayField.GetSquarelength());
                game.Move();

                ChessFieldAfterTurn();
            }
        });
    }

    private int[][] CalcPlayerturn(int x, int y, int getSquarelength) {
        return null;
    }

    private void ChessFieldAfterTurn(){

        PlayField.revalidate();


    }

}
