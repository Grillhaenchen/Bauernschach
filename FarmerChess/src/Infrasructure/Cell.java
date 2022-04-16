package Infrasructure;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton implements Cloneable {

    CellColor color;
public Cell()
{


}
    public Cell(CellColor _colours) {
        this.setPreferredSize(new Dimension(30, 30));
        if (CellColor.white==_colours){
            this.setBackground(Color.white);
        }
        else {
            this.setBackground(Color.BLACK);
        }
    }
}
