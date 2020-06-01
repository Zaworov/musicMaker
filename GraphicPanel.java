//package out;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
import java.awt.*;

public class GraphicPanel extends JPanel implements ControllerEventListener {
    boolean eventOccured = false;

    @Override
    public void controlChange(ShortMessage event) {
        eventOccured = true;
        repaint();
    }

    public void paintComponent(Graphics graphics) {
        if (eventOccured) {
//            Graphics2D graphics2d = (Graphics2D) graphics;

            int red = (int) (Math.random() * 250);
            int green = (int) (Math.random() * 250);
            int blue = (int) (Math.random() * 250);

            graphics.setColor(new Color(red, green, blue));

            int height = (int) (Math.random() * 120) + 10;
            int width = (int) (Math.random() * 120) + 10;
            int xAxisLocation = (int) (Math.random() * 40) + 10;
            int yAxisLocation = (int) (Math.random() * 40) + 10;
            graphics.fillRect(xAxisLocation, yAxisLocation, height, width);
            eventOccured = false;
        }
    }
}
