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
        for (String s : expression) {
            if (s.equals("=")) {
                continue;
            }
            if (s.contains("x")) {
                linear.add(new variableToken.Linear(
                        new constToken.Number(Integer.parseInt(s.substring(0, s.indexOf('x'))))));
            } else linear.add(new constToken.Number(Integer.parseInt(s)));
        }
        return linear;
    }

}
