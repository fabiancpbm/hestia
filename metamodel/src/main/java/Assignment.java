import java.util.List;

public class Assignment extends FunctionCall {
    private Value variable;

    public Assignment(int id, int order, Function targetFunction, List<Value> arguments, Value variable) {
        super(id, order, targetFunction, arguments);
        this.variable = variable;
    }

    public Value getVariable() {
        return variable;
    }

    public void setVariable(Value variable) {
        this.variable = variable;
    }

}
