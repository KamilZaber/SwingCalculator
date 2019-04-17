public class MathFunction {
    private String name;
    private String parsable;

    public MathFunction(String name, String parsable) {
        this.name = name;
        this.parsable = parsable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParsable() {
        return parsable;
    }

    public void setParsable(String parseable) {
        this.parsable = parseable;
    }

    public String toString() {
        return name;
    }
}
