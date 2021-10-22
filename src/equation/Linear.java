package equation;

public class Linear extends Equation {
    @Override
    public <T> T calculate() {
        double left = 0, right = 0;
        for (constToken.Token token : consts) {
            right += token.calculate();
        }
        for (variableToken.Token token : variables) {
            left += token.getFactor();
        }
        return (T)(new Quadratic.Pair<Double>(right / left, 0.0));
    }
}
