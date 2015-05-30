import javax.swing.*;
import java.awt.*;

/**
 * Created by JasonPan on 5/30/15.
 */
public class Calculator extends JPanel {
    private JTextField textField;

    Calculator(){
        this.setLayout(new GridLayout(0, 1));
        this.add(textField = new JTextField());
        this.add(new C_CE_BS_Panel());
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
}
