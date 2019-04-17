import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.DefaultListModel;
import org.mariuszgromada.math.mxparser.Expression;

public class Frame extends JFrame implements ActionListener, MouseListener {
    private DefaultListModel<MathFunction> elements;
    private String lastexpr;

    private MathFunction sqrt;
    private MathFunction ln;
    private MathFunction rad;
    private MathFunction log;
    private MathFunction mod;
    private MathFunction round;
    private MathFunction pi;
    private MathFunction e;
    private MathFunction ks;

    private JMenuBar menubar;
    private JMenu options;
    private JMenuItem reset;
    private JMenuItem exit;
    private JTextArea history;
    private JScrollPane historyscroll;
    private JList<MathFunction> functions;
    private JTextField expression;
    private JButton evaluate;

    public Frame(){
        super("Kalkulator");

        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();      //pobieranie rozmiaru ekranu do obiektu Dimension, przechowujacego rozmiar obiektu w polach height width

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800,600);
        setLocation((int)((0.5*d.width) - 400),(int)((0.5*d.height) - 300));
        setResizable(false);
        setLayout(null);

        elements = new DefaultListModel<MathFunction>();

        sqrt = new MathFunction("pierwiastek", "sqrt()");
        ln = new MathFunction("logarytm naturalny","ln()");
        rad = new MathFunction("radian","rad()");
        log = new MathFunction("logarytm","log()");
        mod = new MathFunction("reszta","mod()");
        round = new MathFunction("zaokraglenie","round()");
        pi = new MathFunction("Archimedes","pi");
        e = new MathFunction("Euler","e");
        ks = new MathFunction("Sierpinski","[Ks]");

        elements.addElement(sqrt);
        elements.addElement(ln);
        elements.addElement(rad);
        elements.addElement(log);
        elements.addElement(mod);
        elements.addElement(round);
        elements.addElement(pi);
        elements.addElement(e);
        elements.addElement(ks);

        menubar = new JMenuBar();
        options = new JMenu("Opcje");
        reset = new JMenuItem("Resetuj");
        exit = new JMenuItem("Wyjdź");
        history = new JTextArea();
        historyscroll = new JScrollPane(history);
        functions = new JList(elements);
        expression = new JTextField();
        evaluate = new JButton("Oblicz!");

        functions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        history.setEditable(false);

        functions.addMouseListener(this);
        evaluate.addActionListener(this);

        historyscroll.setBounds(5,5,660,485);
        functions.setBounds(675,5,112,485);
        expression.setBounds(5,500,660,35);
        evaluate.setBounds(675,500,112,35);

        options.add(reset);
        options.add(exit);
        menubar.add(options);

        setJMenuBar(menubar);
        add(historyscroll);
        add(functions);
        add(evaluate);
        add(expression);

        setVisible(true);
    }

    public void mouseClicked(MouseEvent click) {
        if(click.getClickCount() == 2) {
            expression.setText(functions.getSelectedValue().getParsable());
        }
    }

    public void actionPerformed(ActionEvent click) {
        Expression exp = new Expression(expression.getText());
        history.setText(Double.toString(exp.calculate()));
    }

    public void mouseExited(MouseEvent click) {

    }

    public void mouseEntered(MouseEvent click) {

    }

    public void mouseReleased(MouseEvent click) {

    }

    public void mousePressed(MouseEvent click) {

    }
}
