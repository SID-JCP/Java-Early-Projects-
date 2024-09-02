import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Scene game = new Scene();
        game.start();
        JFrame window = new JFrame("Pong");
        window.setSize(700,700);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(game);
        window.setResizable(false);
        window.setVisible(true);
    }
}