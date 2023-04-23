package br.com.chongroup.hestia.metamodel;

public class Command extends Function {
    private FacetDefinition facetDefinition;

    public Command(int id, String name, String description) {
        super(id, name, description);
    }

    public FacetDefinition getFacetDefinition() {
        return facetDefinition;
    }

    public void setFacetDefinition(FacetDefinition facetDefinition) {
        this.facetDefinition = facetDefinition;
    }

}
