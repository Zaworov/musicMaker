import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SimpleGUI {
    private JButton colorButton, labelButton;
    private JFrame frame;
    private int counter = 0;

    void generateInterface() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        colorButton = new JButton("Change color!");
        labelButton = new JButton("PUSH IT!");
        colorButton.addActionListener(new ColorListener());
        labelButton.addActionListener(new LabelListener());

        GraphicPanel graphicPanel = new GraphicPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.CENTER, graphicPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    private class ColorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            colorButton.setText("Change again!");
            frame.repaint();
        }
    }

    private class LabelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            counter++;
            labelButton.setText("PUSHED " + counter + " TIMES!");
        }
    }
}
