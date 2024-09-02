import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        BackGround bg = new BackGround();

        JFrame window = new JFrame("Circle pong");
        window.setSize(500,500);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.add(bg);
        window.setVisible(true);
    }
}