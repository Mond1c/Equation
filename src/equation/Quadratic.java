package equation;

import java.util.HashMap;
import java.util.Map;

public class Quadratic extends Equation {
    static class Pair <T> {
        public final T x1;
        public final T x2;

        public Pair(T x1, T x2) {
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    @Override
    public <T> T calculate() {
        double a = 0, b = 0, c = 0;
        for (variableToken.Token token : variables) {
            if (token instanceof variableToken.Quadratic) a += token.getFactor();
            else b += token.getFactor();
        }
        for (constToken.Token token : consts) {
            c += token.calculate();
        }

        if (a == 0) {
            System.out.println("No solutions (a = 0)");
            return null;
        }
        double d = b * b - 4 * a * c;
        if (d < 0) {
            System.out.println("No solutions (d < 0)");
            return null;
        }
        d = Math.sqrt(d);
        if (d == 0) {
            return (T) new Pair<Double>((-b + d) / (2 * a), 0.0);
        }
        return (T) new Pair<Double>((-b + d) / (2 * a), (-b - d) * (2 * a));
    }
}
