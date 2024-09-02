import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.awt.*;
import java.util.ArrayList;



public class Main extends Application {

    ArrayList<Point> points = new ArrayList<>();
    ArrayList<Point> rectTemp = new ArrayList<>();
    ArrayList<ArrayList<Point>> rectFinal = new ArrayList<>();

    Group root = new Group();
    Scene scene = new Scene(root, 1200, 800, Color.WHEAT);


    //create Canvas
    Canvas canvas = new Canvas(5000, 5000);

    //create graphics element
    GraphicsContext g = canvas.getGraphicsContext2D();

    double alpha = 0.5;


    public static void main(String[] args) {
        Application.launch();

    }


    @Override
    public void start(Stage stage) throws Exception {
        root.getChildren().add(canvas);
        stage.setScene(scene);
        stage.show();

//        scene.setOnMouseClicked(mouseEvent -> {
//
//            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
//                points.add(new Point((int) mouseEvent.getX(), (int) mouseEvent.getY()));
//                g.fillOval(mouseEvent.getX(), mouseEvent.getY(), 10, 10);
//            } else {
//                for (int i = 0; i <= points.size() / 2; i++) {
//                    Spline(points.get(i), points.get(i + 1), points.get(i + 2), points.get(i + 3));
//                }
//            }
//        });


        scene.setOnMouseDragged(mouseEvent ->{
            clearCanvas();
            //draw page type design

            //update elements
            penTool(mouseEvent.getX(), mouseEvent.getY(), points , 8);
            rectTool(mouseEvent.getX(), mouseEvent.getY(),rectTemp,rectFinal);

            //draw

            //line
//            for (Point p: points){
//                g.fillOval(p.getX(),p.getY(),5,5);
//            }

            //rectangle
            g.fillRect(rectTemp.get(0).getX(),rectTemp.get(0).getY(),rectTemp.get(1).getX() - rectTemp.get(0).getX(),rectTemp.get(1).getY()-rectTemp.get(0).getY());


//            g.fillOval(mouseEvent.getX() - 25, mouseEvent.getY() - 25, 50,50);
        });







    }



    public void Spline(Point P0, Point P1, Point P2, Point P3) {
        double a1, b1, c1, d1, a2, b2, c2, d2;
        double x, y;


        //for x
        a1 = 3 * P1.x - 3 * P2.x + P3.x - P0.x;
        b1 = 2 * P0.x - 5 * P1.x + 4 * P2.x - P3.x;
        c1 = P2.x - P0.x;
        d1 = 2 * P1.x;

        //for y
        a2 = 3 * P1.y - 3 * P2.y + P3.y - P0.y;
        b2 = 2 * P0.y - 5 * P1.y + 4 * P2.y - P3.y;
        c2 = P2.y - P0.y;
        d2 = 2 * P1.y;

        for (double t = 0; t < 1; t += 0.01) {
            x = alpha * (a1 * Math.pow(t, 3) + b1 * Math.pow(t, 2) + c1 * t + d1);
            y = alpha * (a2 * Math.pow(t, 3) + b2 * Math.pow(t, 2) + c2 * t + d2);

            g.fillOval(x, y, 2, 2);
        }


    }


    private void clearCanvas(){
        g.clearRect(0,0,5000,5000);
    }

    private void penTool(double mouseX,double mouseY, ArrayList<Point> ControlPoints, int gap){
        if (ControlPoints.isEmpty()){
            ControlPoints.add(new Point((int)mouseX,(int)mouseY));
        }else
        {
            double distance = (Math.sqrt(Math.pow(ControlPoints.get(ControlPoints.size() -1).getX() - mouseX,2)+ Math.pow(ControlPoints.get(ControlPoints.size() -1).getY() - mouseY,2)));
            if (distance >= gap)
            {
                ControlPoints.add(new Point((int)mouseX,(int)mouseY));
            }
        }
    }


    private void rectTool(double mouseX,double mouseY, ArrayList<Point> rectArray,ArrayList<ArrayList<Point>> allRect){
        if (rectArray.isEmpty()){
            rectArray.add(new Point((int) mouseX, (int) mouseY));
            rectArray.add(new Point(0,0));
        }else {
            rectArray.set(1,new Point((int) mouseX, (int) mouseY));

            System.out.println(rectArray+" "+mouseX);
        }

//        allRect.addAll(rectArray.stream().toArray());
//        rectArray.clear();

    }
}