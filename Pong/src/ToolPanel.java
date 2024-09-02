import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolPanel extends JPanel implements ActionListener {
    JButton pencil = new JButton("pencil");
    JButton pencil2 = new JButton("pencil2");
    JButton pen = new JButton("pen");
    JButton shape = new JButton("shape");
    JButton marker = new JButton("marker");
    JButton eraser = new JButton("eraser");

    JPanel colorChooser = new JPanel();
    Variables var = new Variables();

    ToolPanel(Color color){
        pencil.setPreferredSize(new Dimension(70,70));
        pencil.setBackground(Color.WHITE);
        pencil.addActionListener(this);

        pencil2.setPreferredSize(new Dimension(70,70));
        pencil2.setBackground(Color.WHITE);
        pencil2.addActionListener(this);

        pen.setPreferredSize(new Dimension(70,70));

        shape.setPreferredSize(new Dimension(70,70));
        shape.setBackground(Color.WHITE);
        shape.addActionListener(this);

        marker.setPreferredSize(new Dimension(70,70));
        eraser.setPreferredSize(new Dimension(70,70));

        colorChooser.setSize(new Dimension(70,200));
        colorChooser.setBackground(Color.RED);

        this.setPreferredSize(new Dimension(100,10));
        this.setLayout(new GridLayout(8,1,10,10));
        this.setBorder(new EmptyBorder(5,15,5,15));
        this.add(pencil);
        this.add(pencil2);
        this.add(pen);
        this.add(shape);
        this.add(marker);
        this.add(eraser);
        this.add(colorChooser);
        this.setBackground(color);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pencil){
            var.setLineShape(0);
        }
        if (e.getSource() == shape){
            var.setLineShape(1);
        }
        System.out.println(var.getLineShape());
    }
}
