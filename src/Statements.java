import expressions.*;

import java.util.ArrayList;

/**
 * Created by bence on 2016.02.28..
 */
public class Statements {
    ArrayList<Expression> expressions;
    ArrayList<Variable> vars;
    private static Statements instance = null;

    //SINGLETON PATTERN
    protected Statements() {
        expressions = new ArrayList<Expression>();
        vars = new ArrayList<Variable>();
        instance = this;
    }

    public static Statements getInstance() {
        if (instance == null) instance = new Statements();
        return instance;
    }


    public void addExpression(Expression expr) {
        expressions.add(expr);
    }
    public ArrayList<Variable> getVars() {
        return vars;
    }

    public Variable getVarForSymbol(String s) {
        for (Variable v : vars) {
            if (s.compareTo(v.getName()) == 0) return v;
        }
        Variable v = new Variable(s,false);
        vars.add(v);
        return v;
    }

    public void printState() {
        for (Variable v: vars) {
            System.out.println(v.getName() + ": " + v.getVal());
        }
    }

    private void setTrue(int i) {
        vars.get(i).setState(true);
        int j = i + 1;
        while (j < vars.size()) {
            vars.get(j).setState(false);
            j++;
        }
    }

    private boolean nextFalseToTrue(int i) {
        int j = i +1;
        while (j < vars.size()) {
            if (vars.get(j).getVal() == false) {
                setTrue(j);
                return true;
            } else {j++;}
        }
        return false;
    }

    public boolean solve() {
        if (vars.size() == 0 || expressions.size() == 0) return true;
        Expression toSolve = new Constant(true);
        for (Expression e : expressions) {
            toSolve = new AndExpression(toSolve, e);
        }
        System.out.println(toSolve.printExpression());

        int i = vars.size() -1;
        while (i >= 0) {
            if (toSolve.getVal() == true) return true;
            if (vars.get(i).getVal() == false) {
                setTrue(i);
            } else {
                if (nextFalseToTrue(i)) {}
                else {i--;}
            }
        }

        return false;
    }

}
