package constToken;

public class Irrational extends Token {
    private final double number;

    public Irrational(double number) {
        this.number = number;
    }

    @Override
    public double calculate() {
        return Math.sqrt(number);
    }
}
