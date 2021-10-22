package parser;

import equation.Equation;
import equation.Linear;
import equation.Quadratic;

public class Parser {
    public static Equation parse(String expression) {
        String[] strings = expression.split(" ");
        if (expression.contains("^")) return parseQuadratic(strings);
        return parseLinear(strings);
    }

    private static Linear parseLinear(String[] expression) {
        Linear linear = new Linear();
        boolean left = true;
        for (String s : expression) {
            if (s.equals("=")) {
                left = false;
                continue;
            }
            if (s.contains("x")) {
                if (!left) linear.add(VariableTokenParser.parse(s).changeSign());
                else linear.add(VariableTokenParser.parse(s));
            } else {
                if (left) linear.add(ConstTokenParser.parse(s).changeSign());
                else linear.add(ConstTokenParser.parse(s));
            }
        }
        return linear;
    }

    private static Quadratic parseQuadratic(String[] expression) {
        Quadratic quadratic = new Quadratic();
        boolean left = true;
        for (String s : expression) {
            if (s.equals("=")) {
                left = false;
                continue;
            }
            if (s.contains("x")) {
                if (!left) quadratic.add(VariableTokenParser.parse(s).changeSign());
                else quadratic.add(VariableTokenParser.parse(s));
            } else {
                if (!left) quadratic.add(ConstTokenParser.parse(s).changeSign());
                else quadratic.add(ConstTokenParser.parse(s));
            }
        }
        return quadratic;
    }
}
