package equation;


import parser.Parser;

public class Main {

    public static void main(String[] args) {
        Equation equation = Parser.parse("x -5 = 0");
        System.out.println((double)equation.calculate());
    }
}
