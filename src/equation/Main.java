package equation;


public class Main {

    public static void main(String[] args) {
        Linear linear = new Linear();
        linear.add(new constToken.Number(10));
        linear.add(new variableToken.Linear(new constToken.Number(5)));
        System.out.println((double)linear.calculate());
    }
}
