import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Canvas canvas = new Canvas();
        JFrame window = new JFrame("Mouse Vector");
        window.setSize(800,700);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.add(canvas);
        canvas.start();
    }
}