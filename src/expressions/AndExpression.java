package expressions;

/**
 * Created by bence on 2016.02.28..
 */
public class AndExpression extends TwoArgumentExpression {
    public AndExpression(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    @Override
    protected boolean doOperation(boolean val, boolean val1) {
        return val && val1;
    }

    @Override
    public String printExpression() {
        return "(" +  lhs.printExpression() + "&" + rhs.printExpression() + ")";
    }
}
