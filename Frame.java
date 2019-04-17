import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.DefaultListModel;

public class Frame extends JFrame {
    public Frame() {
        super("Kalkulator");

        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();      //pobieranie rozmiaru ekranu do obiektu Dimension, przechowujacego rozmiar obiektu w polach height width

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800,600);
        setLocation((int)((0.5*d.width) - 400),(int)((0.5*d.height) - 300));
        setResizable(false);
        setLayout(null);

        DefaultListModel<MathFunction> elements = new DefaultListModel<MathFunction>();
        String lastexpr;

        MathFunction sqrt = new MathFunction("pierwiastek", "sqrt()");
        MathFunction ln = new MathFunction("logarytm naturalny","ln()");
        MathFunction rad = new MathFunction("radian","rad()");
        MathFunction log = new MathFunction("logarytm","log()");
        MathFunction mod = new MathFunction("reszta","mod()");
        MathFunction round = new MathFunction("zaokraglenie","round()");
        MathFunction pi = new MathFunction("Archimedes","pi");
        MathFunction e = new MathFunction("Euler","e");
        MathFunction ks = new MathFunction("Sierpinski","[Ks]");

        elements.addElement(sqrt);
        elements.addElement(ln);
        elements.addElement(rad);
        elements.addElement(log);
        elements.addElement(mod);
        elements.addElement(round);
        elements.addElement(pi);
        elements.addElement(e);
        elements.addElement(ks);

        JMenuBar menubar = new JMenuBar();
        JMenu options = new JMenu("Opcje");
        JMenuItem reset = new JMenuItem("Resetuj");
        JMenuItem exit = new JMenuItem("Wyjdź");
        JTextArea history = new JTextArea();
        JScrollPane historyscroll = new JScrollPane(history);
        final JList<MathFunction> functions = new JList(elements);
        final JTextField expression = new JTextField();
        JButton evaluate = new JButton("Oblicz!");

        functions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        history.setEditable(false);

        functions.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent click) {
                if(click.getClickCount() == 2) {
                    expression.setText(functions.getSelectedValue().getParsable());
                }
            }
        });

        evaluate.addActionListener(new Action);

        options.add(reset);
        options.add(exit);
        menubar.add(options);

        historyscroll.setBounds(5,5,660,485);
        functions.setBounds(675,5,112,485);
        expression.setBounds(5,500,660,35);
        evaluate.setBounds(675,500,112,35);

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
