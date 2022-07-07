public class Topic extends Function {
    private String dataType;
    private String initialValue;
    private FacetDefinition facetDefinition;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(String initialValue) {
        this.initialValue = initialValue;
    }

    public FacetDefinition getFacetDefinition() {
        return facetDefinition;
    }

    public void setFacetDefinition(FacetDefinition facetDefinition) {
        this.facetDefinition = facetDefinition;
    }
}
