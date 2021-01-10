package interpretor.better;

import java.util.Deque;
import java.util.LinkedList;

public class ExpressionInterpreter {
    private final Deque<Expression> numbers = new LinkedList<>();

    public long interpret(String expression) {
        String[] elements = expression.split(" ");
        int length = elements.length;
        for (int i = 0; i < (length + 1) / 2; ++i) {
            numbers.addLast(new NumberExpression(elements[i]));
        }
        for (int i = (length + 1) / 2; i < length; ++i) {
            String operator = elements[i];
            boolean isValid = "+".equals(operator) || "-".equals(operator) || "*".equals(operator) || "/".equals(operator);
            if (!isValid) {
                throw new RuntimeException("Expression is invalid: " + expression);
            }
            Expression exp1 = (Expression) numbers.pollFirst();
            Expression exp2 = (Expression) numbers.pollFirst();
            Expression combinedExp = null;
            switch (operator) {
                case "+":
                    combinedExp = new AdditionExpression(exp1, exp2);
                    break;
                case "-":
                    combinedExp = new SubstractionExpression(exp1, exp2);
                    break;
                case "*":
                    combinedExp = new MultiplicationExpression(exp1, exp2);
                    break;
                default:
                    combinedExp = new DivisionExpression(exp1, exp2);
                    break;
            }
            long result = combinedExp.interpret();
            numbers.addFirst(new NumberExpression(result));
        }
        if (numbers.size() != 1) {
            throw new RuntimeException("Expression is invalid: " + expression);
        }
        return numbers.pop().interpret();
    }
}
