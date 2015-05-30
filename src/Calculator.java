import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by JasonPan on 5/30/15.
 */
public class Calculator extends JPanel {
    private JTextField textField;
    private String buffer;
    private double memory;

    Calculator(){
        this.buffer = "";
        this.setLayout(new GridLayout(0, 1, 0 ,0));
        this.add(textField = new JTextField());
        this.add(new C_CE_BS_Panel());
        this.add(new Control_Panel());
    }

    private String getFomulaWithoutBuffer(){
        String text = textField.getText();
        return text.substring(0 ,text.length() - buffer.length());
    }

    private void calculateFormula(){
        String formula = textField.getText();
        ArrayList<String> input = new ArrayList<>(Arrays.asList(formula.split(" ")));
        Stack<String> operand = new Stack<>();
        Stack<String> operator = new Stack<>();
        String OPEARTOR = "+-*/";
        double right, left, ans;
        int optor;

        //Infix calculate
        for(String now: input){
            switch (now){
                case "+":
                case "-":
                case "*":
                case "/":
                    if(!operator.isEmpty()) {
                        if (OPEARTOR.indexOf(operator.peek()) > OPEARTOR.indexOf(now)) {
                            right = Integer.parseInt(operand.pop());
                            left = Integer.parseInt(operand.pop());
                            optor = OPEARTOR.indexOf(operator.pop());
                            ans = 0;
                            switch (optor) {
                                case 0:
                                    ans = right + left;
                                    break;
                                case 1:
                                    ans = right - left;
                                    break;
                                case 2:
                                    ans = right * left;
                                    break;
                                case 3:
                                    ans = right / left;
                                    break;
                            }
                            operand.push(Double.toString(ans));
                        }
                    }
                    operator.push(now);
                    break;
                default:
                    operand.push(now);
                    break;
            }
        }
        for(;!operator.isEmpty();){
            right = Double.parseDouble(operand.pop());
            left = Double.parseDouble(operand.pop());
            optor = OPEARTOR.indexOf(operator.pop());
            ans = 0;
            switch (optor) {
                case 0:
                    ans = left + right;
                    break;
                case 1:
                    ans = left - right;
                    break;
                case 2:
                    ans = left * right;
                    break;
                case 3:
                    ans = left / right;
                    break;
            }
            operand.push(Double.toString(ans));
        }

        //Set Ans to Cell
        textField.setText(buffer = operand.pop());
    }

    class C_CE_BS_Panel extends JPanel{
        private JButton back;
        private JButton clearEntry;
        private JButton clear;

        C_CE_BS_Panel(){
            this.setLayout(new FlowLayout(FlowLayout.RIGHT));
            this.add(back = new JButton("Back"));
            this.add(clearEntry = new JButton("CE"));
            this.add(clear = new JButton("C"));
            this.back.addActionListener(new Back_ActionListener());
            this.clear.addActionListener(new C_ActionListener());
            this.clearEntry.addActionListener(new CE_ActionListener());
        }

        class C_ActionListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                buffer = "";
            }
        }

        class CE_ActionListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                String text  = getFomulaWithoutBuffer();
                if(!text.isEmpty()) {
                    if (buffer.isEmpty()) {
                        textField.setText(text.substring(0, text.length() - 3));
                    } else {
                        textField.setText(text);
                        buffer = "";
                    }
                }
            }
        }

        class Back_ActionListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                String text  = textField.getText();
                if(!text.isEmpty()){
                    textField.setText(text.substring(0, text.length() - 1));
                    if(!buffer.isEmpty())
                        buffer = buffer.substring(0, buffer.length() - 1);
                }
            }
        }
    }

    class Control_Panel extends JPanel{
        private JButton MC;
        private JButton MR;
        private JButton MS;
        private JButton MAdd;
        private JButton Button0;
        private JButton Button1;
        private JButton Button2;
        private JButton Button3;
        private JButton Button4;
        private JButton Button5;
        private JButton Button6;
        private JButton Button7;
        private JButton Button8;
        private JButton Button9;
        private JButton addition;
        private JButton sub;
        private JButton mul;
        private JButton div;
        private JButton sqroot;
        private JButton eq;
        private JButton point;
        private JButton neg;
        private JButton mulinv;
        private JButton percent;

        Control_Panel(){
            this.setLayout(new GridLayout(4, 6));
            this.add(MC = new JButton("MC"));
            this.add(Button7 = new JButton("7"));
            this.add(Button8 = new JButton("8"));
            this.add(Button9 = new JButton("9"));
            this.add(div = new JButton("/"));
            this.add(sqroot = new JButton("sqrt"));
            this.add(MR = new JButton("MR"));
            this.add(Button4 = new JButton("4"));
            this.add(Button6 = new JButton("6"));
            this.add(Button5 = new JButton("5"));
            this.add(mul = new JButton("*"));
            this.add(percent = new JButton("%"));
            this.add(MS = new JButton("MS"));
            this.add(Button1 = new JButton("1"));
            this.add(Button2 = new JButton("2"));
            this.add(Button3 = new JButton("3"));
            this.add(sub = new JButton("-"));
            this.add(mulinv = new JButton("1/X"));
            this.add(MAdd = new JButton("M+"));
            this.add(Button0 = new JButton("0"));
            this.add(neg = new JButton("+/-"));
            this.add(point = new JButton("."));
            this.add(addition = new JButton("+"));
            this.add(eq = new JButton("="));
            this.Button0.addActionListener(new Button_ActionListener());
            this.Button1.addActionListener(new Button_ActionListener());
            this.Button2.addActionListener(new Button_ActionListener());
            this.Button3.addActionListener(new Button_ActionListener());
            this.Button4.addActionListener(new Button_ActionListener());
            this.Button5.addActionListener(new Button_ActionListener());
            this.Button6.addActionListener(new Button_ActionListener());
            this.Button7.addActionListener(new Button_ActionListener());
            this.Button8.addActionListener(new Button_ActionListener());
            this.Button9.addActionListener(new Button_ActionListener());
            this.addition.addActionListener(new four_fund_ActionListener());
            this.mul.addActionListener(new four_fund_ActionListener());
            this.sub.addActionListener(new four_fund_ActionListener());
            this.div.addActionListener(new four_fund_ActionListener());
            this.point.addActionListener(new Point_ActionListener());
            this.neg.addActionListener(new Neg_ActionListener());
            this.percent.addActionListener(new Percent_ActionListener());
            this.sqroot.addActionListener((new Sqroot_ActionListener()));
            this.mulinv.addActionListener(new Mulinv_ActionListener());
            this.MC.addActionListener(new MC_ActionListener());
            this.MAdd.addActionListener(new MAdd_ActionListener());
            this.MR.addActionListener(new MR_ActionListener());
            this.MS.addActionListener(new MS_ActionListener());
            this.eq.addActionListener(new Eq_ActionListener());
        }



        class Button_ActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e){
                textField.setText(textField.getText() + e.getActionCommand());
                buffer += e.getActionCommand();
            }
        }

        class MC_ActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e){
                memory = 0;
            }
        }

        class MR_ActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e){
                String text = textField.getText();
                if(text.isEmpty() || !Character.isDigit(text.charAt(text.length() - 1))){
                    textField.setText(textField.getText() + memory);
                }
            }
        }

        class MS_ActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e){
                memory = Double.parseDouble(buffer);
            }
        }

        class MAdd_ActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e){
                memory += Double.parseDouble(buffer);
            }
        }

        class four_fund_ActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e){
                String text = textField.getText();
                if(!text.isEmpty() && Character.isDigit(text.charAt(text.length() - 1))){
                    textField.setText(text + " " + e.getActionCommand() + " ");
                }else{
                    textField.setText(text.substring(0, text.length() - 3) + " " + e.getActionCommand() + " ");
                }
                buffer = "";
            }
        }

        class Sqroot_ActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e){
                String text = textField.getText();
                double temp;
                if(!text.isEmpty() && Character.isDigit(text.charAt(text.length() - 1))) {
                    text = getFomulaWithoutBuffer();
                    if(buffer.charAt(0) == '-'){
                        //ERROR
                    } else {
                        temp = Double.parseDouble(buffer);
                        temp = Math.sqrt(temp);
                        buffer = String.format("%.2f", temp) ;
                    }
                    text += buffer;
                    textField.setText(text);
                }
            }
        }

        class Percent_ActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e){
                String text = textField.getText();
                double temp;
                if(!text.isEmpty() && Character.isDigit(text.charAt(text.length() - 1))) {
                    text = getFomulaWithoutBuffer();
                    if(buffer.charAt(0) == '-'){
                        //ERROR
                    } else {
                        temp = Double.parseDouble(buffer);
                        temp *= 0.01;
                        buffer = String.format("%.2f", temp) ;
                    }
                    text += buffer;
                    textField.setText(text);
                }
            }
        }

        class Mulinv_ActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e){
                String text = textField.getText();
                double temp;
                if(!text.isEmpty() && Character.isDigit(text.charAt(text.length() - 1))) {
                    text = getFomulaWithoutBuffer();
                    temp = Double.parseDouble(buffer);
                    temp = 1 / temp;
                    buffer = String.format("%.2f", temp) ;
                    text += buffer;
                    textField.setText(text);
                }
            }
        }

        class Neg_ActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e){
                String text = textField.getText();
                if(!text.isEmpty() && Character.isDigit(text.charAt(text.length() - 1))) {
                    text = getFomulaWithoutBuffer();
                    if(buffer.charAt(0) == '-'){
                        buffer = buffer.substring(1);
                    } else {
                        buffer = "-" + buffer;
                    }
                    text += buffer;
                    textField.setText(text);
                }
            }
        }

        class Point_ActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e){
                String text = textField.getText();
                if(!text.isEmpty() && Character.isDigit(text.charAt(text.length() - 1))){
                    textField.setText(textField.getText() + e.getActionCommand());
                }
            }
        }

        class Eq_ActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e){
                calculateFormula();
            }
        }
    }
}
