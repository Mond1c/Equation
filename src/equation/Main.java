package equation;


import parser.Parser;

public class Main {

    public static void main(String[] args) {
        Equation equation = Parser.parse("x^2 -3x -4 = 0");
        Quadratic.Pair<Double> res = equation.calculate();
        System.out.println(res.x1 + " " + res.x2);
    }
}
