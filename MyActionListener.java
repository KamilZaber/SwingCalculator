import javax.swing.*;
import java.awt.event.*;

public class MyActionListener implements ActionListener {

    //just a listener for clearing given areas and fields (reset button)

    JTextArea area;
    JTextField field;

    public void actionPerformed(ActionEvent ev) {
        area.setText("");
        field.setText("");
        field.requestFocus();
    }

    public MyActionListener(JTextArea area, JTextField field) {
        this.area = area;
        this.field = field;
    }
}
