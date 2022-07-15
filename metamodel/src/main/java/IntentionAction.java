public class IntentionAction extends Action {
    public IntentionAction(int id, String name, String description, int order) {
        super(id, name, description, order);
    }

    public IntentionAction(int id, String name, String description, int order, String... params) {
        super(id, name, description, order, params);
    }
}
