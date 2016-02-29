package expressions;

/**
 * Created by bence on 2016.02.28..
 */
public class NegateExpression implements Expression {
    private Expression expr;

    public NegateExpression(Expression expr) {
        this.expr = expr;
    }

    @Override
    public boolean getVal() {
        return !(expr.getVal());
    }

    @Override
    public String printExpression() {
        return "!" + expr.printExpression();
    }
}
