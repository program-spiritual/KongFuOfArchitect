package interpretor.instance;

import java.util.Map;

public class AlertRuleInterpreter {
    private Expression expression;

    public AlertRuleInterpreter(Expression expression) {
        this.expression = expression;
    }

    public AlertRuleInterpreter(String ruleExpression) {
        this.expression = new OrExpression(ruleExpression);
    }


    public boolean interpret(Map<String, Long> stats) {
        return expression.interpret(stats);
    }
    //<String, Long> apiStat = new HashMap<>();
    //apiStat.put("key1", 103);
    //apiStat.put("key2", 987);
}
