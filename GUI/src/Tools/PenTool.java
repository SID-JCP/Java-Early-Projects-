package Tools;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PenTool{

    Canvas canvas;
    GraphicsContext graphicsContext;

    double MouseX , MouseY;

    public PenTool(Canvas canvas, GraphicsContext Gc , Double MouseX , Double MouseY){
        this.canvas = canvas;
        this.graphicsContext = Gc;
        this.MouseX = MouseX;
        this.MouseY = MouseY;
    }


    public void Draw(){
        graphicsContext.setFill(Color.BLUE);
        graphicsContext.fillRect(MouseX,100,MouseY,100);
    }


}
