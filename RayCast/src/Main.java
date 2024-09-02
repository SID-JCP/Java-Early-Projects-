import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Panel RayPanel = new Panel();
        JFrame window = new JFrame("window");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800,800);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.add(RayPanel);
        RayPanel.onStart();

    }
}