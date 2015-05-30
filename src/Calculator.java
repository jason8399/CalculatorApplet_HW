import javax.swing.*;
import java.awt.*;

/**
 * Created by JasonPan on 5/30/15.
 */
public class Calculator extends JPanel {
    private JTextField textField;

    Calculator(){
        this.setLayout(new GridLayout(0, 1, 0 ,0));
        this.add(textField = new JTextField());
        this.add(new C_CE_BS_Panel());
        this.add(new Control_Panel());
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
        private JButton add;
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
            this.add(add = new JButton("+"));
            this.add(eq = new JButton("="));
        }
    }
}
