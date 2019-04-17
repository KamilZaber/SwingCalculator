import javax.swing.*;

public class SwingCalc {
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Frame();
            }
        });
    }
}
