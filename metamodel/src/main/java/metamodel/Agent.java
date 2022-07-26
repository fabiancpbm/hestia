package metamodel;

import java.util.List;

public class Agent {
    private int id;
    private String name;
    private String description;
    private MentalState initialState;
    private List<Resource> resourcesInUse;
    private List<Plan> plans;

    public Agent(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public MentalState getInitialState() {
        return initialState;
    }

    public void setInitialState(MentalState initialState) {
        this.initialState = initialState;
    }

    public List<Resource> getResourcesInUse() {
        return resourcesInUse;
    }

    public void setResourcesInUse(List<Resource> resourcesInUse) {
        this.resourcesInUse = resourcesInUse;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

}
