import javax.swing.*;
import java.awt.*;

public class BackGround extends JPanel implements Runnable
{
    Thread thread;
    BackGround(){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    public void onStart(){
        thread = new Thread();
        thread.start();
    }
    @Override
    public void run() {

    }
}
