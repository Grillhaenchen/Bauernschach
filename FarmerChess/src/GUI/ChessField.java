package GUI;

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

    public ChessField(String[][] _DrawArray) {
        super();
        DrawArray = _DrawArray;
        initMouseActions();
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


    private void initMouseActions() {
        this.addMouseListener(new MouseAdapter() {
            @Override //I override only one method for presentation
            public void mousePressed(MouseEvent e) {

                if ((HeightOfFrame / 2) - ((SQUARESIZE * Squarelength) / 2) < e.getY() && (HeightOfFrame / 2) + ((SQUARESIZE * Squarelength) / 2) > e.getY() &&(WidthOfFrame / 2) - ((SQUARESIZE * Squarelength) / 2) < e.getX() && (WidthOfFrame / 2) + ((SQUARESIZE * Squarelength) / 2) > e.getX()) {
                    System.out.println(e.getY() + " is in ChessField");
                }

                /*if ((HeightOfFrame/2)+((SQUARESIZE*Squarelength)/2)>e.getY()){
                    System.out.println(e.getY()+" is in ChessField lower");
                }
*/
                System.out.println(/*e.getX() + "," +*/ e.getY());


            }
        });
    }

}
