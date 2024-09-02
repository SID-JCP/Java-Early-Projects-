import javax.swing.*;

public class Window extends JFrame {

    Canvas canvas1 = new Canvas();

    public static void main(String[] args){

        new Window();

    }

    public Window(){
        setSize(900,700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(canvas1);
    }



}