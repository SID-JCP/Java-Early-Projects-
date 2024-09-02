package maps;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class RoadLevel {

    JPanel panel;

    //road image
    File roadParallax = new File("C:\\Users\\Siddharth Mukherjee\\IdeaProjects\\InitialTest\\Images\\New Project.png");
    BufferedImage roadImage;

    int PanelHeight , PanelWidth;
    int dim,yPos;

    int Img1 = 0;
    int Img2 = 0;
    int Img3 = 0;

    ArrayList<Integer> ImageX = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0,0,0));


    int Create = 0;


    public RoadLevel(JPanel screen){
        this.panel = screen;
    }

    public void start(){

        //load image
        try {
            roadImage = ImageIO.read(roadParallax);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void update(int ScreenHeight , int ScreenWidth){
        PanelHeight = ScreenHeight;
        PanelWidth = ScreenWidth;

        yPos = (int)(PanelHeight * 0.15);
        dim = PanelHeight - (int)(PanelHeight * 0.3) + 2;

        //create coordinates
        if (dim > 100 && Create == 0){
            for(int i = 0 ; i < 10 ; i++){
                ImageX.set(i,dim * i);
            }
            Img1 = 0;
            Img2 = dim ;
            Img3 = dim * 2;
            Create = 1;
        }

        //move
        ImageX.replaceAll(integer -> integer - 2);

        //back to end
        for(int i = 0;i < ImageX.size();i++){
            if (ImageX.get(i) <= - dim){
                ImageX.set(i,(dim*9)-1);
            }
        }
    }

    public void draw(Graphics2D PG2d){

        for(int PosX : ImageX){
            PG2d.drawImage(roadImage,PosX,yPos,dim,dim,null);
        }



//        PG2d.drawImage(roadImage,Img1,yPos,dim,dim,null);
//        PG2d.drawImage(roadImage,Img2,yPos,dim,dim,null);
//        PG2d.drawImage(roadImage,Img3,yPos,dim,dim,null);

    }

}
