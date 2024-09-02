import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Display road = new Display();
        road.start();

        JFrame window = new JFrame("Window");
        window.setSize(1500,700);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        window.add(road);
    }
}