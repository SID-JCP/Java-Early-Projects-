import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class Window extends JFrame implements ActionListener {

    final int vertical = 80;
    final int vertical2 = 160;
    final int vertical3 = 240;
    final int vertical4 = 320;

    ArrayList<String> operators = new ArrayList<>();
    public String output;

    Button AC = new Button("AC", 0, 0);
    Button del = new Button("del", 150, 0);
    Button percent = new Button("%", 300, 0);
    Button div = new Button("÷", 450, 0);

    Button seven = new Button("7", 0, vertical);
    Button eight = new Button("8", 150, vertical);
    Button nine = new Button("9", 300, vertical);
    Button multiply = new Button("×", 450, vertical);

    Button four = new Button("4", 0, vertical2);
    Button five = new Button("5", 150, vertical2);
    Button six = new Button("6", 300, vertical2);
    Button sub = new Button("-", 450, vertical2);

    Button one = new Button("1", 0, vertical3);
    Button two = new Button("2", 150, vertical3);
    Button three = new Button("3", 300, vertical3);
    Button add = new Button("+", 450, vertical3);

    Button exp = new Button("x²", 0, vertical4);
    Button zero = new Button("0", 150, vertical4);
    Button dot = new Button(".", 300, vertical4);
    Button equal = new Button("=", 450, vertical4);


    //window width 900 , height 600
    // Button panel width 600, height 500
    ConstructPanel buttonPanel = new ConstructPanel(275, 150, 600, 400, Color.orange);
    ConstructPanel labelPanel = new ConstructPanel(275, 10, 600, 135, Color.WHITE);

    ShowBox input = new ShowBox(40, 20, 550, 60);
    ShowBox display = new ShowBox(150, 90, 300, 40);


    //create window
    public Window() {
        displaySettings();
        addActionListners();
        setSize(900, 600);
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonPanel.add(one);
        buttonPanel.add(two);
        buttonPanel.add(three);
        buttonPanel.add(four);

        buttonPanel.add(five);
        buttonPanel.add(six);
        buttonPanel.add(seven);
        buttonPanel.add(eight);

        buttonPanel.add(nine);
        buttonPanel.add(zero);
        buttonPanel.add(add);
        buttonPanel.add(sub);

        buttonPanel.add(AC);
        buttonPanel.add(del);
        buttonPanel.add(percent);
        buttonPanel.add(div);

        buttonPanel.add(multiply);
        buttonPanel.add(exp);
        buttonPanel.add(dot);
        buttonPanel.add(equal);


        labelPanel.add(input);
        labelPanel.add(display);
        add(buttonPanel);
        add(labelPanel);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

    //button click
    @Override
    public void actionPerformed(ActionEvent e) {
        String prevoious;



        if (e.getSource().equals(one)) {
            prevoious = input.getText();
            input.setText(prevoious + "1");
        } else if (e.getSource().equals(two)) {
            prevoious = input.getText();
            input.setText(prevoious + "2");
        } else if (e.getSource().equals(three)) {
            prevoious = input.getText();
            input.setText(prevoious + "3");
        } else if (e.getSource().equals(four)) {
            prevoious = input.getText();
            input.setText(prevoious + "4");
        } else if (e.getSource().equals(five)) {
            prevoious = input.getText();
            input.setText(prevoious + "5");
        } else if (e.getSource().equals(six)) {
            prevoious = input.getText();
            input.setText(prevoious + "6");
        } else if (e.getSource().equals(seven)) {
            prevoious = input.getText();
            input.setText(prevoious + "7");
        } else if (e.getSource().equals(eight)) {
            prevoious = input.getText();
            input.setText(prevoious + "8");
        } else if (e.getSource().equals(nine)) {
            prevoious = input.getText();
            input.setText(prevoious + "9");
        } else if (e.getSource().equals(zero)) {
            prevoious = input.getText();
            input.setText(prevoious + "0");
        } else if (e.getSource().equals(add)) {
            prevoious = input.getText();
            input.setText(prevoious + "+");
        } else if (e.getSource().equals(multiply)) {
            prevoious = input.getText();
            input.setText(prevoious + "*");
        } else if (e.getSource().equals(sub)) {
            prevoious = input.getText();
            input.setText(prevoious + "-");
        } else if (e.getSource().equals(div)) {
            prevoious = input.getText();
            input.setText(prevoious + "/");
        } else if (e.getSource().equals(equal)) {
            output = input.getText();
            display.setText(String.valueOf(Main.eval(output)));

        } else if (e.getSource().equals(AC)) {
            operators.clear();
            input.setText("");
        } else if (e.getSource().equals(del)) {
//            input.setText(prevoious.stripIndent(2));
        }
    }


    public void displaySettings() {

        Font font = new Font("SansSerif", Font.BOLD, 35);
        display.setBackground(Color.WHITE);
        display.setFont(font);
        input.setFont(font);
        input.setCaretColor(Color.WHITE);

    }

    public void addActionListners() {
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        zero.addActionListener(this);
        add.addActionListener(this);
        multiply.addActionListener(this);
        div.addActionListener(this);
        exp.addActionListener(this);
        sub.addActionListener(this);
        percent.addActionListener(this);
        equal.addActionListener(this);
        del.addActionListener(this);
        AC.addActionListener(this);
        dot.addActionListener(this);


    }

}


class ConstructPanel extends JPanel {

    public ConstructPanel(int x, int y, int w, int h, Color color) {
        setBounds(x, y, w, h);
        setBackground(color);
        setLayout(null);
    }


}


