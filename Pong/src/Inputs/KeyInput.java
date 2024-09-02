package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    public static boolean rightDrag , control;

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("key pressed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SHIFT -> rightDrag = true;
            case KeyEvent.VK_W -> control = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SHIFT -> rightDrag = false;
            case KeyEvent.VK_W -> control = false;
        }

    }
}
