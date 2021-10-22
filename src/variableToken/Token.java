package variableToken;

public abstract class Token {
    protected constToken.Token token;

    public Token(constToken.Token token) {
        this.token = token;
    }

    public double getFactor() {
        return token.calculate();
    }
    public Token changeSign() {
        token.changeSign();
        return this;
    }
}
