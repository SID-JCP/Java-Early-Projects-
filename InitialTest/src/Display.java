import maps.RoadLevel;


import javax.swing.*;
import java.awt.*;


public class Display extends JPanel implements Runnable {

    Thread thread;


    //Maps
    RoadLevel road = new RoadLevel(this);


    int ScreenHeight,ScreenWidth;






    Display()
    {
        super();
        setBackground(Color.white);



    }

    public void start(){
        thread = new Thread(this);
        thread.start();
        road.start();

    }
    @Override
    public void run() {
        while (thread != null){


            //get time at start of code execution
            long start = System.nanoTime();
            //run code
            update();
            //get time taken to execute code
            long endTime = System.nanoTime() - start;

            //delay for rest of second till 30 frames only gets completed in a second
            long frameTime = 1000000000/30;
            long delay = frameTime - endTime;
            try {
                Thread.sleep(Math.abs(delay/1000000));
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }

        }
    }


    public void update()
    {
        ScreenHeight = getHeight();
        ScreenWidth = getWidth();

        road.update(ScreenHeight,ScreenWidth);

        repaint();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //draw black bars
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,ScreenWidth,(int)(ScreenHeight * 0.15));
        g2d.fillRect(0,ScreenHeight - (int)(ScreenHeight * 0.15),ScreenWidth,(int)(ScreenHeight * 0.15));


        //draw scenes
        road.draw(g2d);


    }
}
