import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class Button extends JButton {

    public Button(String name , int x , int y){
        setBounds(x,y,150,80);
        setText(name);
        setForeground(Color.BLACK);
        setBackground(Color.WHITE);
        setFocusable(false);
        setFont(new Font("Arial", Font.BOLD, 20));
    }


}
