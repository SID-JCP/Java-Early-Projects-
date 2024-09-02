package Inputs;

import Inputs.MouseInput;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClick implements MouseListener {

    public int mouseCLickX , mouseClickY , mouseReleaseX , mouseReleaseY , mouseDownX , mouseDownY;
    public boolean mouseDown;
    public boolean rightClick = false;
    public boolean middleClick = false;
    MouseInput drag = new MouseInput();


    @Override
    public void mouseClicked(MouseEvent e) {
        mouseDown = false;
        mouseCLickX = e.getX();
        mouseClickY = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseDown = true;
        if (e.getButton() == MouseEvent.BUTTON3 ){rightClick = true;middleClick = true;}
        if (e.getButton() != MouseEvent.BUTTON3 ){rightClick = false;middleClick = false;}
        mouseDownX = e.getX();
        mouseDownY = e.getY();


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseDown = false;
        drag.mouseDrag = false;
        rightClick = false;
        middleClick = false;
        mouseReleaseX = e.getX();
        mouseReleaseY = e.getY();

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
