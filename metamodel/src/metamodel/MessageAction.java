package metamodel;

public class MessageAction extends Action {

    private static final ActionSchema ACTION_SCHEMA = new ActionSchema("messageAction", "to;message");

    public MessageAction(int id, String name, String description, int order) {
        super(id, name, description, order, ACTION_SCHEMA);
    }

    public MessageAction(int id, String name, String description, int order, Agent to, String message) {
        super(id, name, description, order, ACTION_SCHEMA, String.valueOf(to.getId()), message);
    }
}
