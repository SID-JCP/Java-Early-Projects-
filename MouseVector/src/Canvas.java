import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Canvas extends JPanel implements Runnable , MouseMotionListener {

    Thread thread;
    double deltaT;

    double MouseX;
    double MouseY;

    int VelocityX,VelocityY;
    boolean MouseMove;

    ArrayList<Point> MousePosition = new ArrayList<>();



    Canvas(){
        super();
        setBackground(Color.BLUE);
        addMouseMotionListener(this);
        setFocusable(true);
    }

    public void start(){
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        MousePosition.add(e.getPoint());
        MouseX = e.getX();
        MouseY = e.getY();
        MouseMove = true;

    }

    @Override
    public void mouseMoved(MouseEvent e) {

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
            deltaT = (double) endTime /1000000;


            velocity(deltaT,MousePosition);


            //delay for rest of second till 60 frames only gets completed in a second
            long frameTime = 1000000000/20;
            long delay = frameTime - endTime;
            try {
                Thread.sleep(Math.abs(delay/1000000));
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }

        }
    }

    private void velocity(double time, ArrayList<Point> Points) {
        Point P1,P2;

        if(Points.size() > 2){
            P1 = Points.get(Points.size() - 2);
            P2 = Points.get(Points.size() - 1);
            VelocityX = (int)((P2.x - P1.x)/time);
            VelocityY = (int)((P2.y - P1.y)/time);





        }else{
            return;
        }

        Points.removeAll(Points);


    }






    public void update(){
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine((int)MouseX,(int)MouseY,(int)MouseX + VelocityX,(int)MouseY + VelocityY);

    }


}
