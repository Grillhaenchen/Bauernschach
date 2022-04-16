package GUI;

import javax.swing.*;

public class Window {
    private JTextArea HALLOTextArea;
    private JPanel panel1;
    public void StartApp(){
        JFrame Window =new JFrame("FarmerChess");
        Window.setContentPane(new Window().panel1);
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Window.pack();
        Window.setVisible(true);
    }
}
