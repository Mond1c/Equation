package equation;


import parser.Parser;

public class Main {

    public static void main(String[] args) {
        Equation equation = Parser.parse("1x = 5");
        System.out.println((double)equation.calculate());
    }
}
