package parser;

import constToken.Power;
import constToken.Token;
import constToken.Number;

public class ConstTokenParser {
    public static Token parse(String expression) {
        if (expression.contains("^")) return parseQuadratic(expression);
        return parseNumber(expression);
    }

    private static Number parseNumber(String expression) {
        return new Number(Double.parseDouble(expression));
    }

    private static Power parseQuadratic(String expression) {
        int it = expression.indexOf('^');
        return new Power(Double.parseDouble(expression.substring(0, it)),
                Double.parseDouble(expression.substring(it + 1)));
    }
}
