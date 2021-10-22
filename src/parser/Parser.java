package parser;

import equation.Equation;
import equation.Linear;
import equation.Quadratic;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class Parser {
    public static class Pair {
        List<variableToken.Token> first;
        List<constToken.Token> second;

        public Pair(List<variableToken.Token> first, List<constToken.Token> second) {
            this.first = first;
            this.second = second;
        }
    }

    public static Equation parse(String expression) {
        String[] strings = expression.split(" ");
        if (expression.contains("^")) return parseQuadratic(strings);
        return parseLinear(strings);
    }

    private static Pair getTokens(String[] expression) {
        boolean left = true;
        Stack<Double> stack = new Stack<>();
        List<variableToken.Token> variables = new ArrayList<>();
        List<constToken.Token> consts = new ArrayList<>();
        for (String s : expression) {
            if (s.equals("=")) {
                left = false;
                continue;
            }
            if (s.contains("(")) {
                String str = s.substring(0, s.indexOf('('));
                if (str.isEmpty()) str = "1";
                else if (str.equals("-")) str = "-1";
                stack.add(Double.parseDouble(str));
                continue;
            }

            if (s.contains(")")) {
                stack.pop();
                continue;
            }

            if (s.contains("x")) {
                variableToken.Token token = VariableTokenParser.parse(s);
                if (!left) token.changeSign();
                if (!stack.empty()) token.mul(stack.peek());
                variables.add(token);
            } else {
                constToken.Token token = ConstTokenParser.parse(s);
                if (left) token.changeSign();
                if (!stack.empty()) token.mul(stack.peek());
                consts.add(token);
            }
        }
        return new Pair(variables, consts);
    }

    private static Linear parseLinear(String[] expression) {
        Linear linear = new Linear();
        Pair tokens = getTokens(expression);
        List<variableToken.Token> variables = tokens.first;
        List<constToken.Token> consts = tokens.second;
        for (int i = 0; i < variables.size(); ++i) {
            linear.add(variables.get(i));
        }
        for (int i = 0; i < consts.size(); ++i) {
            linear.add(consts.get(i));
        }
        return linear;
    }

    private static Quadratic parseQuadratic(String[] expression) {
        Quadratic quadratic = new Quadratic();
        Pair tokens = getTokens(expression);
        List<variableToken.Token> variables = tokens.first;
        List<constToken.Token> consts = tokens.second;
        for (int i = 0; i < variables.size(); ++i) {
            quadratic.add(variables.get(i));
        }
        for (int i = 0; i < consts.size(); ++i) {
            quadratic.add(consts.get(i));
        }
        return quadratic;
    }
}
