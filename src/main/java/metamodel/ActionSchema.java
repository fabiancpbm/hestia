package metamodel;

public class ActionSchema {
    private String name;
    private String parameterDefinition;

    public ActionSchema(String name, String parameterDefinition) {
        this.name = name;
        this.parameterDefinition = parameterDefinition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParameterDefinition() {
        return parameterDefinition;
    }

    public void setParameterDefinition(String parameterDefinition) {
        this.parameterDefinition = parameterDefinition;
    }

}
