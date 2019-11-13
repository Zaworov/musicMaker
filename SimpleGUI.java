import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SimpleGUI {
    int x = 0;
    int y = 0;
    private JButton colorButton, labelButton;
    private JFrame frame;
    private int counter = 0;

    void generateInterface() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        colorButton = new JButton("Change color and position!");
        labelButton = new JButton("PUSH IT!");
        colorButton.addActionListener(new ColorListener());
        labelButton.addActionListener(new LabelListener());

        GraphicPanel graphicPanel = new GraphicPanel();
        frame.getContentPane().add(BorderLayout.CENTER, graphicPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.setSize(300, 300);
        frame.setVisible(true);

        for (int i = 0; i <= 130; i++) {
            x++;
            y++;
            graphicPanel.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
            frame.repaint();
        }
    }

    public class GraphicPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            graphics.fillRect(0, 0, this.getWidth(), this.getHeight()); //background
            graphics.setColor(Color.green);
            graphics.fillOval(x, y, 40, 40);
        }
    }

    public class GraphicElement extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {

        }
    }
}
