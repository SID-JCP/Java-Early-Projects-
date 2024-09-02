package Inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseInput implements  MouseMotionListener {


    public int mouseDragX , mouseDragY;
    public boolean mouseDrag = false;


    @Override
    public void mouseDragged(MouseEvent e) {
        mouseDrag = true;
        mouseDragX = e.getX();
        mouseDragY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
