import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SimpleGUI implements ActionListener {
    private JButton colorButton, textButton;
    private JFrame frame;
    private int counter = 0;

    void generateInterface() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        colorButton = new JButton("Change color!");
        textButton = new JButton("PUSH IT!");
        colorButton.addActionListener(this);
        textButton.addActionListener(this);

        GraphicPanel graphicPanel = new GraphicPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.EAST, textButton);
        frame.getContentPane().add(BorderLayout.CENTER, graphicPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == colorButton) {
            colorButton.setText("Change again!");
            frame.repaint();
        } else if (event.getSource() == textButton) {
            counter++;
            textButton.setText("PUSHED " + counter + " TIMES!");
        }
    }
}
