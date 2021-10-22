package parser;

import equation.Equation;
import equation.Linear;

public class Parser {
    public static Equation parse(String expression) {
        String[] strings = expression.split(" ");
        return parse(strings);
    }

    private static Linear parse(String[] expression) {
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

}
