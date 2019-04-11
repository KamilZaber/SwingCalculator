import org.mariuszgromada.math.mxparser.Expression;

public class SwingCalc {
    public static void main(String args[]) {
        double wynik;
        Expression expression = new Expression("2+8");
        System.out.println(expression.calculate());
        new Frame();
    }
}
