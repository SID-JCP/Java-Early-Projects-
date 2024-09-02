import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


public class Board extends JFrame implements MouseListener, MouseMotionListener {


    public static int shape;
    public static int mode;
    public static int click_x,click_y;
    public static int drag_x , drag_y;
    public static int press_x , press_y;
    public int x = 0, y = 0;

    public ArrayList<Point> mouseDrag = new ArrayList<>();

    public Mypanel top = new Mypanel();

    public static void main(String[] args) {
        shape = 0; //0 , 1 , 2  = rectangle  ,  circle , triangle
        mode = 1; // 0 , 1 ,2 = select  , paint , shape
        new Board();

    }

    public Board(){

        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        add(top);
        addMouseListener(this);
        addMouseMotionListener(this);


    }





    @Override
    public void mouseClicked(MouseEvent e) {

        click_x = e.getX();
        click_y = e.getY();

        if (shape == 0){
            Graphics circle = getGraphics();
            circle.setColor(Color.DARK_GRAY);
            circle.fillOval(click_x,click_y,100,100);
        }else{
            Graphics rectange = getGraphics();
            rectange.setColor(Color.DARK_GRAY);
            rectange.fillRect(click_x,click_y,100,100);

        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        press_x = e.getX();
        press_y = e.getY();


    }

    @Override
    public void mouseReleased(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        drag_x = e.getX();
        drag_y = e.getY();
        mouseDrag.add(e.getPoint());

        if(mode == 0){    //mode   0 , 1 ,2 = select  , paint , shape
            pencil();

        }else if (mode == 1){
            return;
        }else {

            switch (shape){
                case 0:
                {
                    drwrect();
                    break;

                } case 1:
                {
                    drwcir();
                    break;

                } case 2:{

                    drwtri();
                    break;
                }

            }
        }


    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }




    public void drwrect(){
        Graphics g = getGraphics();
        Graphics2D select = (Graphics2D)g;
        select.setColor(Color.BLUE);
        select.fillRect(press_x,press_y,drag_x - press_x,drag_y - press_y);

    }

    public void drwcir(){
        Graphics g = getGraphics();
        Graphics2D select = (Graphics2D)g;
        select.setColor(Color.BLUE);
        select.fillRect(press_x,press_y,drag_x - press_x,drag_y - press_y);

    }

    public void drwtri(){
        Graphics g = getGraphics();
        Graphics2D select = (Graphics2D)g;
        select.setColor(Color.BLUE);
        select.fill3DRect(10,10,100,100,true);

    }


    public void pencil(){
        Graphics g2 = getGraphics();
        Graphics2D line = (Graphics2D)g2;
        line.setColor(Color.BLUE);
        line.fillOval(drag_x,drag_y,5,5);
        line.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        line.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

    }

}