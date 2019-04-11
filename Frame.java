import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.FlowLayout;

public class Frame extends JFrame {
    public Frame() {
        super("Kalkulator");
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();      //pobieranie rozmiaru ekranu do obiektu Dimension, przechowujacego rozmiar obiektu w polach height width

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1200,800);
        setLocation((int)((0.5*d.width) - 600),(int)((0.5*d.height) - 400));
        setResizable(false);
        setLayout(new FlowLayout(FlowLayout.LEFT, 50, 50));
        add(new JButton("Evaluate!"));

        setVisible(true);
    }
}
