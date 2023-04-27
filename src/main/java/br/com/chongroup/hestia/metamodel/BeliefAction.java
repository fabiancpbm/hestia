package br.com.chongroup.hestia.metamodel;

public class BeliefAction extends Action {

    private static final ActionSchema ACTION_SCHEMA = new ActionSchema("beliefAction", "operation;proposition");

    public BeliefAction(int id, String name, String description, int order, String operation, String proposition) {
        super(id, name, description, order, ACTION_SCHEMA, operation, proposition);

    }
}
