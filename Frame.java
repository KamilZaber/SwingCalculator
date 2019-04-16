import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.event.*;

public class Frame extends JFrame {
    public Frame() {
        super("Kalkulator");

        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();      //pobieranie rozmiaru ekranu do obiektu Dimension, przechowujacego rozmiar obiektu w polach height width

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800,600);
        setLocation((int)((0.5*d.width) - 400),(int)((0.5*d.height) - 300));
        //setResizable(false);
        setLayout(null);

        String elements[] = {"sqrt", "ln", "rad", "log", "mod", "round", "pi", "e", "[Ks]"};

        JMenuBar menubar = new JMenuBar();
        JMenu options = new JMenu("Options");
        JMenuItem reset = new JMenuItem("Reset");
        JMenuItem exit = new JMenuItem("Exit");
        JTextArea history = new JTextArea("Przykład...");
        JScrollPane historyscroll = new JScrollPane(history);
        JList functions = new JList(elements);
        JTextField expression = new JTextField("Tu wpisz wyrażenie.");
        JButton evaluate = new JButton("Evaluate!");

        options.add(reset);
        options.add(exit);
        menubar.add(options);

        historyscroll.setBounds(0,0,660,485);
        functions.setBounds(670,0,112,485);
        expression.setBounds(0,495,660,35);
        evaluate.setBounds(670,495,112,35);

        setJMenuBar(menubar);
        add(historyscroll);
        add(functions);
        add(evaluate);
        add(expression);


        /*
        double wynik;
        Expression expression = new Expression("2+8");
        System.out.println(expression.calculate());
         */

        setVisible(true);
    }
}
