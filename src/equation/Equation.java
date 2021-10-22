package equation;

import java.util.ArrayList;
import java.util.List;

public abstract class Equation {
    protected List<variableToken.Token> variables;
    protected List<constToken.Token> consts;

    public Equation() {
        variables = new ArrayList<>();
        consts = new ArrayList<>();
    }

    public void add(constToken.Token token) {
        consts.add(token);
    }

    public void add(variableToken.Token token) {
        variables.add(token);
    }

    public abstract <T> T calculate();
}
