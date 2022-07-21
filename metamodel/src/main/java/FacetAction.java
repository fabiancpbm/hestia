public class FacetAction extends Action {

    private static final ActionSchema ACTION_SCHEMA = new ActionSchema("facetAction", "facetValue");

    private FacetDefinition template;


    public FacetAction(int id, String name, String description, int order, FacetDefinition template) {
        super(id, name, description, order, ACTION_SCHEMA);
        this.template = template;
    }

    public FacetAction(int id, String name, String description, int order, FacetDefinition template, String... params) {
        super(id, name, description, order, ACTION_SCHEMA, params);
        this.template = template;
    }

    public FacetDefinition getTemplate() {
        return template;
    }

    public void setTemplate(FacetDefinition template) {
        this.template = template;
    }

    
}
