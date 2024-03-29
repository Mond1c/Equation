package parser;

import variableToken.Irrational;
import variableToken.Linear;
import variableToken.Quadratic;
import variableToken.Token;

public class VariableTokenParser {
    public static Token parse(String expression) {
        if (expression.contains("^")) return parseQuadratic(expression);
        return parseLinear(expression);
    }

    private static Linear parseLinear(String expression) {
        String s = expression.substring(0, expression.indexOf('x'));
        if (s.isEmpty()) s = "1";
        else if (s.equals("-")) s = "-1";
        return new Linear(ConstTokenParser.parse(s));
    }

    private static Quadratic parseQuadratic(String expression) {
        String s = expression.substring(0, expression.indexOf('x'));
        if (s.isEmpty()) s = "1";
        else if (s.equals("-")) s = "-1";
        return new Quadratic(ConstTokenParser.parse(s));
    }

    private static Irrational parseIrrational(String expression) {
        String s = expression.substring(expression.indexOf('(') + 1, expression.indexOf(')'));
        return new Irrational(ConstTokenParser.parse(s));
    }
}
