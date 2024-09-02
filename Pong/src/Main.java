import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        BackGround backGround = new BackGround();

        Tab bottomTab = new Tab();
        ToolPanel side = new ToolPanel(backGround.backGroundColor);

        Panel gameCanvas = new Panel();
        JFrame window = new JFrame("Pong");
        window.setSize(gameCanvas.screenSizeWidth,gameCanvas.screenSizeHeight);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setLocationRelativeTo(null);

        window.setLayout(new BorderLayout());
        window.add(side , BorderLayout.EAST);
        window.add(bottomTab , BorderLayout.SOUTH);
        window.add(gameCanvas,BorderLayout.CENTER);
        gameCanvas.onStart();
    }
}