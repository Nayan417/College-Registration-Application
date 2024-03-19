package registrationForm;

import java.awt.Container;
import javax.swing.JFrame;

public class Frame extends JFrame{
 public Container newFrame(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        setVisible(true);
        return c;
       }
}
