package Shapes;

import Inputs.KeyInput;
import Inputs.MouseInput;
import Inputs.MouseClick;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Circle {
    JPanel gameCanvas;
    KeyInput key;
    MouseInput cursor;
    MouseClick click;

    int stat;
    int drag;

    ArrayList<Integer> pointClone;
    ArrayList<Integer> NewPointClone;

    public ArrayList<ArrayList<Integer>> coordinates = new ArrayList<>();
    public ArrayList<Integer> point = new ArrayList<>(4);

    public ArrayList<Integer> NewPoint = new ArrayList<>(4);
    public ArrayList<ArrayList<Integer>> NewCoordinates = new ArrayList<>();

    int dragDistanceX;
    int dragDistanceY;

    public Circle(JPanel gameCanvas, KeyInput key , MouseInput cursor , MouseClick click)
    {
        this.gameCanvas = gameCanvas;
        this.key = key;
        this.cursor = cursor;
        this.click = click;
    }

    public void update(){
        if (click.mouseDown && cursor.mouseDrag && !key.rightDrag){
            if (point.isEmpty()){point.add(0);point.add(0);point.add(0);point.add(0);}
            point.set(0,click.mouseDownX);
            point.set(1,click.mouseDownY);
            point.set(2,cursor.mouseDragX);
            point.set(3,cursor.mouseDragY);
            stat = 1;
        }

        if (!click.mouseDown){cursor.mouseDrag = false;}

        if (NewPoint.isEmpty()){NewPoint.add(0);NewPoint.add(0);NewPoint.add(0);NewPoint.add(0);}

        if (!cursor.mouseDrag && stat == 1){
            pointClone = new ArrayList<>(point);
            coordinates.add(pointClone);
            NewCoordinates.add(pointClone);
            stat = 0;
        }

        if (key.rightDrag && cursor.mouseDrag){
            drag = 1;
            dragDistanceX = cursor.mouseDragX - click.mouseDownX;
            dragDistanceY = cursor.mouseDragY - click.mouseDownY;
            for (int i = 0 ; i < coordinates.size() ; i++) {
                NewPoint.set(0,coordinates.get(i).get(0) + dragDistanceX);
                NewPoint.set(1,coordinates.get(i).get(1) + dragDistanceY);
                NewPoint.set(2,coordinates.get(i).get(2) + dragDistanceX);
                NewPoint.set(3,coordinates.get(i).get(3) + dragDistanceY);
                NewPointClone = new ArrayList<>(NewPoint);
                NewCoordinates.set(i,NewPointClone);
            }
        }

        if (!cursor.mouseDrag && !key.rightDrag && drag == 1){
            coordinates = new ArrayList<>(NewCoordinates);
            drag = 0;
        }
        if (!click.mouseDown){cursor.mouseDrag = false;}
    }

    public void draw(Graphics g2d){
        int a,b,c,d;
        if (!coordinates.isEmpty() && drag == 0)
        {
            for (ArrayList<Integer> coordinate : coordinates) {
                a = coordinate.get(0);
                b = coordinate.get(1);
                c = coordinate.get(2);
                d = coordinate.get(3);
                g2d.setColor(Color.orange);
                g2d.fillOval(a, b, c - a, d - b);

            }
        }

        if (stat == 1 && drag == 0) {
            g2d.setColor(Color.orange);
            g2d.fillOval(click.mouseDownX, click.mouseDownY, cursor.mouseDragX - click.mouseDownX, cursor.mouseDragY - click.mouseDownY);
            g2d.setColor(Color.BLUE);
            g2d.drawOval(click.mouseDownX, click.mouseDownY, cursor.mouseDragX - click.mouseDownX, cursor.mouseDragY - click.mouseDownY);

        }
        if (drag == 1){
            if (!NewCoordinates.isEmpty())
                for (ArrayList<Integer> coordinate : NewCoordinates){
                    a = coordinate.get(0);
                    b = coordinate.get(1);
                    c = coordinate.get(2);
                    d = coordinate.get(3);
                    g2d.setColor(Color.orange);
                    g2d.fillOval(a, b, c - a, d - b );
                }

        }
    }
}

