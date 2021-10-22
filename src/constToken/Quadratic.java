package constToken;

public class Quadratic extends Token {
    private double number;

    @Override
    public double calculate() {
        return number * number;
    }
}
