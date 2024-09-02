import Inputs.KeyInput;
import Inputs.MouseClick;
import Inputs.MouseInput;
import Shapes.Circle;
import Shapes.Line;
import Shapes.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Panel extends JPanel implements Runnable{

     final int tileSize = 10 * 3;
     final int maxTilesHorizontal = 40;
     final int maxTilesVertical = 20;
     final int screenSizeWidth = tileSize * maxTilesHorizontal;
     final int screenSizeHeight= tileSize * maxTilesVertical;
     final int Fps = 30;



     BufferedImage img = new BufferedImage(500,500,BufferedImage.TYPE_INT_ARGB);

     Thread thread;
     KeyInput keyIn = new KeyInput();
     MouseInput cursor = new MouseInput();
     MouseClick click = new MouseClick();

     BackGround color = new BackGround();
     Variables variables = new Variables();

     //shapes
     Rectangle RecCreate = new Rectangle(this,keyIn,cursor,click);
     Circle CirCreate = new Circle(this,keyIn,cursor,click);

     //free hand drawing
     Line LinCreate = new Line(this,keyIn,cursor,click,img);




     public Panel(){
          super();
          setFocusable(true);
          requestFocusInWindow();
          setPreferredSize(new Dimension(screenSizeWidth , screenSizeHeight));
          setBackground(color.backGroundColor);
          setDoubleBuffered(true);
          addKeyListener(keyIn);
          addMouseMotionListener(cursor);
          addMouseListener(click);


     }
     public void onStart(){
          thread = new Thread(this);
          thread.start();
     }

     @Override
     public void run() {
          while (thread != null){
               long start = System.nanoTime();
               onUpdate();
               long endTime = System.nanoTime() - start;
               long frameTime = 1000000000/Fps;
               long delay = frameTime - endTime;
               try {
                    Thread.sleep(Math.abs(delay/1000000));
               } catch (InterruptedException e) {
                    e.fillInStackTrace();
               }
          }
     }

     public void onUpdate(){
          if (variables.getLineShape() == 0){
               LinCreate.update();
          }
          else
          {
               switch (variables.getShape()){
                    case 0 -> RecCreate.update();
                    case 1 -> CirCreate.update();
               }
          }


          repaint();
     }



     public void paintComponent(Graphics g){
          Graphics2D g2d = (Graphics2D) g;

          g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
          g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
          g2d.getDeviceConfiguration();
          switch (Variables.pattern){
               case 0 -> color.PatternLine(g2d);
               case 1 -> color.PatternLine2(g2d);
               case 2 -> color.PatternCircle(g2d);
               case 3 -> color.PatternPlus(g2d);
          }

          LinCreate.draw(g2d);
          RecCreate.draw(g2d);
          CirCreate.draw(g2d);
          g2d.dispose();
     }
}
