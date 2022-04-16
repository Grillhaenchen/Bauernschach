package Infrasructure;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton implements Cloneable {

    CellColor color;

    public Cell() {
    this.addActionListener(e -> selectionButtonPressed());

    }

    private void selectionButtonPressed() {
        //react here to the click stuff :D
    }


    public Cell(CellColor _colours) {
        this.setPreferredSize(new Dimension(30, 30));
        if (CellColor.white == _colours) {
            this.setBackground(Color.white);
        } else {
            this.setBackground(Color.BLACK);
        }
    }

    @Override
    public void doClick() {
        super.doClick();
        System.out.println();
    }
}
