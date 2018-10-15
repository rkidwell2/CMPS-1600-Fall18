import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Calculator extends JFrame {

    GridBagConstraints gbc = new GridBagConstraints();

    private JButton num1;
    private JButton num2;
    private JButton num3;
    private JButton num4;
    private JButton num5;
    private JButton num6;
    private JButton num7;
    private JButton num8;
    private JButton num9;
    private JButton num0;
    private JButton plus;
    private JButton minus;
    private JButton times;
    private JButton leftparan;
    private JButton rightparan;
    private JButton equal;
    private JButton clear;
    private JTextField result;
    private double Solution;


    String display = "";

    public Calculator(String title) {


        setTitle(title);
        setPreferredSize(new Dimension(600, 300));
        JPanel panel1 = new JPanel();


        panel1.add(num0 = new JButton("0"));
        panel1.add(num1 = new JButton("1"));
        panel1.add(num2 = new JButton("2"));
        panel1.add(num3 = new JButton("3"));
        panel1.add(num4 = new JButton("4"));
        panel1.add(num5 = new JButton("5"));
        panel1.add(num6 = new JButton("6"));
        panel1.add(num7 = new JButton("7"));
        panel1.add(num8 = new JButton("8"));
        panel1.add(num9 = new JButton("9"));
        panel1.add(plus = new JButton("+"));
        panel1.add(minus = new JButton("-"));
        panel1.add(times = new JButton("x"));
        panel1.add(leftparan = new JButton("("));
        panel1.add(rightparan = new JButton(")"));
        panel1.add(equal = new JButton("="));
        panel1.add(clear = new JButton("C"));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.add(result = new JTextField(20));
        result.setHorizontalAlignment(JTextField.RIGHT);
        result.setEditable(false);


        JPanel main = new JPanel();
        main.setLayout(new GridLayout());

        main.add(panel1, BorderLayout.SOUTH);
        main.add(panel2, BorderLayout.NORTH);

        add(main);

        num1.addActionListener(new Press1());
        num2.addActionListener(new Press2());
        num3.addActionListener(new Press3());
        num4.addActionListener(new Press4());
        num5.addActionListener(new Press5());
        num6.addActionListener(new Press6());
        num7.addActionListener(new Press7());
        num8.addActionListener(new Press8());
        num9.addActionListener(new Press9());
        num0.addActionListener(new Press0());
        plus.addActionListener(new PressPlus());
        minus.addActionListener(new PressMinus());
        times.addActionListener(new PressMultiply());
        leftparan.addActionListener(new PressL());
        rightparan.addActionListener(new PressR());
        equal.addActionListener(new PressSolve());
        clear.addActionListener(new Clear());


    }

    class Clear implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            result.setText("");

        }
    }
    class Press1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display = result.getText();
            result.setText(display + "1");
        }
    }

    class Press2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display = result.getText();
            result.setText(display + "2");
        }
    }

    class Press3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display = result.getText();
            result.setText(display + "3");
        }
    }

    class Press4 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display = result.getText();
            result.setText(display + "4");
        }
    }

    class Press5 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display = result.getText();
            result.setText(display + "5");
        }
    }

    class Press6 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display = result.getText();
            result.setText(display + "6");
        }
    }

    class Press7 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display = result.getText();
            result.setText(display + "7");
        }
    }

    class Press8 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display = result.getText();
            result.setText(display + "8");
        }
    }

    class Press9 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display = result.getText();
            result.setText(display + "9");
        }
    }

    class Press0 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display = result.getText();
            result.setText(display + "0");
        }
    }

    class PressPlus implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display = result.getText();
            result.setText(display + "+");
        }
    }
    class PressMinus implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display = result.getText();
            result.setText(display + "-");
        }
    }

    class PressMultiply implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display = result.getText();
            result.setText(display + "*");
        }
    }

    class PressL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display = result.getText();
            result.setText(display + "(");
        }
    }

    class PressR implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display = result.getText();
            result.setText(display + ")");
        }
    }

    class PressSolve implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display = result.getText();
            String equation = result.getText();
            boolean validity = isValidInput(display);
            if (!validity){
                result.setText("Invalid input.");
            }
            if (validity){
                result.setText("Valid input.");
            }


            Double myAns = Double.parseDouble(equation);

            //FIX: How to parse numbers from equation??
            //If string given as int, java can solve equation

            //Double myAns = Double.valueOf(equation);


            //result.setText(Double.toString(myAns));


        }
    }

    public boolean isValidInput(String disp) {

        int ParCount = 0;
        for (int i = 0; i < disp.length(); ++i) {
            if (disp.charAt(i) == '(') {
                ParCount += 1;
            }
            if (disp.charAt(i) == ')') {
                ParCount -= 1;
            }

            if (i == (disp.length()-1)){
                if ("+-(x".indexOf(disp.charAt(i)) != -1){
                    return false;
                }
            }

            if (i == 0){
                if ("+-)x".indexOf(disp.charAt(i)) != -1){
                    return false;
                }
            }
        }

        if (ParCount != 0) {
            return false;
        }

        if (disp.contains("++")) {return false;}
        if (disp.contains("+-")) {return false;}
        if (disp.contains("-+")) {return false;}
        if (disp.contains("+x")) {return false;}
        if (disp.contains("x+")) {return false;}
        if (disp.contains("--")) {return false;}
        if (disp.contains("-x")) {return false;}
        if (disp.contains("x-")) {return false;}
        if (disp.contains("xx")) {return false;}



        return true;

    }


    public static void main (String [] args){
        Calculator myCalc = new Calculator("My Calculator");

        myCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myCalc.pack();
        myCalc.setVisible(true);

    }
}



