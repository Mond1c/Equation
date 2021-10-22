package parser;

import variableToken.Linear;
import variableToken.Token;

public class VariableTokenParser {
    public static Token parse(String expression) {
        return parseLinear(expression);
    }

    private static Linear parseLinear(String expression) {
        String s = expression.substring(0, expression.indexOf('x'));
        if (s.isEmpty()) s = "1";
        else if (s.equals("-")) s = "-1";
        return new Linear(ConstTokenParser.parse(s));
    }
}
