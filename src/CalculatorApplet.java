import javax.swing.*;

/**
 * Created by JasonPan on 5/30/15.
 */
public class CalculatorApplet extends JApplet {
    @Override
    public void init() {
        super.init();
        add(new Calculator());
    }
}
