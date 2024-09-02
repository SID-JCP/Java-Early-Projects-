import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton{

    public Button(String name,int x){
        setBounds(x,10,100,70);
        setText(name);
        setVisible(true);
        setFocusable(false);
    }


}
