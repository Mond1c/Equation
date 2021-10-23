package parser;

import constToken.Irrational;
import constToken.Power;
import constToken.Token;
import constToken.Number;

public class ConstTokenParser {
    public static Token parse(String expression) {
        if (expression.contains("sqrt")) return parseIrrational(expression);
        if (expression.contains("^")) return parseQuadratic(expression);
        return parseNumber(expression);
    }

    private static Number parseNumber(String expression) {
        return new Number(Double.parseDouble(expression));
    }

    private static Power parseQuadratic(String expression) {
        int it = expression.indexOf('^');
        return new Power(parse(expression.substring(0, it)).calculate(),
                parse(expression.substring(it + 1)).calculate());
    }

    private static Irrational parseIrrational(String expression) {
        return new Irrational(parse(expression.substring(expression.indexOf('(') + 1,
                expression.indexOf(')'))).calculate());
    }
}
