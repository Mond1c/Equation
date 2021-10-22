package variableToken;

public abstract class Token {
    protected constToken.Token token;

    public Token(constToken.Token token) {
        this.token = token;
    }

    public double getFactor() {
        return token.calculate();
    }

    public Token mul(double coff) {
        token.mul(coff);
        return this;
    }

    public Token changeSign() {
        token.changeSign();
        return this;
    }
}
