package GUI;

import Chessgame.IGame;
import Infrastructure.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChessField extends JPanel {

    final int SQUARESIZE = 8;
    private String[][] DrawArray = new String[7][7];
    private int HeightOfFrame = 0;
    private int WidthOfFrame = 0;
    private int Squarelength = 0;

    public ChessField(String[][] _DrawArray, IGame game) {
        super();
        DrawArray = _DrawArray;
        initMouseActions(game);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    public int GetSquarelength() {
        return Squarelength;
    }

    public void SetHeightAndWidth(int _height, int _width) {
        HeightOfFrame = _height;
        WidthOfFrame = _width;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        Squarelength = Math.min(getWidth() - 4, getHeight() - 4) / SQUARESIZE;

        int width = getWidth() - (Squarelength * 2);
        int height = getHeight() - (Squarelength * 2);

        int y = (getHeight() - (Squarelength * SQUARESIZE)) / 2;
        for (int horz = 0; horz < 8; horz++) {

            int x = (getWidth() - (Squarelength * SQUARESIZE)) / 2;

            for (int vert = 0; vert < SQUARESIZE; vert++) {
                g.drawRect(x, y, Squarelength, Squarelength);
                g.drawString(DrawArray[horz][vert], x + 10, y + 18);

                x += Squarelength;
            }

            y += Squarelength;
        }
        g2d.dispose();
    }

    private Position PositionFromChessFigure;
    private Position PositionTurn;

    private void initMouseActions(IGame game) {
        this.addMouseListener(new MouseAdapter() {
            @Override //I override only one method for presentation
            public void mousePressed(MouseEvent e) {

                if ((HeightOfFrame / 2) - ((SQUARESIZE * Squarelength) / 2) < e.getY() && (HeightOfFrame / 2) + ((SQUARESIZE * Squarelength) / 2) > e.getY() &&(WidthOfFrame / 2) - ((SQUARESIZE * Squarelength) / 2) < e.getX() && (WidthOfFrame / 2) + ((SQUARESIZE * Squarelength) / 2) > e.getX()) {
                    System.out.println(e.getY() + " is in ChessField");
                    if (PositionFromChessFigure==null){
                        PositionFromChessFigure=new Position(e.getX(),e.getY());
                    }
                    else {
                        PositionTurn=new Position(e.getX(),e.getY());
                    }

                    if (PositionTurn!=null&&PositionFromChessFigure!=null){
                        //CalcPlayerturn(PositionFromChessFigure.getX(),PositionTurn.getX(),PositionFromChessFigure.getY(),PositionTurn.getY());

                       // game.Move();
                    }
                    CalcPlayerturn(e.getX(),PositionTurn.getX(),e.getY(),PositionTurn.getY());
                }
            }
        });
    }
    private int[][] CalcPlayerturn(int _currentX, int _turnX, int _currentY,int _turnY){

        int [][]Turn=new int[2][2];

        //Turn[0][0]=CalcColumn(_currentX);//old column
        //Turn[0][0]=CalcRow(_currentY);//old row

        System.out.println("Current Column: "+CalcColumn(_currentX));
        System.out.println("Current Row: "+CalcRow(_currentY));




        return null;
    }

    private int CalcColumn(int _X){

        double offset=(WidthOfFrame / 2) - ((SQUARESIZE * Squarelength) / 2);
        return (int)Math.ceil((_X-offset)/Squarelength);
    }

    private int CalcRow(int _Y){
        double offset=(HeightOfFrame / 2) - ((SQUARESIZE * Squarelength) / 2);


        return (int)Math.ceil((_Y-offset)/Squarelength);
    }




}
