package metamodel;

import java.util.Arrays;
import java.util.List;

public class Action {

    private static final ActionSchema DEFAULT_ACTION_SCHEMA = new ActionSchema("defaultAction", "actionName;[params]");

    protected int id;

    protected String name;

    protected String description;

    private ActionSchema actionSchema;

    protected List<String> params;

    protected int order;

    public Action(int id, String name, String description, int order, ActionSchema actionSchema) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.order = order;
        this.actionSchema = actionSchema;
    }

    public Action(int id, String name, String description, int order, ActionSchema actionSchema, String... params) {
        this(id, name, description, order, actionSchema);
        this.params = Arrays.asList(params);
    }

    public Action(int id, String name, String description, int order) {
        this(id, name, description, order, DEFAULT_ACTION_SCHEMA);
    }

    public Action(int id, String name, String description, int order, String... params) {
        this(id, name, description, order, DEFAULT_ACTION_SCHEMA, params);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public ActionSchema getActionSchema() {
        return actionSchema;
    }

    public void setActionSchema(ActionSchema actionSchema) {
        this.actionSchema = actionSchema;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}
