package constToken;

public abstract class Token {
    protected double sign = 1;

    public abstract double calculate();
    public Token changeSign() {
        sign *= -1;
        return this;
    }
}