package weektwo.monday.swing;
import javax.swing.*;
import java.awt.*;

public class SwingPractice extends Canvas{

    public static void main(String[] args) {
        JFrame f = new JFrame("Window");
        Canvas c = new Canvas();
        c.setSize(400,400);
        f.add(c);
        f.pack();
        f.setVisible(true);

    }

    public void paint(Graphics g){
        g.setColor(Color.blue);
        System.out.println("paintrun");
        g.fillOval(100,100,100,200);
    }
}