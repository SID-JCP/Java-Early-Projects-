import javax.swing.*;
import java.awt.*;

public class Tab extends JPanel {
    Tab(){
        this.setPreferredSize(new Dimension(10,25));
        this.setBackground(Color.RED);
        this.setFocusable(true);
        this.requestFocus();
    }
}
