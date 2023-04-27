package br.com.chongroup.hestia.metamodel;

import java.util.List;

public class WriteInPort extends FunctionCall {

    private static final Function TARGET_FUNCTION = new Function();

    private Pin pin;

    public WriteInPort(int id, int order, Pin pin, Value argument) {
        super(id, order, TARGET_FUNCTION, List.of(argument));
        this.pin = pin;
    }
}
