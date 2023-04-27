package br.com.chongroup.hestia.metamodel;

import java.util.List;

public class FunctionCall extends Block {
    private Function targetFunction;
    private List<Value> arguments;

    public FunctionCall(int id, int order, Function targetFunction, List<Value> arguments) {
        super(id, order);
        this.targetFunction = targetFunction;
        this.arguments = arguments;
    }

    public Function getTargetFunction() {
        return targetFunction;
    }

    public void setTargetFunction(Function targetFunction) {
        this.targetFunction = targetFunction;
    }

    public List<Value> getArguments() {
        return arguments;
    }

    public void setArguments(List<Value> arguments) {
        this.arguments = arguments;
    }

}
