import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class Scene extends JPanel implements Runnable {
    Thread thread;
    Inputs inputs;

    Action UpAction;
    Action DnAction;
    Action NoAction;

    Action RUpAction;
    Action RDnAction;
    Action RNoAction;

    int Ls;
    int Rs;

    AudioInputStream audioInputStream;
    File file;
    Clip clip;



    int vL = 200;
    int vR = 160;
    int x = 300;
    int y = 300;
    int BallDirection = 1;
    int BallVertDirection = 1;
    int HorVel = 5;
    int VerVel = 5;

    static int dir;
    static int dir2;

    Scene(){
        super();
        setBackground(Color.BLACK);
        setFocusable(true);
        requestFocus();
        UpAction = new Up();
        DnAction = new Dn();
        NoAction = new No();

        RUpAction = new UpR();
        RDnAction = new DnR();
        RNoAction = new NoR();

        //left paddle
        getInputMap().put(KeyStroke.getKeyStroke("W"),"UpAction");
        getActionMap().put("UpAction",UpAction);

        getInputMap().put(KeyStroke.getKeyStroke("released W"),"NoAction");
        getInputMap().put(KeyStroke.getKeyStroke("released S"),"NoAction");
        getActionMap().put("NoAction",NoAction);

        getInputMap().put(KeyStroke.getKeyStroke("S"),"DnAction");
        getActionMap().put("DnAction",DnAction);

        //right paddle
        getInputMap().put(KeyStroke.getKeyStroke("O"),"RUpAction");
        getActionMap().put("RUpAction",RUpAction);

        getInputMap().put(KeyStroke.getKeyStroke("released O"),"RNoAction");
        getInputMap().put(KeyStroke.getKeyStroke("released K"),"RNoAction");
        getActionMap().put("RNoAction",RNoAction);

        getInputMap().put(KeyStroke.getKeyStroke("K"),"RDnAction");
        getActionMap().put("RDnAction",RDnAction);


    }

    //left paddle
    public static class Up extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            dir = 1;
        }
    }

    public static class No extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            dir = 0;
        }
    }

    public static class Dn extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            dir = -1;
        }
    }

    //right paddle
    public static class UpR extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            dir2 = 1;
        }
    }

    public static class NoR extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            dir2 = 0;
        }
    }

    public static class DnR extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            dir2 = -1;
        }
    }


    public void start(){
        thread = new Thread(this);
        inputs = new Inputs();

        //audio input
        file = new File("Audio data/wav tt.wav");
        try {
            audioInputStream = AudioSystem.getAudioInputStream(file);
            try {
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
            }
            catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            }
        }
        catch (UnsupportedAudioFileException | IOException e)
        {
            throw new RuntimeException(e);
        }


        thread.start();
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

    public void update(){
        //left paddle
        clip.setMicrosecondPosition(0);
        if (vL < 550 && dir == -1){
            vL = vL + 10;
        }else if (vL > 20 && dir == 1){
            vL = vL - 10;
        }
        //right paddle
        if (vR < 550 && dir2 == -1){
            vR = vR + 10;
        }else if (vR > 20 && dir2 == 1){
            vR = vR - 10;
        }

        //check x collision of ball
        if (x >= 655 && x <= 680 && y > vR && y < (vR + 100) ){
            BallDirection = -1;
            HorVel = HorVel + 1;
            clip.start();
        }else if(x <= 20 && x >= 0 && y > vL && y < (vL + 100)){
            BallDirection = 1;
            HorVel = HorVel + 1;
            clip.start();
        }else if (x <= 0 || x > 680) {
            if (x <= 0){
                Rs += 1;
            }else {
                Ls += 1;
            }
            x = 350;
            y = 350;
            HorVel = 5;
            VerVel = 5;
            clip.setMicrosecondPosition(0);
        }


        //check vertical collision of ball
        if (y == 20){
            BallVertDirection = -1;

        }else if(y == 660){
            BallVertDirection = 1;
        }


        //move ball in vertical and horizontal direction
        if (BallDirection == 1){
            x = x + HorVel;
        } else{
            x = x - HorVel;
        }

        if (BallVertDirection == 1){
            y = y - VerVel;
        } else{
            y = y + VerVel;
        }

        repaint();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        //left rectangle
        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(0,vL,10,100,10,10);

        //right rectangle
        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(670,vR,10,100,10,10);

        g2d.setColor(Color.RED);
        g2d.fillOval(x - 10,y - 10,20,20);

        g2d.setColor(Color.WHITE);

        for (int i = 0; i < 700 ; i += 20){
            g2d.fillOval(350,i , 2,2);
        }
        g2d.drawString(String.valueOf(Ls),320,30);
        g2d.drawString(String.valueOf(Rs),370,30);
    }

}
