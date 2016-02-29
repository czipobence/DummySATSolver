package expressions;

/**
 * Created by bence on 2016.02.28..
 */
public abstract class TwoArgumentExpression implements Expression {
    protected Expression lhs;
    protected Expression rhs;

    public TwoArgumentExpression(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public boolean getVal() {return doOperation(rhs.getVal(), lhs.getVal());}


    protected abstract boolean doOperation(boolean val, boolean val1);

}
