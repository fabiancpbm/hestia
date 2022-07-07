import java.util.List;

public class Function {
    private int id;
    private String name;
    private String description;
    private List<Block> blocks;
    private List<Parameter> parameters;

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
}
