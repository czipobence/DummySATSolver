package expressions;

/**
 * Created by bence on 2016.02.28..
 */
public class Variable implements Expression {
    private String name;
    boolean state;

    public void setState(boolean state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public Variable(String name, boolean state) {

        this.name = name;
        this.state = state;

    }

    @Override
    public boolean getVal() {
        return state;
    }

    @Override
    public String printExpression() {
        return name;
    }
}
