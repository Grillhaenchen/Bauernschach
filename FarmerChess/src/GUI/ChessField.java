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
    private Position PositionFromChessFigure;
    private Position PositionTurn;

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

    private void initMouseActions(IGame game) {
        this.addMouseListener(new MouseAdapter() {
            @Override //I override only one method for presentation
            public void mousePressed(MouseEvent e) {

                if ((HeightOfFrame / 2) - ((SQUARESIZE * Squarelength) / 2) < e.getY() && (HeightOfFrame / 2) + ((SQUARESIZE * Squarelength) / 2) > e.getY() && (WidthOfFrame / 2) - ((SQUARESIZE * Squarelength) / 2) < e.getX() && (WidthOfFrame / 2) + ((SQUARESIZE * Squarelength) / 2) > e.getX()) {

                    System.out.println("##############################");
                    System.out.println("Spalte: " + CalcColumn(e.getX()));
                    System.out.println("Zeile: " + CalcRow(e.getY()));
                    System.out.println("##############################");

                    if (PositionFromChessFigure == null) {
                        PositionFromChessFigure = new Position(e.getX(), e.getY());
                    } else {
                        PositionTurn = new Position(e.getX(), e.getY());
                    }

                    if (PositionTurn != null && PositionFromChessFigure != null) {

                        //CalcPlayerturn(PositionFromChessFigure.getX(), PositionTurn.getX(), PositionFromChessFigure.getY(), PositionTurn.getY());
                        //boolean b = TurnIsValid(CalcPlayerturn(PositionFromChessFigure.getX(), PositionTurn.getX(), PositionFromChessFigure.getY(), PositionTurn.getY()), game.GetFirstTurn(), game.NextGamer());
                        //System.out.println("turn is valid: " + b);
                        //b=CheckIfOnOldPositionFigure(CalcColumn(PositionFromChessFigure.getX())-1, CalcRow(PositionFromChessFigure.getY())-1, game.NextGamer());
                        //System.out.println("Is figure on Position " + b);

                        if (TurnIsValid(CalcPlayerturn(PositionFromChessFigure.getX(), PositionTurn.getX(), PositionFromChessFigure.getY(), PositionTurn.getY()), game.GetFirstTurn(), game.NextGamer()) == false
                                && CheckIfOnOldPositionFigure(CalcColumn(PositionFromChessFigure.getX()) - 1, CalcRow(PositionFromChessFigure.getY()) - 1, game.NextGamer()) == false) {
                            JOptionPane.showMessageDialog(null, "Schachzug nicht valide", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                            PositionFromChessFigure=null;
                            PositionTurn=null;
                        }
                        else {
                            DrawArray= game.Move(CalcPlayerturn(PositionFromChessFigure.getX(), PositionTurn.getX(), PositionFromChessFigure.getY(), PositionTurn.getY()));
                            PositionFromChessFigure=null;
                            PositionTurn=null;
                            JOptionPane.showMessageDialog(null, "Schachzug ausgeführt", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                            ReDrawChessBoard();
                        }
                    }
                }
            }
        });
    }

    private int[][] CalcPlayerturn(int _currentX, int _turnX, int _currentY, int _turnY) {

        int[][] Turn = new int[2][2];

        Turn[0][0] = CalcColumn(_currentX);//old column
        Turn[0][1] = CalcRow(_currentY);//old row

        Turn[1][0] = CalcColumn(_turnX);//old column
        Turn[1][1] = CalcRow(_turnY);//old row
        return Turn;
    }

    private int CalcColumn(int _X) {
        double offset = (WidthOfFrame / 2) - ((SQUARESIZE * Squarelength) / 2);
        return (int) Math.ceil((_X - offset) / Squarelength);
    }

    private int CalcRow(int _Y) {
        double offset = (HeightOfFrame / 2) - ((SQUARESIZE * Squarelength) / 2);
        return (int) Math.ceil((_Y - offset) / Squarelength);
    }

    private boolean TurnIsValid(int[][] _turnArray, boolean _firstTurn, String _nextGamer) {
        Position OldPosition = new Position(_turnArray[0][0], _turnArray[0][1]);
        Position NewPosition = new Position(_turnArray[1][0], _turnArray[1][1]);

        if (_nextGamer == "Spieler 1") {
            System.out.println("Spieler 1: " + (OldPosition.getY() - NewPosition.getY()));
            if (_firstTurn == true) {
                return OldPosition.getY() - NewPosition.getY() <= 2;
            } else {
                return OldPosition.getY() - NewPosition.getY() == 1;
            }
        } else if (_nextGamer == "Spieler 2") {
            if (_firstTurn == true) {
                System.out.println("Spieler 2 " + (OldPosition.getY() - NewPosition.getY()));
                return OldPosition.getY() - NewPosition.getY() <= 2;
            } else {
                return OldPosition.getY() - NewPosition.getY() == 1;
            }
        }
        return false;
    }

    private boolean CheckIfOnOldPositionFigure(int _x, int _y, String _nextGamer) {
        if (_nextGamer == "Spieler 1") {
            //_x=-7;
            //_x=Math.abs(_x);


            return DrawArray[_y][_x] == "X";
        } else if (_nextGamer == "Spieler 2") {
            return DrawArray[_y][_x] == "O";
        }
        return false;
    }


    private void ReDrawChessBoard(){
        this.repaint();
    }

}
