//package out;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
import java.awt.*;

public class GraphicDisplay extends JPanel implements ControllerEventListener {
    boolean eventOccured = false;

    @Override
    public void controlChange(ShortMessage event) {
        eventOccured = true;
        repaint();
    }

    public void paintComponent(Graphics graphics){
        if (eventOccured){
            Graphics2D graphics2d = (Graphics2D) graphics;

            int c = (int) (Math.random() * 250);
            int z = (int) (Math.random() * 250);
            int n = (int) (Math.random() * 250);

            graphics.setColor(new Color(c, z, n));

            int height = (int) (Math.random() * 120) + 10;
            int width = (int) (Math.random() * 120) + 10;
            int x = (int) (Math.random() * 40) + 10;
            int y = (int) (Math.random() * 40) + 10;
            graphics.fillRect(x, y, height, width);
            eventOccured = false;
        }
    }


}
