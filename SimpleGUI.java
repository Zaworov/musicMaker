import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SimpleGUI implements ActionListener{
    private JButton button;

    void generateInterface(){
        JFrame frame = new JFrame();
        button = new JButton("Push me!");
        button.addActionListener(this);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        button.setText("I've been pushed!");
    }
}
