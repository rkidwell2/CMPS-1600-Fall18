import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;


public class myLongCalculator extends JFrame {

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


    public String display = "";


    public myLongCalculator() {


        setTitle("My Calculator");
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
                String answer = parseDisplay(display);
                result.setText(answer);
            }

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
                if ("+(x".indexOf(disp.charAt(i)) != -1){
                    return false;
                }
            }

            if (i == 0){
                if ("+)x".indexOf(disp.charAt(i)) != -1){
                    return false;
                }
            }
        }

        if (ParCount != 0) {
            return false;
        }

        if (disp.contains("++")) {return false;}
        if (disp.contains("-+")) {return false;}
        if (disp.contains("+x")) {return false;}
        if (disp.contains("x+")) {return false;}
        if (disp.contains("-x")) {return false;}
        if (disp.contains("xx")) {return false;}


        return true;

    }

    public String parseDisplay(String display) {
        String solution = "";

        /*Identify numbers that need to be turned into myLongs
        All numbers will be separated by a non-digit character, so need to create myLongs of all adjacent numbers
         */

        while (display.contains("+-")){
            display = display.replace("+-", "-");
        }

        while (display.contains("--")){
            display = display.replace("--", "+");
        }

        while (display.contains("---")){
            display = display.replace("---", "-");
        }


        //Creates a list of strings that separate an equation into its parts
        //Ex: (67 + 89) becomes [(, 67, +, 89, )]
        ArrayList<String> splitToNums = new ArrayList<>();
        char[] charArray = display.toCharArray();

        String entry = "";
        for (int index = 0; index < charArray.length; index++) {
            char element = charArray[index];
            boolean isDigit = Character.isDigit(element);

            if (element == '-'){
                if (index == 0){
                    entry += Character.toString(element);
                }
                else{
                    char before = charArray[index-1];
                    char after = charArray[index+1];
                    if (before == '*') {
                        entry += Character.toString(element);
                    }
                    else if ("()".contains(Character.toString(before))){
                        splitToNums.add(entry);
                        entry = "";
                        entry += element;
                    }
                    else{
                        if (Character.isDigit(before)){
                            splitToNums.add(entry);
                            entry = "";
                            entry += element;
                        }
                        if (Character.isDigit(after)){
                            splitToNums.add(entry);
                            entry = "";
                        }
                    }
                }

            }

            else if (isDigit) {
                entry += Character.toString(element);
            }
            else {
                splitToNums.add(entry);
                entry = Character.toString(element);
                splitToNums.add(entry);
                entry = "";
            }
            if (index == charArray.length - 1) {
                splitToNums.add(entry);
            }

        }

        while (splitToNums.contains("")){
            //Deletes empty entries in the arrayList
            splitToNums.remove("");
        }


        /*
        Iterate through to find where parentheses stop/start

        Every equation can be broken up into two different numbers completing operations.
        We want to find the numbers before and after each operator
        */

        ArrayList<String> eqCopy = (ArrayList) splitToNums.clone();

        ArrayList<String> subString = new ArrayList<String>();
        while (eqCopy.contains("(") || eqCopy.contains(")")) {
            subString.clear();

            int paranStart = 0;
            int paranEnd = 0;

            for (int j = eqCopy.size() - 1; j >= 0; j--){
                String element = eqCopy.get(j);
                if (element.contains("(")){
                    paranStart = j;
                    break;
                }
                else{
                    continue;
                }
            }

            for (int k = paranStart; k < eqCopy.size(); k++){
                String element = eqCopy.get(k);
                if (element.contains(")")){
                    paranEnd = k;
                    break;
                }
                else{
                    continue;
                }

            }


            //Create a subList of what is contained inside the parentheses
            subString = new ArrayList<String>(eqCopy.subList(paranStart + 1, paranEnd));

            //Remove everything inside parentheses, including parentheses
            eqCopy.subList(paranStart,paranEnd+1).clear();


            performOperations(subString);
            eqCopy.add(paranStart, String.join("",subString));

        }

        performOperations(eqCopy);


        for (String each: eqCopy){
            solution+= each;
        }


        return solution;
    }


    public ArrayList<String> performOperations (ArrayList<String> solString){


        myLong before = new myLong();
        myLong after = new myLong();
        myLong resultOfFxn;

        while (solString.contains("*")){
            int index = solString.indexOf("*");

            before.setLong(solString.get(index - 1)); //number before operator
            after.setLong(solString.get(index + 1)); //number after operator
            resultOfFxn = before.multiply(after);


            solString.remove(index+1);
            solString.remove(index);
            solString.remove(index-1);

            solString.add(index-1, resultOfFxn.toString());

        }

        while (solString.contains("-")){
            int index = solString.indexOf("-");
            if (index == 0){
                after.setLong("-"+solString.get(index+1));
                solString.remove(index+1);
                solString.remove(index);
                solString.add(index, after.toString());

            }
            else {
                before.setLong(solString.get(index - 1)); //number before operator
                after.setLong(solString.get(index + 1)); //number after operator
                resultOfFxn = before.subtract(after);

                solString.remove(index + 1);
                solString.remove(index);
                solString.remove(index - 1);

                solString.add(index - 1, resultOfFxn.toString());
            }

        }

        while (solString.contains("+")){
            int index = solString.indexOf("+");

            before.setLong(solString.get(index - 1)); //number before operator
            after.setLong(solString.get(index + 1)); //number after operator
            resultOfFxn = before.add(after);


            solString.remove(index+1);
            solString.remove(index);
            solString.remove(index-1);

            solString.add(index-1, resultOfFxn.toString());

        }



        return solString;
    }

    public static void main (String [] args){
        myLongCalculator myCalc = new myLongCalculator();

        myCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myCalc.pack();
        myCalc.setVisible(true);





    }
}