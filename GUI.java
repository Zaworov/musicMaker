import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GUI {
    private JFrame frame;
    static GraphicPanel graphicPanel;
    private int counter = 0;

    void generateInterface() {
        frame = new JFrame("My first music video!");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graphicPanel = new GraphicPanel();
        frame.setContentPane(graphicPanel);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }
}
