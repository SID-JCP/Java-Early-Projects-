package Shapes;

import Inputs.KeyInput;
import Inputs.MouseInput;
import Inputs.MouseClick;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Line {

    JPanel gameCanvas;
    KeyInput key;
    MouseInput cursor;
    MouseClick click;
    BufferedImage image;


    int stat;
    int drag;
    int strokeWidth = 2;
    int dragDistanceX;
    int dragDistanceY;

    ArrayList<Integer> pointClone;
    ArrayList<Integer> NewPointCLone;
    ArrayList<ArrayList<Integer>> NewCoordinatesClone;

    //for smoothing
    ArrayList<Integer> point0Clone;
    ArrayList<Integer> point1Clone;

    ArrayList<ArrayList<Integer>> coordinateClone;
    ArrayList<ArrayList<Integer>> coordinateSmoothClone;

    //default
    public ArrayList<ArrayList<ArrayList<Integer>>> lines = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> coordinates = new ArrayList<>();
    public ArrayList<Integer> point = new ArrayList<>(2);

    //newForDrag
    public ArrayList<ArrayList<ArrayList<Integer>>> NewLines = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> NewCoordinates = new ArrayList<>();
    public ArrayList<Integer> NewPoint = new ArrayList<>(2);

    //smoothing
    public ArrayList<ArrayList<Integer>> coordinateSmooth = new ArrayList<>();
    public ArrayList<Integer> point0 = new ArrayList<>(2);
    public ArrayList<Integer> point1 = new ArrayList<>(2);



    public Line(JPanel gameCanvas, KeyInput key , MouseInput cursor , MouseClick click, BufferedImage image)
    {
        this.gameCanvas = gameCanvas;
        this.key = key;
        this.cursor = cursor;
        this.click = click;
        this.image = image;

    }

    public void update(){
        int x,y,x1,y1;
        double Qx,Qy,Px,Py;

        if (click.mouseDown && cursor.mouseDrag && !key.rightDrag){
            if (point.isEmpty()){point.add(0);point.add(0);}
            point.set(0,cursor.mouseDragX);
            point.set(1,cursor.mouseDragY);
            pointClone = new ArrayList<>(point);
            coordinates.add(pointClone);
            coordinateClone = new ArrayList<>(coordinates);
            stat = 1;
        }

        if (!click.mouseDown)
        {
            cursor.mouseDrag = false;
        }

        if (NewPoint.isEmpty()){NewPoint.add(0);NewPoint.add(0);}

        if (!cursor.mouseDrag && stat == 1)
        {
            coordinates.clear();
            point.clear();
            stat = 0;

            try {
                ImageIO.write(image, "PNG", new File("line.PNG"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //smoothing algorithm
            if (coordinateClone.size() >= 2){
                if (point0.isEmpty()){point0.add(0);point0.add(0);}
                if (point1.isEmpty()){point1.add(0);point1.add(0);}
                for (int i = 0 ; i < coordinateClone.size() - 1; i++){
                    x = coordinateClone.get(i).get(0);
                    y = coordinateClone.get(i).get(1);
                    x1 = coordinateClone.get(i + 1).get(0);
                    y1 = coordinateClone.get(i + 1).get(1);

                    Qx = ((0.75 * x) + (0.25 * x1));
                    Qy = ((0.75 * y) + (0.25 * y1));
                    Px = ((0.25 * x) + (0.75 * x1));
                    Py = ((0.25 * y) + (0.75 * y1));

                    point0.set(0,(int)Math.round(Qx));
                    point0.set(1,(int)Math.round(Qy));

                    point1.set(0,(int)Math.round(Px));
                    point1.set(1,(int)Math.round(Py));
                    point0Clone = new ArrayList<>(point0);
                    point1Clone = new ArrayList<>(point1);

                    coordinateSmooth.add(point0Clone);
                    coordinateSmooth.add(point1Clone);

                }
            }

            coordinateSmoothClone = new ArrayList<>(coordinateSmooth);
            lines.add(coordinateSmoothClone);
            NewLines.add(coordinateSmoothClone);
            coordinateSmooth.clear();

        }

        if (key.rightDrag && cursor.mouseDrag)
        {
            drag = 1;
            dragDistanceX = cursor.mouseDragX - click.mouseDownX;
            dragDistanceY = cursor.mouseDragY - click.mouseDownY;

            for (int i = 0 ; i < lines.size() ; i++) {
                NewCoordinates = new ArrayList<>(lines.get(i));
                for (int j = 0; j < lines.get(i).size(); j++)
                {
                    NewPoint.set(0,lines.get(i).get(j).get(0) + dragDistanceX);
                    NewPoint.set(1,lines.get(i).get(j).get(1) + dragDistanceY);
                    NewPointCLone = new ArrayList<>(NewPoint);
                    NewCoordinates.set(j, NewPointCLone);
                }
                NewCoordinatesClone = new ArrayList<>(NewCoordinates);
                NewLines.set(i , NewCoordinatesClone);
            }
        }

        if (!cursor.mouseDrag && !key.rightDrag && drag == 1)
        {
            lines = new ArrayList<>(NewLines);
            System.out.println("new Lines " + lines);
            drag = 0;
        }
    }


    public void draw(Graphics2D g2d){
        int a,b,c,d;
        for (int i = 0; i < coordinates.size() - 1; i++) {
            g2d.setColor(Color.ORANGE);
            g2d.setStroke(new BasicStroke(strokeWidth));
            g2d.drawLine(coordinates.get(i).get(0),coordinates.get(i).get(1),coordinates.get(i + 1).get(0),coordinates.get(i + 1).get(1));
        }

        if (!lines.isEmpty() && drag == 0)
        {
            for (ArrayList<ArrayList<Integer>> coordinate : lines) {
                for (int i = 0; i < coordinate.size() - 1; i++) {
                    a = coordinate.get(i).get(0);
                    b = coordinate.get(i).get(1);
                    c = coordinate.get(i + 1).get(0);
                    d = coordinate.get(i + 1).get(1);
                    g2d.setColor(Color.orange);
                    g2d.setStroke(new BasicStroke(strokeWidth));
                    g2d.drawLine(a,b,c,d);
                }
            }
        }

        if (!NewLines.isEmpty() && drag == 1)
        {
            for (ArrayList<ArrayList<Integer>> coordinate : NewLines) {
                for (int i = 0; i < coordinate.size() - 1; i++) {
                    a = coordinate.get(i).get(0);
                    b = coordinate.get(i).get(1);
                    c = coordinate.get(i + 1).get(0);
                    d = coordinate.get(i + 1).get(1);
                    g2d.setColor(Color.orange);
                    g2d.setStroke(new BasicStroke(strokeWidth));
                    g2d.drawLine(a,b,c,d);
                }
            }
        }

    }
}
