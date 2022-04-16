package GUI;

import Infrastructure.BlackFarmer;
import Infrastructure.WhiteFarmer;

import javax.swing.*;
import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;

public class ChessField extends JPanel {

    String DrawArray[][]= new String[7][7];

    public ChessField(String[][] _DrawArray){
        super();
        DrawArray=_DrawArray;
    }

    private void initArray(ArrayList<BlackFarmer> _blackFarmers, ArrayList<WhiteFarmer> _whiteFarmers){
        for (int i=0;i<8;i++)
        {
            for (int j=0;j<8;j++){
                if (_blackFarmers.get(i).getPosition().getY()==j){
                    DrawArray[i][j]= "O";
                }
                else if (_whiteFarmers.get(i).getPosition().getY()==j){
                    DrawArray[i][j]= "X";
                }
                else
                    DrawArray[i][j]= " ";
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        final int SQUARESIZE=8;

        int size = Math.min(getWidth() - 4, getHeight() - 4) / SQUARESIZE;
        int width = getWidth() - (size * 2);
        int height = getHeight() - (size * 2);

        int y = (getHeight() - (size * SQUARESIZE)) / 2;
        for (int horz = 0; horz < 8; horz++) {

            int x = (getWidth() - (size * SQUARESIZE)) / 2;

            for (int vert = 0; vert < SQUARESIZE; vert++) {
                g.drawRect(x, y, size, size);
                g.drawString(DrawArray[horz][vert],x+10,y+18);

                x += size;
            }

            y += size;
        }
        g2d.dispose();
    }
}
