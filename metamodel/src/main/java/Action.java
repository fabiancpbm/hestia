import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Action {

    protected int id;

    protected String name;

    protected String description;

    protected List<String> params;
    protected int order;

    public Action(int id, String name, String description, int order) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.order = order;
    }

    public Action(int id, String name, String description, int order, String... params) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.order = order;
        this.params = Arrays.asList(params);
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

}
