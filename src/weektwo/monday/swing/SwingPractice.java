package weektwo.monday.swing;
import javax.swing.*;
import java.awt.*;

public class SwingPractice extends JPanel{



    public static void main(String[] args) {
        JFrame f = new JFrame("Window");
        f.setSize(400,400);
        SwingPractice sp = new SwingPractice();
        f.add(sp);
        f.setVisible(true);

    }

    public void paint(Graphics g){
        setSize(400,400);
        g.setColor(Color.blue);
        System.out.println("paintrun");

        g.fillOval(20,10,340,360);
        g.setColor(Color.white);
        g.fillOval(30,20,320,340);
    }
}