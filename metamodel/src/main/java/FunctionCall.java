import java.util.List;

public class FunctionCall extends Block {
    private Function targetFunction;
    private List<Argument> arguments;

    public Function getTargetFunction() {
        return targetFunction;
    }

    public void setTargetFunction(Function targetFunction) {
        this.targetFunction = targetFunction;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public void setArguments(List<Argument> arguments) {
        this.arguments = arguments;
    }

}
