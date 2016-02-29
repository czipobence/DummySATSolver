package expressions;

/**
 * Created by bence on 2016.02.28..
 */
public class Constant implements Expression {
    private boolean val;

    public Constant(boolean val) {
        this.val = val;
    }

    @Override
    public boolean getVal() {
        return val;
    }

    @Override
    public String printExpression() {
        if (val) return "1";
        return "0";
    }


}
