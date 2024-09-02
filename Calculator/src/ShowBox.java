import javax.swing.*;
import java.awt.*;

public class ShowBox extends JTextField{

    ShowBox(int x , int y , int w , int h){
        setBounds(x,y,w,h);
        setBackground(Color.WHITE);
        setVisible(true);
        setEnabled(false);

    }
}
