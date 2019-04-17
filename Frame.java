import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.text.MessageFormat;
import javax.swing.DefaultListModel;
import org.mariuszgromada.math.mxparser.Expression;

public class Frame extends JFrame implements ActionListener, MouseListener, KeyListener {
    private DefaultListModel<MathFunction> model;
    private String lastexpr;
    private String lastresult;

    private MathFunction sqrt;
    private MathFunction ln;
    private MathFunction rad;
    private MathFunction log;
    private MathFunction mod;
    private MathFunction round;
    private MathFunction pi;
    private MathFunction e;
    private MathFunction ks;
    private MathFunction last;

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

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800,600);
        setLocation((int)((0.5*d.width) - 400),(int)((0.5*d.height) - 300));
        setResizable(false);
        setLayout(null);

        model = new DefaultListModel<MathFunction>();

        sqrt = new MathFunction("pierwiastek", "sqrt()");
        ln = new MathFunction("logarytm naturalny","ln()");
        rad = new MathFunction("radian","rad()");
        log = new MathFunction("logarytm","log()");
        mod = new MathFunction("reszta","mod()");
        round = new MathFunction("zaokraglenie","round()");
        pi = new MathFunction("Archimedes","pi");
        e = new MathFunction("Euler","e");
        ks = new MathFunction("Sierpinski","[Ks]");
        last = new MathFunction("ostatni wynik","last");

        model.addElement(sqrt);
        model.addElement(ln);
        model.addElement(rad);
        model.addElement(log);
        model.addElement(mod);
        model.addElement(round);
        model.addElement(pi);
        model.addElement(e);
        model.addElement(ks);
        model.addElement(last);

        menubar = new JMenuBar();
        options = new JMenu("Opcje");
        reset = new JMenuItem("Resetuj");
        exit = new JMenuItem("Wyjdź");
        history = new JTextArea();
        historyscroll = new JScrollPane(history);
        functions = new JList(model);
        expression = new JTextField();
        evaluate = new JButton("Oblicz!");

        functions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        history.setEditable(false);

        functions.addMouseListener(this);
        evaluate.addActionListener(this);
        expression.addActionListener(this);
        expression.addKeyListener(this);
        reset.addActionListener(new MyActionListener(history,expression));
        exit.addActionListener(new MyActionListener2());

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

        expression.requestFocus();
    }

    public void mouseClicked(MouseEvent click) {
        MathFunction f;
        String toparse;
        String previous;
        if(click.getClickCount() == 2) {
            f = functions.getSelectedValue();
            toparse = f.getParsable();
            previous = expression.getText();
            if(toparse == "last") {
                expression.setText(previous + lastresult);
            }else {
                expression.setText(previous + toparse);
                if(functions.getSelectedIndex()<=5) {
                    expression.setCaretPosition(expression.getText().length() - 1);
                }else {
                    expression.setCaretPosition(expression.getText().length());
                }
            }
        }
        expression.requestFocus();
    }

    public void mouseExited(MouseEvent click) {

    }

    public void mouseEntered(MouseEvent click) {

    }

    public void mouseReleased(MouseEvent click) {

    }

    public void mousePressed(MouseEvent click) {

    }

    public void actionPerformed(ActionEvent process) {
        lastexpr = expression.getText();
        Expression exp = new Expression(lastexpr);
        String toarea = "{0} \n          = {1}" + "\n------\n";
        if(exp.checkSyntax()) {
            lastresult = Double.toString(exp.calculate());
            MessageFormat mf = new MessageFormat(toarea);
            history.setText(history.getText() + mf.format(new Object[]{lastexpr,lastresult}));
            expression.setText("");
        }else {
            JOptionPane.showMessageDialog(null,"Nieprawidłowa składnia!","Błąd",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void keyPressed(KeyEvent pressed) {
        if(pressed.getKeyCode() == KeyEvent.VK_UP) {
            expression.setText(lastexpr);
        }
    }

    public void keyReleased(KeyEvent released) {
    }

    public void keyTyped(KeyEvent typed) {
    }
}
