package constToken;

public class Power extends Token {
    private final double number;
    private final double power;

    public Power(double number, double power) {
        this.number = number;
        this.power = power;
    }

    @Override
    public double calculate() {
        return sign * Math.pow(number, power);
    }
}
