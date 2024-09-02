import javax.swing.*;
import java.awt.event.ActionEvent;

public class Inputs {
    Action UpAction;
    Action DnAction;
    Inputs(){
        UpAction = new Up();
        DnAction = new Dn();

    }
    public static class Up extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public static class Dn extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}
