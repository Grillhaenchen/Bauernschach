package GUI;

import javax.swing.*;
import java.awt.*;

public class ChessField extends JPanel {

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        int size = Math.min(getWidth() - 4, getHeight() - 4) / 8;
        int width = getWidth() - (size * 2);
        int height = getHeight() - (size * 2);

        int y = (getHeight() - (size * 8)) / 2;
        for (int horz = 0; horz < 8; horz++) {

            int x = (getWidth() - (size * 8)) / 2;

            for (int vert = 0; vert < 8; vert++) {
                g.drawRect(x, y, size, size);
                g.drawString("x",x+10,y+18);

                x += size;
            }

            y += size;
        }
        g2d.dispose();
    }
}
