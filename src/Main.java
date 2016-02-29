import expressions.Constant;
import expressions.Expression;
import expressions.NegateExpression;
import expressions.OrExpression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static Expression MakeExpression(String from) {
        from = from.replaceAll("\\s","");
        String[] parts = from.split("\\|");

        Expression built = new Constant(false);

        for (String s : parts) {
            if (s.length() == 0 ||  s.compareTo("|") == 0) continue;
            if (s.charAt(0) == '!') {
                s = s.substring(1);
                built = new OrExpression(new NegateExpression(Statements.getInstance().getVarForSymbol(s)), built);
            } else {
                built = new OrExpression(Statements.getInstance().getVarForSymbol(s), built);
            }
        }
        Statements.getInstance().addExpression(built);
        System.out.println(built.printExpression());
        return built;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter expression in CNF form");
        String s = "tmp";
        while (true) {
            s = br.readLine();
            if (s.length() > 0) MakeExpression(s);
            else break;
        }

        if (Statements.getInstance().solve()) {
            System.out.println("Satisfiable! \nA possible solution:");
            Statements.getInstance().printState();
        } else {

            System.out.println("Unsatisfiable!");
        }
    }
}
