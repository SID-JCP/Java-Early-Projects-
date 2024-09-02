import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mypanel extends JPanel implements ActionListener {

    // Undo , Redo , 3 pencil , 2 pen , 1 marker , width , color
    //total 10

    Button pencil = new Button("pencil",20);
    Button pencil1 = new Button("pencil",121);
    Button pencil2 = new Button("pencil",222);
    Button pen = new Button("pen",323);
    Button pen2 = new Button("pen2",424);
    Button marker = new Button("marker",525);

    Mypanel(){
        setSize(800,100);
        setBackground(Color.BLACK);
        setLayout(null);
        add(pencil);
        add(pencil1);
        add(pencil2);
        add(pen);
        add(pen2);
        add(marker);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
