package interpretor.instance;

import java.util.Map;

public interface Expression {
    boolean interpret(Map<String, Long> stats);
}
