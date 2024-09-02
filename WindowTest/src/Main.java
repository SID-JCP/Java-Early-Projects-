import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JPanel top = new JPanel();
        top.setPreferredSize(new Dimension(100,800));
        top.setBackground(Color.BLUE);

        JPanel center = new JPanel();
        center.setPreferredSize(new Dimension(100,800));
        center.setBackground(Color.BLACK);

        JPanel bottom = new JPanel();
        bottom.setPreferredSize(new Dimension(100,20));
        bottom.setBackground(Color.RED);


        JFrame window = new JFrame("Test Panel");

        window.setSize(800,800);
        window.setLayout(new BorderLayout());
        window.add(center,BorderLayout.CENTER);
        window.add(bottom,BorderLayout.SOUTH);
        window.add(top,BorderLayout.EAST);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


}