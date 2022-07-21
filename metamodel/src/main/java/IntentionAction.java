public class IntentionAction extends Action {

    private static final ActionSchema ACTION_SCHEMA = new ActionSchema("intentionAction", "intention");

    public IntentionAction(int id, String name, String description, int order) {
        super(id, name, description, order, ACTION_SCHEMA);
    }

    public IntentionAction(int id, String name, String description, int order, String... params) {
        super(id, name, description, order, ACTION_SCHEMA, params);
    }
}
