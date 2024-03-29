package constToken;

public class Number extends Token {
    private final double number;

    public Number(double number) {
        this.number = number;
    }

    @Override
    public double calculate() {
        return sign * number;
    }
}
