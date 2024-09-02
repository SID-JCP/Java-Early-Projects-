import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.Random;

public class Panel extends JPanel implements Runnable,MouseMotionListener {

    Thread thread;
    LinkedList<Point> lines;
    LinkedList<Point> linesStop;
    Random random;

    int posX,posY;
    int r;
    int x,y;
    boolean inter = false;
    


    Panel(){
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        this.addMouseMotionListener(this);

    }

    public void onStart(){
        thread = new Thread(this);
        thread.start();
        random = new Random();
        lines = new LinkedList<>();
        linesStop = new LinkedList<>();
        //coordinates of lines segment

        for (int i = 0; i < 10 ; i++)
        {
            lines.add(new Point(random.nextInt(1000),random.nextInt(1000)));
        }
        for (int i = 0; i < 10 ; i++)
        {
            linesStop.add(new Point(random.nextInt(1000),random.nextInt(1000)));
        }
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
            long frameTime = 1000000000/60;
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
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        posX = e.getX();
        posY = e.getY();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void paintComponent(Graphics g){
        r = 5000;
        double dem;
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);

        //check each line for each obstacle
        for (double theta = 0.0; theta < 10 ; theta += 1){
            inter = false;

            int x3 = 0,y3 = 0,x4 = 0,y4 = 0;
            x = (int) (r * Math.cos(theta));
            y = (int) (r * Math.sin(theta));
            
            
            //lines 
            int x1 = posX;
            int y1 = posY;
            int x2 = posX + x;
            int y2 = posY + y;

            //draw
            for (int j = 0 ; j < 10 ; j++)
            {
                g2d.setColor(Color.GREEN);
                g2d.drawLine(lines.get(j).x,lines.get(j).y,linesStop.get(j).x,linesStop.get(j).y);
            }


            for (int k = 0; k < 10 ; k++)

            {
                x3 = lines.get(k).x;
                y3 = lines.get(k).y;
                x4 = linesStop.get(k).x;
                y4 = linesStop.get(k).y;
                dem = ((x1 - x2)*(y3 - y4) - (y1 - y2)*(x3-x4));

                if (!inter){
                    if (dem != 0){
                        double t =((x1-x3)*(y3 - y4) - (y1 - y3)*(x3 - x4))/dem;
                        double u =((x1-x3)*(y1 - y2) - (y1 - y3)*(x1 - x2))/dem;

                        if (t > 0 && t < 1 && u > 0 && u < 1 ){
                            inter = true;
                            int Px = (int)(x1 + t*(x2 - x1));
                            int Py = (int)(y1 + t*(y2 - y1));
                            g2d.setColor(Color.WHITE.darker().darker());
                            g2d.drawLine(posX,posY,Px,Py);

                            g2d.setColor(Color.RED);
                            g2d.fillOval(Px - 5 ,Py - 5, 10, 10);


                        }else {
                            g2d.setColor(Color.WHITE.darker().darker());
                            g2d.drawLine(posX,posY,x+ posX,y+ posY);
                        }
                    }else {
                        g2d.setColor(Color.WHITE.darker().darker());
                        g2d.drawLine(posX,posY,x+ posX,y+ posY);
                    }
                }else {
                    return;
                }
        }


    }
}
}
