public class FacetAction extends Action {

    public FacetAction(int id, String name, String description, int order) {
        super(id, name, description, order);
    }

    public FacetAction(int id, String name, String description, int order, String... params) {
        super(id, name, description, order, params);
    }

    private FacetDefinition template;

    public FacetDefinition getTemplate() {
        return template;
    }

    public void setTemplate(FacetDefinition template) {
        this.template = template;
    }

    
}
